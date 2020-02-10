/**
 * Customer class declaration with constructor
 *
 * @author Luisely Doza
 * @version January 27, 2020
 */

//extends Charges class to calculate customer charges
public class Customer extends Charges {
    private int hoursParked; //hours each customer parked
    private double charges; //amount customers charged for hours parked
    /**
     * customer constructor: hours parked supplied, charges calculated by calling calculateCharges() method in Charges class
     */
    public Customer(int hoursParked) {
        //invoked customer constructor with two arguments
        this.hoursParked = hoursParked;
        this.charges = calculateCharges(hoursParked);
    }
    
    //Set Methods
    //set hours parked value
    public void setHoursParked(int h) {
        hoursParked = h; //set the hours parked
    }
    //set charges value
    public void setCharges(int h) {
        charges = calculateCharges(h); //set the charges, method calling calculateCharges() from Charges class
    }
    
    //Get Methods
    //get hours parked value
    public int getHoursParked() {
        return hoursParked;
    }
    //get charges value
    public double getCharges() {
        return charges;
    }
}
