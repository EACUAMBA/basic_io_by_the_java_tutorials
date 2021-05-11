import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class LineOrientedCharacterStream {
    public static void main(String... args) throws IOException{
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try{
            bufferedReader = new BufferedReader(new FileReader("/home/eacuamba/vscode-workspace/java_basic_input_output/files/history.txt"));
            printWriter = new PrintWriter(new FileWriter("/home/eacuamba/vscode-workspace/java_basic_input_output/files/LineOrientedCharacterStream.txt"));

            String line;
            while((line = bufferedReader.readLine()) != null){
                printWriter.println(line);
                System.out.println(line);
            }
            System.out.println(line);
        }finally{
            if(bufferedReader!=null)
            bufferedReader.close();

            if(printWriter != null){
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}
