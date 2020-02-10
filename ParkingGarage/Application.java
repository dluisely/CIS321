/**
 * Application method creates customers array to test charges and customer classes
 *
 * @author Luisely Doza
 * @version January 27, 2020
 */
public class Application {
    public static void main(String[] args) {
        Customer[] customers = new Customer[4]; //array of customer objects invoked
        //new customer objects initialized into customers array
        customers[0] = new Customer(8);
        customers[1] = new Customer(2);
        customers[2] = new Customer(20);
        customers[3] = new Customer(15);
        
        //for loop prints out number of hours parked by each customer in customers array
        //and also displays individual customer charges
        for(int i = 0; i < customers.length; i++) {
            System.out.printf("Customer%d was in the garage for %d hours\n", i+1, customers[i].getHoursParked());
            System.out.printf("Parking charges for Customer%d: $%.2f \n\n", i+1, customers[i].getCharges()); 
        }
        
        //display total charges from all customers in customers array
        System.out.printf("Running total of yesterday's receipts: $%.2f", 
                                new Application().totalCharges(customers));
    }
    /**
     * method takes each customer's charges and adds them together for total charges
     */
    public double totalCharges(Customer[] customers) {
        double totalCharges = 0; //initialize total charges
        //for loop to add all customer charges together
        for(int i = 0; i < customers.length; i++) {
            totalCharges += customers[i].getCharges();
        }
        return totalCharges;
    }
}
