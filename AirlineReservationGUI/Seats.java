import javax.swing.*;
/**
 * This class checks to see if a seat in First Class or Economy is available and then displays ticket with booked flight.
 *
 * @author Luisely Doza
 * @version Febraury 21, 2020
 */
public class Seats {
    boolean[] seating = new boolean[11]; //capacity of 10 people on flight
    /*
     * This method checks to see First Class section availability
     * Ticket displayed if seat booked
     * If full, user is given the choice of Economy seating
     * If both are full, then next flight departure is displayed
     */
    public void reserveFirstClass() {
        for(int i = 1; i <= 5; i++) {
            if(!seating[i]) {
                seating[i] = true; //seat booked
                JOptionPane.showMessageDialog(null, String.format("Plane Ticket:\nFirst Class - Seat #%d\n", i)); //display first class ticket
                break;
            } else if (seating[5]) {
                if (seating[10]) {
                    JOptionPane.showMessageDialog(null, "Flight booked. Next flight leaves in 3 hours.");
                    System.exit(0); //end program
                } else {
                    int choice = JOptionPane.showConfirmDialog(null,"First Class is booked. Would you like Economy?", 
                                 "Seating Change",JOptionPane.YES_NO_OPTION); //yes or no dialog box
                    if(choice == JOptionPane.YES_OPTION) {
                        reserveEconomy(); //user chose economy seating instead
                        break; 
                    } else {
                        JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours."); //next departure
                        System.exit(0); //end program
                    }
                        }
            }
        }
    }
    /*
     * This method checks to see Economy section availability
     * Ticket displayed if seat booked
     * If full, user is given the choice of First Class seating
     * If both are full, then next flight departure is displayed
     */
    public void reserveEconomy() {
        for(int i = 6; i <= 10; i++) {
            if(!seating[i]) {
                seating[i] = true; //seat booked
                JOptionPane.showMessageDialog(null, String.format("Plane Ticket:\nEconomy - Seat #%d\n", i)); //display economy ticket
                break;
            } else if (seating[10]) {
                if (seating[5]) {
                    JOptionPane.showMessageDialog(null, "Flight booked. Next flight leaves in 3 hours.");
                    System.exit(0); //end program
                } else {
                    int choice = JOptionPane.showConfirmDialog(null,"Economy is booked. Would you like First Class?", 
                                 "Seating Change",JOptionPane.YES_NO_OPTION); //yes or no dialog box
                    if(choice == JOptionPane.YES_OPTION) {
                        reserveFirstClass(); //user chose first class seating instead
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours.");
                        System.exit(0); //end program
                    }
                }
            }
        }
    }
}
