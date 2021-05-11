package chapter_4_formatting;

public class Formatting {
    public static void main(String[] args) {
        int value = 5;
        double result = Math.pow(value, 2);

        System.out.format("The pow of %d is %.1f.%n", value, result);
    }
}
