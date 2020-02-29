/**
 * This class represents an employee whose pay is based on the number of pieces of merchandise produced
 * PieceWorker class extends Employee
 *
 * @author Luisely Doza
 * @version February 28, 2020
 */
public class PieceWorker extends Employee {
    private double wage; //wage per piece
    private double pieces; //pieces created
    
    //constructor
    public PieceWorker(String firstName, String lastName, 
    String socialSecurityNumber, double Wage, double Pieces) {
        super(firstName, lastName, socialSecurityNumber);
        setWage(Wage);
        setPieces(Pieces);
    }
    
    //Setter Methods
    public final void setWage( double Wage ) {
        wage = (Wage < 0.0) ? 0.0 : Wage; //validates wage
    }
    public void setPieces(double Pieces) {
        pieces = (( Pieces >= 0.0 ) && (Pieces <= 168.0 )) ?   //validates pieces produces
        Pieces : 0.0;
    }
    
    //Getter Methods
    public double getWage() {
        return wage; //returns wage per pieces produced
    } 
    public double getPieces() {
        return pieces; //returns number of pieces produced
    }
    
    
    // calculate earnings; override abstract method earnings in Employee @Override
    public double earnings() {
        return getWage() * getPieces(); 
    }
    // return String representation of PieceWorker object @Override
    public String toString() {
        return String.format("piece worker employee: %s%n%s: $%,.2f; %s: %,.2f",
        super.toString(), "wage per piece", getWage(),
        "number of pieces produced", getPieces() );
    }
}
