package chapter_3_scanning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextInputScanning {
    public static void main(String... args) throws IOException{
        Scanner scanner = null;
        String value = "";
        try{
            scanner = new Scanner(new BufferedReader(new FileReader("/home/eacuamba/vscode-workspace/java_basic_input_output/files/history.txt")));
            System.out.println(scanner.delimiter());

            while (scanner.hasNext()) {
                    System.out.println((value += scanner.next() + " "));

            }
        }finally{
if(scanner != null)
scanner.close();
        }

        System.out.printf("%n%s%n" , value);
    }
}
