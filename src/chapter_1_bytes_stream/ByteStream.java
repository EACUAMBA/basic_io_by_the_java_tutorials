import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {

        // create the variables
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        try {

            //Pega o ficheiro com os dados.
            fileIn = new FileInputStream("/home/eacuamba/vscode-workspace/java_basic_input_output/files/history.txt");
            
            //Cria o ficheiro onde os dados serao persistidos.
            fileOut = new FileOutputStream("/home/eacuamba/vscode-workspace/java_basic_input_output/files/ByteOutput.txt");
            
            //Armazena o numero que representa a letra na tabela ASC II, ex: A = 65, espaco = 32 etc
            byte value;

            //Pego o valor em ASC II e verifico se ele e igual a -1, quando for igual a -1 ja nao temos arquivos para ler no ficheiro
            while ((value = (byte)fileIn.read()) != -1) {
                System.out.println(value);

                //Escreve o que representa na tabela ASC II o numero que ele entregou. Se na variavel bytes temos o numero 65 o write(bytes) escrevera 65 e prontos.
                fileOut.write(value);
            }
            System.out.println(value);
        } finally {
            if (fileIn != null)
                fileIn.close();

            if (fileOut != null) {
                fileOut.flush();
                fileOut.close();
            }
        }

    }
}