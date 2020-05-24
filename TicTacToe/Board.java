import java.awt.*;
/**
 * Board class created using 2D Cell array
 *
 * @author Luisely Doza
 * @version April 27, 2020
 */
public class Board {
    Cell[][] cells = new Cell[3][3];
    
    public Board() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }
    
    public void init() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                cells[row][col].clear(); // clear the cell content
            }
        }
    }
    
    public boolean isTie() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (cells[row][col].content == Seed.EMPTY) {
                    return false; 
                }
            }
        }
        return true; //game ended in tie
    }
    
    public boolean hasWon(Seed s, int row, int col) {
        return (cells[row][0].content == s && cells[row][1].content == s && cells[row][2].content == s // 3 in a row
               || cells[0][col].content == s && cells[1][col].content == s && cells[2][col].content == s //3 in a column
               || row == col && cells[0][0].content == s && cells[1][1].content == s && cells[2][2].content == s //3 in diagnol
               || row + col == 2 && cells[0][2].content == s && cells[1][1].content == s && cells[2][0].content == s); //3 in opposite diagnol
    }
    
    public void paint(Graphics g) {
        // Draw the grid-lines
        g.setColor(Color.PINK);
        for (int row = 1; row < cells.length; ++row) {
            g.fillRoundRect(0, GameMain.CELL_SIZE * row - GameMain.GRID_WIDTH_HALF, GameMain.CANVAS_WIDTH - 1, 5,
                    GameMain.GRID_WIDTH, GameMain.GRID_WIDTH);
        }
        for (int col = 1; col < cells.length; ++col) {
            g.fillRoundRect(GameMain.CELL_SIZE * col - GameMain.GRID_WIDTH_HALF, 0, 5, GameMain.CANVAS_HEIGHT - 1,
                    GameMain.GRID_WIDTH, GameMain.GRID_WIDTH);
        }
        // Draw all the cells
        for (int row = 0; row < cells.length; ++row) {
            for (int col = 0; col < cells.length; ++col) {
                cells[row][col].paint(g);  //cells is painted
            }
        }
    }
}
