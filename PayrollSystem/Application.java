import java.util.Scanner;
import java.util.Arrays;
/**
 * Application class creates the intializes the employee array with user input
 * prints the roster
 *
 * @author Luisely Doza
 * @version February 28, 2020
 */
public class Application
{
    Employee[] employees;
    Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        Application a = new Application();
        a.app();
    }
    
    public void app() {
        System.out.println("Input amount of employees:");
        int arrSize = scan.nextInt();
        employees = new Employee[arrSize];
        printRoster();
    }
    public void printRoster() {
        Employee[] sample = new Employee[5];
        
        System.out.println("Employees process polymorphically:\n");
        
       
        for (int i = 0; i < employees.length; i++) {
            if (employees.length == 0) {
                System.out.println("Employee roster is empty");
            } else if (employees.length == 1) {
                sample[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
            } else if (employees.length == 2) {
                sample[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
                sample[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
            } else if (employees.length == 3) {
                sample[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
                sample[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
                sample[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06); 
            } else if (employees.length == 4) {
                sample[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
                sample[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
                sample[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06); 
                sample[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
            } else if (employees.length == 5) {
                sample[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
                sample[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
                sample[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06); 
                sample[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
                sample[4] = new PieceWorker("Victor", "Figueroa", "555-555-5555", 90, 100);
            }
        }
        
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString
            System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings());
        } // end for
    }
}
