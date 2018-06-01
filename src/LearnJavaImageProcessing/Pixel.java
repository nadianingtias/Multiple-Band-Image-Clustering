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
public class Pixel {
    BufferedImage image;
    int width, height;
    public Pixel(){
        try{
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
                }
            }
        }catch(Exception ex){
            System.out.println("Exception : " +ex.getMessage());
        }
        
    }
    public static void main(String[] args) {
        Pixel obj = new Pixel();
    }
}
