/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearnJavaImageProcessing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Nadian
 */
public class assignDistinctColor {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] intrand = new int[1024];
        int klstr = 10;
        ArrayList<Color> colorKluster = new ArrayList<>();
        Color distinctColor = new Color(0,0,0);
            
        while(colorKluster.size()<klstr ){
            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);
            Color newColor = new Color(r,g,b);
            if(distinctColor.getRGB()!=newColor.getRGB()){
                distinctColor = newColor;
                System.out.println(colorKluster.size()+"distinctColor : "+ r + " " + g + " " + b );
                colorKluster.add(distinctColor);
            }else System.out.println("Ooops");
        }
    }
}
