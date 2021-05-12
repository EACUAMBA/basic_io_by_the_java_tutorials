package chapter_6_data_streams;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/*
 * Author: Edilson Alexandre Cuamba
 * Data: 5/12/2021
 */
public class DataStremsContext {
    static final String path = "C:\\Users\\EACUAMBA\\IdeaProjects\\Basic_I-O_The_Java_Tutorials\\files\\InvoiceData.txt";
    static final double[] prices = {19.99, 18.44, 28.90, 43, 55.12};
    static final int[] units = {2, 3, 1, 5, 6};
    static final String[] descriptions = {"Shoes", "Wear", "Jumper TS", "Hat Ui", "Gloves OP"};

    public static void main(String[] args) throws IOException {
        write();
        read();

    }
    public static void read() throws IOException{
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));

        double price;
        int unit;
        String decs;
        double total = 0;
        try{
            while(true){
                price = dataInputStream.readDouble();
                unit = dataInputStream.readInt();
                decs = dataInputStream.readUTF();

                System.out.printf("%nYou ordered %d of %s it will costs %.2f.", unit, decs, price);
                total += price*unit;
            }
        }catch (EOFException e){
            System.out.println("End of file achieved. Error: " + e.getMessage());
        }
        System.out.println("Your will pay in total: " + total);
    }
    public static void write() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));

        for(int i = 0; i< descriptions.length; i++){
            dataOutputStream.writeDouble(prices[i]);
            dataOutputStream.writeInt(units[i]);
            dataOutputStream.writeUTF(descriptions[i]);
            //System.out.printf("%nYou ordered %d of %s it will costs %05.2f.%n", units[i], descriptions[i], prices[i]);
            System.out.println("Writing...");
        }
//        System.out.println(dataOutputStream.size());
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
