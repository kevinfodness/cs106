import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class to represent an entire Sudoku puzzle with all 9 grids.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Puzzle {

    /* Variable to track the grids in the puzzle. */
    private Grid[][] grids;

    /**
     * Constructor. Initializes object.
     */
    public Puzzle() {
        this.grids = new Grid[3][3];
    }

    /**
     * A method to determine if a column in the puzzle contains a specific value.
     *
     * @param gridCol The grid column to check.
     * @param col     The column number within the grid to check.
     * @param value   The value to check.
     * @return true if found, false if not.
     */
    private boolean colContains(int gridCol, int col, int value) {
        for (Grid[] g : this.grids) {
            if (g[gridCol].colContains(col, value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to process a file into this object, given a valid Scanner object.
     *
     * @param s The scanner object to use when reading the file.
     */
    private void processFile(Scanner s) {

        /* Loop over each row. */
        for (int gridRow = 0; gridRow < this.grids.length; gridRow++) {

            /* Initialize Grid objects for each item in the row. */
            for (int grid = 0; grid < this.grids.length; grid++) {
                this.grids[gridRow][grid] = new Grid(this.grids.length);
            }

            /* Read in lines, equal to size of grid, and process into data structures. */
            for (int gridLine = 0; gridLine < this.grids.length; gridLine++) {
                String line = s.nextLine();

                /* Loop over grids in the line. */
                for (int gridColumn = 0; gridColumn < this.grids.length; gridColumn++) {

                    /* Loop over grid values within a column. */
                    for (int gridValue = 0; gridValue < this.grids.length; gridValue++) {

                        /* Add the value to the appropriate grid. */
                        this.grids[gridRow][gridColumn].set(gridLine, gridValue, line.charAt(gridColumn * 3 + gridValue) - 48);
                    }
                }
            }
        }
    }

    /**
     * A method to solve the puzzle recursively, moving grid by grid.
     *
     * @param gridRow The grid's row coordinate.
     * @param gridCol The grid's column coordinate.
     * @return true if able to solve for the row and column, false otherwise.
     */
    private boolean recursiveSolver(int gridRow, int gridCol) {

        /* Try to fill each number in this grid. */
        for (int i = 1; i <= this.grids.length * this.grids.length; i++) {

            /* Determine if the number exists in the grid already. */
            if (this.grids[gridRow][gridCol].gridContains(i)) {
                System.out.println("Grid already contains " + i);
                continue;
            }

            System.out.println("Trying to place " + i);
        }

        /* Move on to the next grid in this column. */
        gridCol++;

        /* If past the end of the column, move to the first column in the next row. */
        if (gridCol == this.grids.length) {
            gridCol = 0;
            gridRow++;
        }

        /* If not past the end of the rows, keep going. */
        if (gridRow < this.grids.length) {
            recursiveSolver(gridRow, gridCol);
        }

        return true;
    }

    /**
     * A method to determine if a row in the puzzle contains a specific value.
     *
     * @param gridRow The grid row to check.
     * @param row     The row number within the grid to check.
     * @param value   The value to check.
     * @return true if found, false if not.
     */
    private boolean rowContains(int gridRow, int row, int value) {
        for (Grid g : this.grids[gridRow]) {
            if (g.rowContains(row, value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to load a puzzle from a file.
     *
     * @param file The filepath to read in.
     */
    public void load(String file) {

        /* Convert string filepath into File object. */
        File f = new File(file);

        /* Try to read the contents of the file. */
        try {
            Scanner s = new Scanner(f);
            this.processFile(s);
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the file specified.");
        }
    }

    /**
     * A method to solve the puzzle.
     */
    public void solve() {
        if (this.recursiveSolver(0, 0)) {
            System.out.println("Solution found!");
            System.out.println(this.toString());
        } else {
            System.out.println("There doesn't appear to be a solution to this puzzle.");
        }
    }

    /**
     * Method to return a string representing this object.
     *
     * @return The string representing this object.
     */
    public String toString() {

        /* Create string to store return value. */
        String value = "";

        /* Loop through rows. */
        for (Grid[] gridRow : this.grids) {

            /* Loop through individual rows. */
            for (int row = 0; row < this.grids.length; row++) {

                /* Loop through grid columns. */
                for (int gridCol = 0; gridCol < this.grids.length; gridCol++) {

                    /* Loop through individual columns. */
                    for (int col = 0; col < this.grids.length; col++) {

                        /* Add the value to the string. */
                        value += gridRow[gridCol].valueAt(row, col) + " ";
                    }
                }

                /* Add a line break. */
                value += "\n";
            }
        }

        return value;
    }
}
