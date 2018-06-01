/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LearnJavaImageProcessing;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author Nadian
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket soc;
        BufferedImage img = null;
        soc = new Socket("localhost",4001);
        System.out.println("Client is running");
        try{
        System.out.println("Reading image from disk");
        File input = new File("digital_image_processing.jpg");
            img = ImageIO.read(input);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            
            ImageIO.write(img, "jpg", baos);
        baos.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        System.out.println("Sending image to server");
        
            OutputStream out = soc.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(bytes.length);
        dos.write(bytes, 0, bytes.length);
        System.out.println("Image sent to server");
        dos.close();
        out.close();
        }catch(Exception ex){
            System.out.println("Exception : "+ex.getMessage());
            soc.close();
        }
            soc.close();
    }
    
}
