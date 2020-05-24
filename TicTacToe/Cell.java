import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Cell class created by initating row and column ints in the constructor 
 *
 * @author Luisely Doza
 * @version April 27, 2020
 */
public class Cell {
    Seed content;
    int row, col;
    
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }
    
    public void clear() {
        content = Seed.EMPTY;
    }
    
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(8));
        
        //for X and O
        int x1 = col * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
        int y1 = row * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
        
        if (content == Seed.X) {
            g2d.setColor(Color.YELLOW);
            
            int x2 = (col + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
            int y2 = (row + 1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
            
            g2d.drawLine(x2, y1, x1, y2);
            g2d.drawLine(x1, y1, x2, y2);
        } else if (content == Seed.O) {
            g2d.setColor(Color.GREEN);
            g2d.drawOval(x1, y1, GameMain.SYMBOL_SIZE, GameMain.SYMBOL_SIZE);
        }
    }
}
