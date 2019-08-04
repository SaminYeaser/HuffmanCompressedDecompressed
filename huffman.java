/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decompress;

/**
 *
 * @author 17301063
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
public class huffman {
    public static void main(String... ignored) throws FileNotFoundException, UnsupportedEncodingException {
    //Size in Gbs of my file that I want
    double wantedSize = Double.parseDouble(System.getProperty("size", "7.1695"));

    Random random = new Random();
    File file = new File("AvgNumbers.txt");
    long start = System.currentTimeMillis();
    PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")), false);
    int counter = 0;
    while (true) {
        String sep = "";
        for (int i = 0; i < 100; i++) {
            int number = random.nextInt(1000) + 1;
            char a = (char)(number/256);
            writer.print(sep);
            writer.print(a);
            sep = " ";
        }
        writer.println();
        //Check to see if the current size is what we want it to be
        if (++counter == 20000) {
            System.out.printf("Size: %.3f GB%n", file.length() / 1e9);
            if (file.length() >= wantedSize * 1e9) {
                writer.close();
                break;
            } else {
                counter = 0;
            }
        }
    }
    long time = System.currentTimeMillis() - start;
    System.out.printf("Took %.1f seconds to create a file of %.3f GB", time / 1e3, file.length() / 1e9);
}
}

