/**
 * Time class with overloaded constructors
 * missing parts filled in from original source code
 * 
 * @author Luisely Doza
 * @version January 27, 2020
 */
 
public class time {
    private int hour;   // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
 
    // time no-argument constructor: initializes each instance variable
    // to zero; ensures that time objects start in a consistent state
    public time() {                                                                   
        // invoke time constructor with three arguments
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    } // end time no-argument constructor                              
 
    // time constructor: hour supplied, minute and second defaulted to 0
    public time(int h) {                                                                    
        // invoke time constructor with three arguments
        this.hour = h;
        this.minute = 0;
        this.second = 0;
    } // end  time one-argument constructor                             
 
    // time constructor: hour and minute supplied, second defaulted to 0
    public time(int h, int m) {                                                                    
        // invoke time constructor with three arguments 
        this.hour = h;
        this.minute = m;
        this.second = 0;
    } // end time two-argument constructor                              
 
    // time constructor: hour, minute and second supplied   
    public time(int h, int m, int s) {                                                        
        // invoke setTime to validate time
        setTime(h, m, s);
    } // end time three-argument constructor                
 
    // time constructor: another time object supplied           
    public time(time t) {                                                             
        t.getHour(); //time object using method call to get hour
        t.getMinute(); //time object using method call to get minute
        t.getSecond(); //time object using method call to get second
    } // end time constructor with a time object argument       
 
    // Set Methods
    // set a new time value using universal time; ensure that
    // the data remains consistent by setting invalid values to zero
    public void setTime(int h, int m, int s) {
        setHour( h );   // set the hour
        setMinute( m ); // set the minute
        setSecond( s ); // set the second
    } // end method setTime
 
    // validate and set hour
    public void setHour( int h ) {
        hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
    } // end method setHour
 
    // validate and set minute
    public void setMinute( int m ) {
        minute = ( ( m >= 0 && m < 60) ? m : 0 );
    } // end method setMinute
 
    // validate and set second
    public void setSecond( int s ) {
        second = ( (s >= 0 && s < 60) ? s : 0);
    } // end method setSecond
 
    // Get Methods
    // get hour value
    public int getHour() {
        return hour;
    } // end method getHour
 
    // get minute value
    public int getMinute() {
        return minute;
    } // end method getMinute
 
    // get second value
    public int getSecond() {
        return second;
    } // end method getSecond
 
    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond() );
    } // end method toUniversalString
 
    // convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {
        return String.format( "%d:%02d:%02d %s",
           ( (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12 ),
           getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" )  );
    } // end method toString
} // end class time