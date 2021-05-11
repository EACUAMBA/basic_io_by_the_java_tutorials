package chapter_5_command_line;

import java.io.Console;
import java.util.Arrays;

public class ConsoleContext {
    public static void main(String[] args) {
        Console console = System.console();
        if(console == null){
            System.err.println("The console is not available in your system.");
            System.exit(1);
        }

        String username = console.readLine("Enter your login: ");
        char[] oldPassword = console.readPassword("Write your password: ");

        if(verify(username, oldPassword)){
            boolean noMatch;
            do{
                char[] newPasswordOne = console.readPassword("Insert the new password: ");
                char[] newPasswordTwo = console.readPassword("Re-insert the new password: ");

                noMatch = !Arrays.equals(newPasswordOne, newPasswordTwo);

                if(noMatch){
                    console.format("The password entered for %s don't match. Please re-insert.", username);
                }else{
                    change(newPasswordOne, newPasswordTwo);
                    console.format("The password for %s was successful changed.", username);
                }
                Arrays.fill(newPasswordOne, Character.MIN_VALUE);
                Arrays.fill(newPasswordTwo, Character.MIN_VALUE);

            }while(noMatch);
        }
        Arrays.fill(oldPassword, Character.MIN_VALUE);
    }

    public static boolean verify(String username, char[] password){
        return true;
    }

    public static void change(char[] pass1, char[] pass2){

    }
}
