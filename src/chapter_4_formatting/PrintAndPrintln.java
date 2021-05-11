package chapter_4_formatting;
public class PrintAndPrintln{
    public static void main(String[] args) {
        int i = 5;
        double sqrtOf = Math.sqrt(i);

        System.out.print("The square of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(sqrtOf);
        System.out.print(".");

        int i2 = 25;
        double sqrtOf2 = Math.sqrt(i2);
        System.out.println("The square of " + i + " is " + sqrtOf2 + ".");
    }
}