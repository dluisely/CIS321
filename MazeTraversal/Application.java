/**
 * Application class extends Maze class and tests the mazeTraversal() method, printing out the final maze
 *
 * @author Luisely Doza
 * @version April 3, 2020
 */
public class Application extends Maze{
    public static void main(String args[]) {
        Maze maze = new Maze(); //create Maze object
        maze.buildMaze(); //build starting maze
        maze.mazeTraversal(2, 0); //starting location, and traverse through maze
        System.out.println("Total Moves:" + moves);
        //print out final maze
        for (int k = 0; k < 12; k++) {
            for (int l = 0; l < 12; l++) {
                System.out.print(a[k][l] + " ");
            }
            System.out.println();
        }
    }
}
