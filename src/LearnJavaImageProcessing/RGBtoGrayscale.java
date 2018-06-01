/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearnJavaImageProcessing;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 *
 * @author Nadian
 */
public class RGBtoGrayscale {
    BufferedImage image;
    int width, height;
    public RGBtoGrayscale(){
        try{
//            File input = new File("ieee.jpg");
            File input = new File("ieee.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            int count=0;
            for(int i=0 ; i<height ; i++){
                for(int j=0 ; j<width ; j++){
                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println("S.No: "+ count + " Red: "+ c.getRed()+ " Green: "+ c.getGreen() +" Blue: "+ c.getBlue());
                    int red = (int)(c.getRed()*0.299);
                    int green = (int)(c.getGreen()*0.587);
                    int blue = (int)(c.getBlue()*0.114);
                    int gray =red+green+blue;
                    Color newColor = new Color(gray, gray, gray);
                        image.setRGB(j, i, newColor.getRGB());
                    Color c2 = new Color(image.getRGB(j, i));
//                    System.out.println("S.No: "+ count + " Red: "+ c2.getRed()+ " Green: "+ c2.getGreen() +" Blue: "+ c2.getBlue());
                }
            }
        File output = new File("grayscale.jpg");
        ImageIO.write(image, "png", output);
            
        }catch(Exception ex){
            System.out.println("Exception : " +ex.getMessage());
        }
        
    }
    public static void main(String[] args) {
        RGBtoGrayscale obj = new RGBtoGrayscale();
    }
}
