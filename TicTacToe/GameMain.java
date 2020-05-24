import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * GameMain class runs Tic Tac Toe game
 *
 * @author Luisely Doza
 * @version April 27, 2020
 */
public class GameMain extends JPanel {
    // dimensions for graphics
    public static final int CELL_SIZE = 100; // cell width and height (square)
    public static final int CANVAS_WIDTH = CELL_SIZE * 3;  // the drawing canvas
    public static final int CANVAS_HEIGHT = CELL_SIZE * 3;
    public static final int GRID_WIDTH = 8;  // Grid-line's width
    public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2; // Grid-line's half-width

    public static final int CELL_PADDING = CELL_SIZE / 6;
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;

    private Board board; // the game board
    private GameState currentState; // current state of the game
    private Seed currentPlayer; // the current player
    private JLabel label;  // for displaying status message
    private static Robot robot;

    private JFrame frame;
    private JPanel menuPanel; //panel for starting frame
    private JPanel gameOptions; //panel for game option buttons
    private JLabel pickPlayers; //select amount of players
    private JButton singlePlayer; //button for single player game
    private JButton multiPlayer; //button for multi player game
    private JButton exit; //exit game and back to menu panel
    private JButton reset; //reset current game
    private int playerXWins; // player X wins count
    private int playerOWins; //player O wins count
    private boolean ai;

    Random random = new Random();

    public GameMain() {
        Handler handler = new Handler();
        this.addMouseListener(handler);

        // setup JLabel
        label = new JLabel("         ");
        label.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);

        //set up game option buttons
        gameOptions = new JPanel();
        BoxLayout buttons = new BoxLayout(gameOptions, BoxLayout.Y_AXIS);
        gameOptions.setLayout(buttons);

        exit = new JButton("EXIT");
        reset = new JButton("RESET");

        gameOptions.add(exit);
        gameOptions.add(reset);

        setLayout(new BorderLayout());
        add(label, BorderLayout.SOUTH);
        add(gameOptions, BorderLayout.EAST);
        setPreferredSize(new Dimension(CANVAS_WIDTH + 80, CANVAS_HEIGHT + 30));
        board = new Board();
        initGame();
    }

    public static void main(String args[]) {
        GameMain game = new GameMain();
        game.menuPanel();
    }

    public void singlePlayerGame() {
        JFrame frame = new JFrame("Tic Tac Toe: Single Player Mode");

        // set game panel instance on JFrame
        GameMain game = new GameMain();
        game.ai = true;
        frame.setContentPane(game);

        game.reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.label.setForeground(Color.YELLOW);
                    game.label.setText("Game Resetting! Click to start over.");
                    game.initGame();
                }
            });
        game.exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuPanel();
                    frame.dispose();
                }
            });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);       

    }

    public void initBot() {
        int randX = random.nextInt(CANVAS_WIDTH);
        int randY = random.nextInt(CANVAS_HEIGHT);

        int rowSelected = randX / CELL_SIZE;
        int colSelected = randY / CELL_SIZE; 
        
        
        
        if (rowSelected >= 0 && rowSelected < board.cells.length && colSelected >= 0 && colSelected < board.cells.length &&  
        board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
            board.cells[rowSelected][colSelected].content = currentPlayer; // move
            updateGame(currentPlayer, rowSelected, colSelected); // update currentState
            currentPlayer = (currentPlayer == Seed.X) ? Seed.O : Seed.X;
        } else {
            initBot();
        }

        // try {
            // robot = new Robot();
            // robot.mouseMove(randX, randY);
            // robot.delay(5);
            // robot.mousePress(MouseEvent.BUTTON1_MASK);
            // robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        // } catch (AWTException e) {
            // e.printStackTrace();
        // }
    }

    public void multiPlayerGame() {
        JFrame frame = new JFrame("Tic Tac Toe: Multi Player Mode");

        // set game panel instance on JFrame
        GameMain game = new GameMain();
        frame.setContentPane(game);

        game.reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.label.setForeground(Color.YELLOW);
                    game.label.setText("Game Resetting! Click to start over.");
                    game.initGame();
                }
            });
        game.exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuPanel();
                    playerXWins = 0;
                    playerOWins = 0;
                    frame.dispose();
                }
            });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if (game.currentState != GameState.PLAYING) {
            game.initGame();
        }
    }

    public void menuPanel() {
        JFrame frame = new JFrame("Tic Tac Toe");
        menuPanel = new JPanel();
        BoxLayout buttons = new BoxLayout(menuPanel, BoxLayout.Y_AXIS);
        menuPanel.setLayout(buttons);

        pickPlayers = new JLabel("SELECT PLAYER AMOUNT");
        pickPlayers.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        singlePlayer = new JButton("Single Player Mode");
        multiPlayer = new JButton("Multi Player Mode");
        singlePlayer.setAlignmentX(JButton.CENTER_ALIGNMENT);
        multiPlayer.setAlignmentX(JButton.CENTER_ALIGNMENT);

        menuPanel.setPreferredSize(new Dimension(CANVAS_WIDTH, 100));

        menuPanel.add(pickPlayers);
        menuPanel.add(singlePlayer);
        menuPanel.add(multiPlayer);

        ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == singlePlayer) {
                        singlePlayerGame();
                        frame.dispose();
                    } else {
                        multiPlayerGame();
                        frame.dispose();
                    }
                }
            };

        singlePlayer.addActionListener(listener);
        multiPlayer.addActionListener(listener);

        frame.setContentPane(menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void initGame() {
        for (int row = 0; row < board.cells.length; ++row) {
            for (int col = 0; col < board.cells.length; ++col) {
                board.cells[row][col].content = Seed.EMPTY; // all cells empty
            }
        }
        currentState = GameState.PLAYING; // ready to play
        currentPlayer = Seed.X; // cross plays first
    }

    public void updateGame(Seed s, int row, int col) {
        if(board.hasWon(s, row, col)) { // check for win
            currentState = (s == Seed.X) ? GameState.X_WON : GameState.O_WON;
        } else if (board.isTie()) { // check for draw
            currentState = GameState.TIE;
        }
        // Otherwise, no change to current state (PLAYING).
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        board.paint(g);

        if (currentState == GameState.PLAYING) {
            label.setForeground(Color.BLACK);
            if (currentPlayer == Seed.X) {
                label.setText(String.format("X's Turn                                             X Wins: %d    O Wins: %d", playerXWins, playerOWins));
            } else {
                label.setText(String.format("O's Turn                                             X Wins: %d    O Wins: %d", playerXWins, playerOWins));
            }
        } else if (currentState == GameState.TIE) {
            label.setForeground(Color.YELLOW);
            label.setText("It's a Tie! Click to play again.");
        } else if (currentState == GameState.X_WON) {
            label.setForeground(Color.RED);
            label.setText("'X' Won! Click to play again.");
            playerXWins++;
        } else if (currentState == GameState.O_WON) {
            label.setForeground(Color.RED);
            label.setText("'O' Won! Click to play again.");
            playerOWins++;
        }
    }

    public class Handler extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            int mouseX = e.getX();
            int mouseY = e.getY();

            // Get the row and column clicked
            int rowSelected = mouseY / CELL_SIZE;
            int colSelected = mouseX / CELL_SIZE;

            if (currentState == GameState.PLAYING) {
                if (rowSelected >= 0 && rowSelected < board.cells.length && colSelected >= 0 && colSelected < board.cells.length &&  
                board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
                    board.cells[rowSelected][colSelected].content = currentPlayer; // move
                    updateGame(currentPlayer, rowSelected, colSelected); // update currentState
                    currentPlayer = (currentPlayer == Seed.X) ? Seed.O : Seed.X;
                    if (ai) initBot();
                }
            } else {
                initGame();
            }

            repaint();
        }
    }
}
