package chapter_3_scanning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumberInputScanning {
    public static void main(String... args) throws IOException{
        Scanner scanner = null;
        double value = 0.0;
        try{
            scanner = new Scanner(new BufferedReader(new FileReader("/home/eacuamba/vscode-workspace/java_basic_input_output/files/numbers.txt")));

            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    value += scanner.nextDouble();
                } else {
                    System.out.println(scanner.next());
                }

            }
        }finally{
if(scanner != null)
scanner.close();
        }

        System.out.printf("%n%.2f%n" , value);
    }
}
