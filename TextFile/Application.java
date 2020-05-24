import java.util.Scanner;
/**
 * Application class creates object of the TextFile class
 * asks user for five inputs that would be written to a file and then read
 *
 * @author Luisely Doza
 * @version April 3, 2020
 */
public class Application { 
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        //Asking user for five inputs
        System.out.println("Please type your first name:");
        String first = scan.nextLine();
        System.out.println("Please type your last name:");
        String last = scan.nextLine();
        System.out.println("Please type your address:");
        String address = scan.nextLine();
        System.out.println("Please type your country:");
        String country = scan.nextLine();
        System.out.println("Please type your birth date:");
        String birthDate = scan.nextLine();
        
        //Creating and writing the file
        System.out.println("Creating and writing to file....\n...\n..\n.");
        TextFile text = new TextFile();
        text.writeFile(first, last, address, country, birthDate);
        
        //Reading the file just wrote
        System.out.println("Reading file....\n...\n..\n.");
        text.readFile();
    }
}
