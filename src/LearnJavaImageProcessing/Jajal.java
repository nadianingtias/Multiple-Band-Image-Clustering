package LearnJavaImageProcessing;
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.image.BufferedImage; 
 
import javax.swing.JFrame; 
import javax.swing.JPanel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nadian
 */
public class Jajal  extends JPanel{
    public static void main(String[] args) { 
      JFrame frame = new JFrame(); 
      frame.getContentPane().add(new Jajal()); 
 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setSize(200, 200); 
      frame.setVisible(true); 
   }
    
    public void paint(Graphics graphic){
        Image img = createImageWithText();
        graphic.drawImage(img, 20, 20, this);
    }
    
    private Image createImageWithText(){ 
      BufferedImage bufferedImage = new  
      BufferedImage(200,200,BufferedImage.TYPE_INT_RGB); 
      Graphics g = bufferedImage.getGraphics(); 
 
      g.drawString("www.tutorialspoint.com", 20,20); 
      g.drawString("www.tutorialspoint.com", 20,40); 
      g.drawString("www.tutorialspoint.com", 20,60); 
      g.drawString("www.tutorialspoint.com", 20,80); 
      g.drawString("www.tutorialspoint.com", 20,100); 
      return bufferedImage; 
    }   
}
