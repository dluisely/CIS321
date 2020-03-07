/**
 * Program that demonstrates inheritance
 * ExceptionA superclass is able to catch exceptions of typeExceptionB and ExceptionC 
 *
 * @author Luisely Doza
 * @version March 6, 2020
 */
public class TestExceptions {
    public static void main(String[] args) {
        try {
            throw new ExceptionB("Exception B");
        }catch(ExceptionA a){
            a.printStackTrace();
        }
        try {
            throw new ExceptionC("Exception C");
        }catch(ExceptionA a) {
            a.printStackTrace();
        }
    }
}