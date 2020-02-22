import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Application class constructs the GUI and begins prompting the user to select which airline seating section they want. 
 * This class extends the Seats class in order for the First-class button and Economy button to use ActionListener
 *
 * @author Luisely Doza
 * @version Febrauary 21, 2020
 */
public class Application extends Seats{
    JFrame frame;
    JPanel panel;
    /*
     * application constructor sets up JFrame and JPanel for GUI
     */
    public Application() {
        frame = new JFrame("Automatic Reservation System"); //create JFrame
        frame.setVisible(true); //make JFrame visible
        frame.setSize(400,200); //set JFrame size
        frame.setResizable(false); //unable to resize JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridBagLayout()); //create JPanel with layout specified 
        frame.add(panel, BorderLayout.NORTH); //add the panel to the frame
    }
    /*
     * main method runs app() method 
     */
    public static void main(String args[]) {
        Application a = new Application(); //create new application instance
        a.app(); //run app method
    }
    /*
     * sets label and buttons for seating selection
     * creates ActionListener for button selections
     * layout GUI
     */
    public void app() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        //create label and buttons and that prompt user for seat section
        JLabel welcome = new JLabel("<html><div style='text-align:center;'>Welcome to the Automatic Reservation System!<br/>Make a selection:</html>");
        JButton firstClass = new JButton("First Class");
        JButton economy = new JButton(" Economy ");
        
        //add actions to buttons
        firstClass.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 reserveFirstClass();
             } 
        });
        economy.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 reserveEconomy();
             } 
        });
        
        
        //layout label and buttons
        gbc.gridx = 0; //set the x location of the grid for the next component
        gbc.gridy = 0; //set the y location of the grid for the next component
        panel.add(welcome, gbc);
        
        gbc.gridy = 1; //change the y location
        panel.add(firstClass, gbc);
        
        gbc.gridy = 2; //change the y location
        panel.add(economy, gbc);
    }
}
