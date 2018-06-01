/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultibandImage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Nadian
 */
public class BandImage {
    BufferedImage image;
    File file;
    int height;
    int width;
    int[][] grayscale = new int[height][width];

    public BandImage() {
    }
    
    public BandImage(File file) {
        this.file = file;
        try {
            this.image = ImageIO.read(file);
            this.height = this.image.getHeight();
            this.width = this.image.getWidth();
//            System.out.println("height: "+height);
//            System.out.println("width: "+width);
            initGrayscale();
        } catch (Exception ex) {
            if(Integer.parseInt(ex.getMessage())!=0)
            System.out.println("Exception : "+ ex.getMessage());
//            Logger.getLogger(BandImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BandImage(int[][] grayscale) {
        this.grayscale = grayscale;
        this.height = grayscale.length;
        this.width = grayscale[0].length;
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        
        this.image = image;
    }
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] getGrayscale() {
        return grayscale;
    }

    public void setGrayscale(int[][] grayscale) {
        this.grayscale = grayscale;
    }

    private void initGrayscale() {
        int p,l;
        int[][] grays = new int[this.height][this.width];
        p=this.height;
        l=this.width;
        for(int x=0 ; x<p ; x=x+1){
                for(int y=0 ; y<l ; y=y+1){
//                    System.out.println("cek"+x);
                    Color c = new Color(this.image.getRGB(y, x));
//                    System.out.println("cek");
//                    System.out.println("S.No: "+ x +" "+ y +  " Red: "+ c.getRed()+ " Green: "+ c.getGreen() +" Blue: "+ c.getBlue());
                    int red = (int)(c.getRed()*0.299);
                    int green = (int)(c.getGreen()*0.587);
                    int blue = (int)(c.getBlue()*0.114);
                    int gray =red+green+blue;
                    grays[x][y]=gray;
                }
        }
        this.grayscale = grays;
//        for(int i=0 ; i<this.height;i++){
//            for(int j=0;j<this.width;j++){
//                System.out.print(this.grayscale[i][j]+" ");
//            }
//            System.out.println("\n");
//        }
    }
    
}
