import java.util.Scanner;
/**
 * Application class asks the user for a string
 * The program then creates an object of the ReverseSentence class and prints the user's string in reverse.
 *
 * @author Luisely Doza
 * @version April 17, 2020
 */
public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please write a sentence:");
        String s = scan.nextLine();
        System.out.println("Your sentence reversed:");
        ReverseSentence reverse = new ReverseSentence(s);
    }
}
