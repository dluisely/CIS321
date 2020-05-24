import java.io.*;
import java.util.Scanner;
/**
 * Program is able to read files or create and write to files
 *
 * @author Luisely Doza
 * @version April 3, 2020
 */
public class TextFile {
    /**
     * This method reads a file and will throw an exception if not found
     */
    public void readFile() {
        Scanner file = null;
        try {
            file = new Scanner(new File("student.txt")); //locate file
            //read and print out textfile
            while (file.hasNextLine()) {
                String line = file.nextLine();
                System.out.println(line);
            }
            file.close(); //close file
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    /**
     * This method writes a file and will throw an exception if unable to create the file
     * 
     * @param first student first name
     * @param last student last name
     * @param address student's address
     * @param country student's country
     * @param birthDate student's date of birth
     */
    public void writeFile(String first, String last, String address, String country, String birthDate) {
        try {
            PrintStream file = new PrintStream(new File("student.txt")); //create file
            file.printf("First Name: %s\nLast Name: %s\nAddress: %s\nCountry: %s\nBirthdate: %s",
                        first, last, address, country, birthDate); //write to file
            file.close(); //close file
        } catch (FileNotFoundException e) {
            System.out.println("Unable to create file");
        }
    }
}
