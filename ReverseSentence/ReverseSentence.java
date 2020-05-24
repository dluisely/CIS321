import java.util.Stack;
/**
 * ReverseSentence class uses a stack to reverse a string.
 *
 * @author Luisely Doza
 * @version April 17, 2020
 */
public class ReverseSentence {
    Stack<String> stackWords;
    String[] words;
    
    /**
     * Constructor for ReverseSentence
     * prints out the return of reverse() method
     * 
     * @param s string to be reversed
     */
    public ReverseSentence(String s) {
        System.out.print(reverse(s));
    }
    
    /**
     * This method splits a string and places it into a String array
     * Strings in the array are then pushed onto a stack
     * The Strings in the stack are then popped out to form the reversed sentence 
     * 
     * @param s string to be reversed
     * @return the string parameter reversed
     */
    public String reverse(String s) {
        words = s.split("\\b");
        stackWords = new Stack<String>();
        String reversedString = "";
        for (int i = 0; i < words.length; i++) {
            stackWords.push(words[i]);
        }
        
        while(!stackWords.isEmpty()) {
            reversedString += stackWords.pop();
        }
        return reversedString;
    }
}
