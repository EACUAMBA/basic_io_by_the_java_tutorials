package chapter_7_object_streams;

import java.io.*;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

/*
 * Author: Edilson Alexandre Cuamba
 * Data: 5/12/2021
 */
public class ObjectStreamsContext {
    static final String path = "C:\\Users\\EACUAMBA\\IdeaProjects\\Basic_I-O_The_Java_Tutorials\\files\\InvoiceData.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        write(gerarFacturas());
        read();



    }
    public static void read()throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
try{
    Factura factura = ((Factura)objectInputStream.readObject());
    System.out.println(factura.getCodigo());
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    System.out.println(sdf.format(factura.getDataDeCompra().getTime().getTime()));
    System.out.printf("%-30s %10s %10s%n", "Produto","Qauntidade", "Preco");
    BigDecimal total = BigDecimal.ZERO;
    for(int i =0; i< factura.getProdutos().length; i++){
        System.out.printf("%-30s %-10d %10.2f%n", factura.getProdutos()[i],  factura.getQuantidadde()[i], factura.getPrecos()[i]);
        total = total.add(factura.getPrecos()[i].multiply(BigDecimal.valueOf(factura.getQuantidadde()[i])));
    }
    System.out.println();
    System.out.println("Voce vai pagar: " + total.doubleValue());
}catch (EOFException e){
    System.out.println(e.getMessage());
}


    }
    public static void write(Factura factura)  throws IOException, ClassNotFoundException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        objectOutputStream.writeObject(factura);
        objectOutputStream.close();
    }
    public static Factura gerarFacturas(){
        String[] produtos = {"Garrafa de Agua", "Lata de Sardinha", "Pacote de Massa Sasseka", "Bolacha Maria"};
        BigDecimal[] precos = {BigDecimal.valueOf(15.79), BigDecimal.valueOf(40.30), BigDecimal.valueOf(25.90), BigDecimal.valueOf(10.50)};
        Calendar data = Calendar.getInstance();
        data.set(2021, 10, 3);


        Factura factura = new Factura(UUID.randomUUID().toString(), produtos, precos, data, new int[]{7, 6, 5, 3});
        return factura;
    }

}
class Factura implements Serializable{
    private String codigo;
    private String[] produtos = new String[3];
    private BigDecimal[] precos = new BigDecimal[3];
    private Calendar dataDeCompra;
    private int[] quantidadde;

    public Factura() {
    }

    public Factura(String codigo, String[] produtos, BigDecimal[] precos, Calendar dataDeCompra, int[] quantidadde) {
        this.codigo = codigo;
        this.produtos = produtos;
        this.precos = precos;
        this.dataDeCompra = dataDeCompra;
        this.quantidadde =quantidadde;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo='" + codigo + '\'' +
                ",\n produtos=" + Arrays.toString(produtos) +
                ",\n precos=" + Arrays.toString(precos) +
                ",\n dataDeCompra=" +  +
                '}';
    }
public int[] getQuantidadde(){
        return this.quantidadde;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String[] getProdutos() {
        return produtos;
    }

    public void setProdutos(String[] produtos) {
        this.produtos = produtos;
    }

    public BigDecimal[] getPrecos() {
        return precos;
    }

    public void setPrecos(BigDecimal[] precos) {
        this.precos = precos;
    }

    public Calendar getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(Calendar dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }
}
