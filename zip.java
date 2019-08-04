/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decompress;

/**
 *
 * @author Samin
 */
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.zip.DeflaterOutputStream; 
  
class zip 
{ 
    public static void main(String[] args) throws IOException { 
        DeflaterOutputStream dos; 
        //Assign compressed file:file2 to FileOutputStream
        try ( //Assign the original file : file to
        //FileInputStream for reading data
                FileInputStream fis = new FileInputStream("AvgNumbers")) {
            //Assign compressed file:file2 to FileOutputStream
            FileOutputStream fos=new FileOutputStream("AvgNumbers2");
            //Assign FileOutputStream to DeflaterOutputStream
            dos = new DeflaterOutputStream(fos);
            //read data from FileInputStream and write it into DeflaterOutputStream
            int data;
            while ((data=fis.read())!=-1)
            {
                dos.write(data);
            }
            
            //close the file 
        } 
        dos.close(); 
    } 
} 
