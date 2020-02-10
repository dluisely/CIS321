/**
 * Application method created to test time class
 *
 * @author Luisely Doza
 * @version January 27, 2020
 */
public class application
{
    public static void main(String[] args) {
        //multiple time objects created
        time midnight = new time(); //no arguments supplied, will display midnight as default
        time morning = new time(7, 4, 9); //three arguments supplied
        time noon = new time(12); //one argument supplied
        time evening = new time(20,23); //two arguments supplied
        
        //each time object displayed in standard-time format
        System.out.println(midnight);
        System.out.println(morning);
        System.out.println(noon);
        System.out.println(evening);
        
        //each time object displayed in universal-time format
        System.out.println(midnight.toUniversalString());
        System.out.println(morning.toUniversalString());
        System.out.println(noon.toUniversalString());
        System.out.println(evening.toUniversalString());
    }
}
