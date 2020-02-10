import java.util.Scanner;
/**
 * Overloaded construtors within the Date class
 * First format: MM/DD/YYYY
 * Second format: Month DD, YYYY
 * Third format: DDD YYYY
 *
 * @author Luisely Doza
 * @version February 7, 2020
 */
public class Date {
    private int mm ; //1 - 12
    private int dd; //1 - 31 based on month 
    private int yyyy; // any year
    private int days; //total days in year
    private int month; 
    private int formatSelection;
    Scanner scan = new Scanner(System.in); //for user input
    private final String monthNames[] = { "January", "February","March", "April", "May", "June", "July", 
                                          "August","September", "October", "November", "December" };
    
    /**
     * date constructor: month supplied, date supplied, year supplied
     */                                     
    public Date(int mm, int dd, int yyyy) {
        setDate(mm, dd, yyyy);
        formatSelection = 1;
    }
    
    /**
     * date constructor: month name supplied and converted to numeric value, date supplied, year supplied
     */
    public Date(String month, int dd, int yyyy) {
        int m = convertMonth(month); //converts String month into int
        setDate(m, dd, yyyy);
        formatSelection = 2;
    }
    
    /**
     * date constructor: user input for days in year and the year
     */
    public Date() {
        System.out.println("Enter a days in year:");
        int days = scan.nextInt(); //days in year
        System.out.println("Enter year:");
        int year = scan.nextInt(); //any year
        daysInYear(days);
        setYear(year);
    }
    
    //Set Methods
    //set month
    public void setMonth(int mm) {
        if(mm < 0 || mm > 12) {
            throw new IllegalArgumentException("Invalid month input");
        }
        this.mm = mm;
    }
    //set day
    public void setDay(int mm, int dd, int yyyy) {
        final int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mm == 2 && dd == 29 && checkLeapYear(yyyy)) {
            dd = dd;
        } else if (dd > 0 && dd <= monthDays[mm - 1]) {
            dd = dd;
        } else {
            throw new IllegalArgumentException("Invalid date input");
        }
        this.dd = dd;
    }
    //set year
    public void setYear(int yyyy) {
        if(yyyy < 0) {
            throw new IllegalArgumentException("Invalid year input");
        }
        this.yyyy = yyyy;
    }
    //set days in year
    public void daysInYear(int days) {
        if (days < 1 || days > 365) {
            throw new IllegalArgumentException("Invalid days input");
        }
        this.days = days;
    }
    
    //set date
    public void setDate(int m, int d, int y) {
        setMonth(m);
        setDay(m, d, y);
        setYear(y);
    }
    
    //Get Methods
    //get month
    public int getMonth() {
        return mm;
    }
    //get day
    public int getDay() {
        return dd;
    }
    //get year
    public int getYear() {
        return yyyy;
    }

    /**
     * method takes month name and returns the numeric value of it
     */
    public int convertMonth(String m) {
        m = m.toUpperCase(); 
        this.month = 0;
        for (int i = 0; i < monthNames.length; i++) {
            if (m.equals(monthNames[i].toUpperCase())) {
                month = i;
            }
        }
        return month;
    }
    
    /**
     * This method checks to see if a year is a leapYear, allowing 29 days in February
     */
    public boolean checkLeapYear(int yyyy) {
        boolean leapYear;
        if(yyyy % 4 == 0) {
            if(yyyy % 100 == 0) {
                if (yyyy % 400 == 0) {
                    leapYear = true;
                } else {
                    leapYear = false;
                }
            } else {
                leapYear = true;
            }
        } else {
            leapYear = false;
        }
        return leapYear;
    }
    
    public String toString() {
        if (formatSelection == 1) {
            return "\n" + mm + "/" + dd + "/" + yyyy;
        } else if (formatSelection == 2) {
            return "\n" + monthNames[month] + " " + dd + ", " + yyyy;
        } else {
            return "\n" + days + " " + yyyy;
        }
    }
}
