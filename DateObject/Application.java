import java.util.Scanner;
/**
 * The application class sets up the app in the terminal. 
 * Allowing user to input values for whichever they want their date object formatted
 * Application will allow user to redo the app if they wish to input another date
 *
 * @author Luisely Doza
 * @version February 
 */
public class Application
{
    Scanner scan;
    public Application() {
        scan = new Scanner(System.in);
    }
    public static void main(String args[]) {
        Application a = new Application();
        a.app();
    }
    public void app() {
        scan = new Scanner(System.in);
        System.out.println("Select Format: \n1.MM/DD/YYYY \n2.Month DD, YYYY \n3.DDD YYY");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Enter MM:");
            int m = scan.nextInt();
            System.out.println("Enter DD:");
            int d = scan.nextInt();
            System.out.println("Enter YYYY:");
            int y = scan.nextInt();
            
            Date date = new Date(m, d, y);
            System.out.println(date.firstFormat());
        }
        if (choice == 2) {
            System.out.println("Enter Month:");
            String month = scan.next();
            System.out.println("Enter DD:");
            int d = scan.nextInt();
            System.out.println("Enter YYYY:");
            int y = scan.nextInt();
            
            Date date = new Date(month, d, y);
            System.out.println(date.secondFormat());
        } 
        if (choice == 3) {
            Date date = new Date();
            System.out.println(date.thirdFormat());
        } 
        redo();
    }
    public void redo() {
        System.out.println("\nContinue?\n1.Yes  2.No");
        int answer = scan.nextInt();
        if(answer == 1) {
            app();
        } else {
            System.exit(0);
        }
    }
}
