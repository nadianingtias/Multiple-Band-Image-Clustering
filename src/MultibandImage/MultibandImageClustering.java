/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultibandImage;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nadian
 */
public class MultibandImageClustering {
    private static ArrayList<BandImage> bandImages = new ArrayList<>();
    private static ArrayList<Point> trainingPoints = new ArrayList<>();
    private static ArrayList<Point> centroid = new ArrayList<>();
    private static ArrayList<Color> colorKluster = new ArrayList<>();
    
    static int locHeight, locWidth;
    private static double[][] cArrayDistances = new double[locHeight*locWidth][locHeight*locWidth]; //prepare matriks jarak
    
    private static int nBand, k;
    private static String[] path = new String[nBand];
    
    private static Scanner scanner = new Scanner(System.in);
    private static NumberFormat formatter = new DecimalFormat("#0.00");  
    
    public static void main(String[] args) {
        //---------------1. Loading band image 1-nBand masukkan arraylist of BandImage //2. loading band image 2
        System.out.print("1. Masukkan jumlah image bands: ");
            nBand = scanner.nextInt();
            path = new String[nBand];
        loadBands(nBand);
        System.out.println("=> "+nBand+" Bands LOADED");
        if(!bandImages.isEmpty()){
            locHeight = bandImages.get(0).getHeight(); //ukuran gambar
            locWidth = bandImages.get(0).getWidth(); //ukuran gambar
        }
        //---------------2. generate data set from 6 band (indexes)
        //out : trainingPoints terisi, centroid terisi (array of point that called centroid of training set)
        initDataPoint(locHeight, locWidth);
        initLabelCentroid(trainingPoints); //trainingpoint diberi label sesuai banyaknya trainingpoint
        //printPointDataLabelOnly(trainingPoints);
        System.out.println("2. Data Set From 6 Bands LOADED : trainingPoints, initial centroid");

        //-- additional : EQUIPMENTS CHECKS
        //mencetak trainingpoints dan inisial centroid didapat
        System.out.println("=> trainingPoints LOADED");
        printPointData(trainingPoints);
        System.out.println("------------------------ jumlah trainingPoints: " + trainingPoints.size());
        System.out.println("=> centroid LOADED");
//        printPointData(centroid);
        System.out.println("------------------------ jumlah centroid: " + centroid.size());

        //---------------3. tentukan k
        System.out.print("3. Tentukan banyak kluster (k) : ");
            k = scanner.nextInt();
        
        while(centroid.size()>k){
            //DO THE HIRARCHICAL CLUSTERING ALGORITHM
            //---------------4. hitung jarak, buat matriksnya [matriks jarak]
            makeCentArrayDistances(); 

            //---------------5. cari angka minimum dari matriks jarak
            double minDistance = getMinValueOf2DDouble(cArrayDistances);
            System.out.println("5. Tentukan Jarak minimum: " +minDistance);

            //---------------6. cari index dari angka minimum matriks jarak
            int[] indexOfMinDistance = getIndexOf2D(cArrayDistances, minDistance); //3. mencari index (2 kluster terdekat) dari nilai minimum jarak centroid
            System.out.println("=> index Merge (Cluster that will be merged) : " + indexOfMinDistance[0] +"  --and-- "+indexOfMinDistance[1]);

            //---------------7. Gabungkan 2 Kluster yang terdekat
            centroid = doMergeCluster(centroid, indexOfMinDistance);
            //---------------8. Update data set dengan label kluster yang baru
            trainingPoints = rearrangeLabelCentroid(trainingPoints, indexOfMinDistance);
            //---------------9. Cetak Data dengan LABEL updated
            System.out.println("=> Data Training IRIS after arrange :");
//            printPointData(trainingPoints);
            //printPointDataLabelOnly(trainingPoints); //HASIL PELABELAN ONLY
            
            System.out.println("\n==============="+centroid.size()+"===============\n\n");
        }
        printPointData(trainingPoints); // trainingPoints adalah daata dg label tekluster sebanyak k
//        printPointDataLabelOnly(trainingPoints);

        //RESULT preparation
        colorKluster = getDistinctColor(k);
        BufferedImage bimage = new BufferedImage(locHeight, locWidth, BufferedImage.TYPE_INT_ARGB);
        bimage = buildImageResult(locHeight,locWidth,k);
        showInJFrame(bimage);
        //TODO: menggambar 32*32 gambar dari trainingPoints
        //Range (1-255) tentukan range warna Color newColor = new Color(gray, gray, gray);
        //Color[] resultColorCluters = new Color[centroid.size()];
        
        
//        System.out.println("he : " +newone.getHeight());
//        System.out.println("wi : " +newone.getWidth());
        //3. get grayscale value b - di kelas tersendiri
        //4. get size of arraylist BandImage hitung jarak
        // cArrayDistances[i][j] = getDistanceValue(bandimages.size())
        // Math.sqrt(Math.pow(dist.getmIndex1(),2)+Math.pow(dist.getmIndex2(),2)+Math.pow(dist.getmIndex3(),2)+Math.pow(dist.getmIndex4(),2));
    }

    private static void printPointData(ArrayList<Point> Points) {
        int counter=0;
        for (Point point : Points) {        //print datatraining
            int[] tempIndex = new int[point.getmIndex().length];
            tempIndex = point.getmIndex();
            System.out.println(+counter+"---> "+  Arrays.toString(tempIndex) + " label: "+ point.getmLabel());
            counter++;
        }
    }

    private static void initLabelCentroid(ArrayList<Point> Points) {
        for(int i=0 ; i < Points.size() ; i++){
            Points.get(i).setmLabel(i);
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void printPointDataLabelOnly(ArrayList<Point> Points) {
        int i=1;
        for (Point point : Points) {        //print datatraining Label Only
                System.out.print(" " + point.getmLabel());
            if((i%10)==0)
                System.out.println(" ");
            i++;
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void loadBands(int nBand) {
        for(int i=0 ; i<nBand ; i++){
            path[i] = "E:\\Users\\Nadian\\Documents\\NetBeansProjects\\MultibandImageClustering\\multibanddata\\gb"+(i+1)+".GIF";
            File input = new File(path[i]);
            BandImage newBand = new BandImage(input);
            bandImages.add(newBand);
        }
        System.out.println("=> banyak array list bandimage : " + bandImages.size());
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void initDataPoint(int Height, int Width) {
        for(int i=0 ; i<locHeight ; i++){
              for(int j=0 ; j<locWidth ; j++){
                  //System.out.println("data "+i+" "+ j);
                  int[] datas = new int[bandImages.size()];
                  for(int n=0 ; n<bandImages.size();n++){
                      int[][] temp = bandImages.get(n).getGrayscale(); //band ke n diambil matrik grayscalenya
                      //System.out.print(temp[i][j]+ " ");
                      datas[n] = temp[i][j];                  
                  }
//                  System.out.println("datas : "+datas[0]+" " +datas[1]+" " +datas[2] +" " +datas[3]+" " +datas[4]+" " +datas[5] );
//                  System.out.println(" ");
                  Point trainpoint = new Point(datas); //ada sebanyak 32*32 data training terbentuk
                  //System.out.println("trainpoint "+ trainpoint.getmIndex()[0]+ " "+trainpoint.getmIndex()[1]+ " "+trainpoint.getmIndex()[2]+ " "+trainpoint.getmIndex()[3]);
                  trainingPoints.add(trainpoint);
                  centroid.add(new Point(datas));
                 
                  //int[] index = new int[2] {i,j}; 
                  //getDistance(index)
              }
         }
    }

    private static double getMinValueOf2DDouble(double[][] Array) {
        Stream<double[]> temp = Stream.of(Array);
        DoubleStream Stream = temp.flatMapToDouble(x -> Arrays.stream(x)); // Cant print Stream<int[]> directly, convert / flat it to IntStream 
        double mMinDistance = Stream.min().getAsDouble();
        return mMinDistance;
    }

    private static int[] getIndexOf2D(double[][] array2D, double value) {
        int[] var = new int[2];
        for(int i=0; i<array2D.length ; i++){
            //System.out.println(array2D.length);
//            for(int j=0; j < (i+1) ; j++){
            for(int j=0; j < (array2D.length) ; j++){
                if(array2D[i][j] == value){
                    var[0]=i;
                    var[1]=j;
                    break;
                }
            }
        }
        return var;
    }

    private static ArrayList<Point> doMergeCluster(ArrayList<Point> mCentroid, int[] varMerge) {
        IntStream stream = Stream.of(varMerge).flatMapToInt(x -> Arrays.stream(x));
            int min = stream.min().getAsInt();
            IntStream stream2 = Stream.of(varMerge).flatMapToInt(x -> Arrays.stream(x));
            int max = stream2.max().getAsInt();
            //System.out.println(min);
        
            
            int[] minIndex, maxIndex, tempIndex;
            tempIndex = new int[nBand];
            minIndex = mCentroid.get(min).getmIndex();
            maxIndex = mCentroid.get(max).getmIndex();
            //preparing new point of merged cluster
            Point dist = new Point();
            for(int i=0; i<nBand ; i++){
                tempIndex[i] = (int) (0.5 * (minIndex[i]+maxIndex[i]));
            }
            
            dist = new Point(tempIndex);
        //merge max indexed value into min indexed value
            //System.out.println("BEFORE");
            //System.out.println("=> min index: "+ min +" "+ Arrays.toString(mCentroid.get(min).getmIndex()));
            //System.out.println("=> max index: "+ max +" "+ Arrays.toString(mCentroid.get(max).getmIndex()));
            mCentroid.set(min, dist);
            mCentroid.remove(max);
            //System.out.println("BEFORE");
            //System.out.println("=> min index: "+ min +" "+ Arrays.toString(mCentroid.get(min).getmIndex()));
            //System.out.println("=> max index: "+ max +" "+ Arrays.toString(mCentroid.get(max).getmIndex()));
            return mCentroid;
    }

    private static ArrayList<Point> rearrangeLabelCentroid(ArrayList<Point> points, int[] var) {
        int max = Arrays.stream(var).max().getAsInt();
        int min = Arrays.stream(var).min().getAsInt();  
        //System.out.println("BEFORE");
        //System.out.println("=>label min: "+ points.get(min).getmLabel());
        //System.out.println("=>label max: "+ points.get(max).getmLabel());
        for(int i=0 ; i < points.size() ; i++){
            if(points.get(i).getmLabel() == max){ //label max dimerge menjadi label min
                points.get(i).setmLabel(min);
            }else if(points.get(i).getmLabel() > max && (min != max )){ //label di atas max, dikurang 1, mengikuti jumlah centroid now
                int tempLabel = points.get(i).getmLabel();
                points.get(i).setmLabel(tempLabel-1);
            }
        }
        //System.out.println("AFTER");
        //System.out.println("=>label min: "+ points.get(min).getmLabel());
        //System.out.println("=>label max: "+ points.get(max).getmLabel());
         return points;        
    }

    private static void makeCentArrayDistances() {
        cArrayDistances = new double[centroid.size()][centroid.size()];
        Point dist = new Point();
        System.out.println("=> (Matriks) Array of Distance: ");
        for(int i=0; i<centroid.size() ; i++){
            int[] iIndex = centroid.get(i).getmIndex();
//            for(int j=0; j<(i+1) ; j++){
            for(int j=0; j<(centroid.size()) ; j++){
                int[] tempIndex = new int[nBand];
                int[] jIndex = centroid.get(j).getmIndex();
                double tempcArrayDistance =0;
                for(int k=0; k<nBand ;k++){
                    //System.out.println(iIndex[k]+" - "+ jIndex[k]);
                    tempIndex[k] = iIndex[k]-jIndex[k];
                    //System.out.print(" "+tempIndex[k]);
                    tempcArrayDistance += Math.pow(tempIndex[k],2);
                }
                //System.out.println(" ");
                dist.setmIndex(tempIndex);
                //System.out.println(tempcArrayDistance);
                if(i==j)
                    cArrayDistances[i][j] = 999;
                else
                    cArrayDistances[i][j] = Math.sqrt(tempcArrayDistance);
                //System.out.print(formatter.format(cArrayDistances[i][j]) + " ");
            }
            //System.out.println(" ");
        }
        System.out.println("4. Matriks Jarak dari "+centroid.size()+" centroid LOADED");
    }

    private static ArrayList<Color> getDistinctColor(int klstr) {
        Random rand = new Random();
        ArrayList<Color> colorKlusters = new ArrayList<>();
        Color distinctColor = new Color(0,0,0);
        while(colorKlusters.size()<klstr ){
            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);
            Color newColor = new Color(r,g,b);
            if(distinctColor.getRGB()!=newColor.getRGB()){
                distinctColor = newColor;
                System.out.println(colorKlusters.size()+"distinctColor : "+ r + " " + g + " " + b );
                colorKlusters.add(distinctColor);
            }else System.out.println("Ooops");
        }
        return colorKlusters;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static BufferedImage buildImageResult(int height, int width, int kluster) {
        int count=0;
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for(int i=0 ; i<height ; i++){
                for(int j=0 ; j<width ; j++){
                    for(int k=0 ; k<kluster;k++){
                        if(trainingPoints.get(i*width+j*1).getmLabel()==k){
                            Color newColor = colorKluster.get(k);
                            bimage.setRGB(j, i, newColor.getRGB());
                            System.out.println("S.No: "+ count + " Red: "+ newColor.getRed()+ " Green: "+ newColor.getGreen() +" Blue: "+ newColor.getBlue());
                        }
                    } 
                }
            }
        return bimage;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void showInJFrame(BufferedImage buffImage) {
        JFrame f = new JFrame("Hasil Clustering"); 
            ImageIcon icon = new ImageIcon(buffImage); 
            JLabel l = new JLabel(); 
            l.setIcon(icon); 
            f.add(l); 
            f.pack(); 
            f.setVisible(true);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
