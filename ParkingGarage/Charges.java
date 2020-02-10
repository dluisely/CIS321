/**
* Charges class calculates the charges for a customer
*
* @author Luisely Doza
* @version January 27, 2020
*/
public class Charges {
    private double minimumFee = 2; //minimum fee of $2.00 for three hours parked or less
    private double maximumFee = 10; //maximum fee of $10.00 for any given 24-hour period
    /**
     * method calculates charges based on hours parked
     * exceptions handeled for invalid inputs
     * minimum $2.00 fee for up to 3 hours
     * maximum $10.00 fee reached after 19 hours parked
     * minimum fee + $.50 for every additional hour after parked for more than 3 hours
     */
    public double calculateCharges(int hoursParked) {
        double charges = 0; //invoke charges variable
        if (hoursParked < 1 || hoursParked > 24) {
            System.out.println(new IllegalArgumentException("Invalid amount of hours inputted")); 
            //can't be parked for less than 1 hour or more than 24 hours in the day
        } else if (hoursParked <= 3) {
            charges = minimumFee; //minimum fee to park up to 3 hours
        } else if (hoursParked > 19)  {
            charges = maximumFee; //maximum fee for any period of 24 hours
        } else if (hoursParked > 3 || hoursParked <= 19) {
            charges = minimumFee; //minimum fee added
            //loop to calculate charge after three hours exceeded
            while (hoursParked > 3) {
                charges += .5; //$.50 added for every additional hour
                hoursParked--; 
            }
        }
        return charges; //return final charge for customer
    }
 }
