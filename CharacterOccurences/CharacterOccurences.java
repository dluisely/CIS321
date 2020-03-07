import javax.swing.*;
/**
 * This program takes text input and counts the number of character occurences
 * 
 * @author Luisely Doza
 * @version March 6, 2020
 */
public class CharacterOccurences {
    JFrame frame;
    public static void main(String[] args) {
        CharacterOccurences c = new CharacterOccurences();
        c.app();
    }
    
    public void app() {
        String text = JOptionPane.showInputDialog(frame, "Enter text:"); //store user text input
        text = text.toLowerCase();
        String character = JOptionPane.showInputDialog(frame, "Enter a character:"); //store user character input
        character = character.toLowerCase();
        int count = countStringOccurrences(text, character); //count character occurences from text 
        JOptionPane.showMessageDialog(frame, String.format("Text Inputted: %s\nCharacter searched: %s\nThe %s occurs: %d times", 
                                      text, character, character, count)); //final dialog box
    }
    
    public static int countStringOccurrences(String text, String pattern) {
        int count = 0;
        int i = 0; // Keep calling index  Of for the pattern.
        while ((i = text.indexOf(pattern, i)) != -1) {
            i += pattern.length(); // Advance starting index.
            count++; // Increment count.
        }
        return count;
    }
}