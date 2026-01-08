package com.linearandbinarysearch.inputstream;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleToFile {
    public static void main(String[] args) {

        try {
            //  Read input from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            //  Write output to file
            FileWriter fw = new FileWriter("output.txt");

            System.out.println("Enter text (type 'exit' to stop):");

            String input;

          
            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(input + "\n");  // write each input on new line
            }


            fw.close();
            br.close();
            isr.close();

            System.out.println("Input saved to file successfully!");

        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}
