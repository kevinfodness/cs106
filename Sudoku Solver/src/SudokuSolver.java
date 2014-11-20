/**
 * A class that contains a program to solve Sudoku puzzles.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 * @version 1.0
 */
public class SudokuSolver {

    /**
     * Main method. Directs control flow of the program.
     *
     * @param args The arguments passed to the program on the command-line.
     */
    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        p.load("/Users/kevin/IdeaProjects/cs106/Sudoku Solver/src/puzzle.txt");
        System.out.println(p);
    }
}
