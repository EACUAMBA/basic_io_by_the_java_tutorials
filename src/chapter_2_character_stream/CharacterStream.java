import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream{
    public static void main(String[] args) throws IOException{
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        char value;

        try{
            fileReader = new FileReader("/home/eacuamba/vscode-workspace/java_basic_input_output/files/history.txt");
            fileWriter = new FileWriter("/home/eacuamba/vscode-workspace/java_basic_input_output/files/CharacterOutput.txt");


            while((value = (char)fileReader.read()) != (char)-1){
                fileWriter.write(value);
                System.out.println("The value is " + value);
            }   
            System.out.println("The value is " + value);
        }finally{
            if(fileReader != null)
            fileReader.close();

            if(fileWriter != null){
                fileWriter.flush();
                fileWriter.close();
            }
        }
    }
}