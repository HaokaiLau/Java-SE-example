package edu.lhj.file_.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        String filePath = "d:\\javacode\\FileIO\\code.txt";
        BufferedReader br = null;
        String readData = "";
        int line = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((readData = br.readLine()) != null) {
                System.out.println(++line + "    " + readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
