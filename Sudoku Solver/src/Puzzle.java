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
     * A method for placing a value in a given grid given a particular offset.
     *
     * @param gridRow The grid row to target.
     * @param gridCol The grid column to target.
     * @param value   The value to place.
     * @param offset  The number of open spaces from the beginning to shift the value.
     * @return true if able to place the value, false otherwise.
     */
    private boolean place(int gridRow, int gridCol, int value, int offset) {

        /* Set column and row positions within the grid based on offset. */
        int row = offset / this.grids.length;
        int col = offset % this.grids.length;

        /* Determine if there is already something in this position. */
        if (this.grids[gridRow][gridCol].valueAt(row, col) > 0) {
            return false;
        }

        /* Determine if we can put this value in this position. */
        if (this.grids[gridRow][gridCol].gridContains(value)
                || this.rowContains(gridRow, row, value)
                || this.colContains(gridCol, col, value)) {
            return false;
        }

        /* Place the value. */
        this.grids[gridRow][gridCol].set(row, col, value);

        return true;
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

                        /* Add the value to the appropriate grid. Subtracting 48 from the value converts from ASCII to normal int. */
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
     * @param value   The value we are attempting to place.
     * @param offset  The offset of the value's position within the grid relative to the first available space.
     * @return true if able to solve for the row and column, false otherwise.
     */
    private boolean recursiveSolver(int gridRow, int gridCol, int value, int offset) {

        /* Advance the value to the next value missing from this grid. */
        while (this.grids[gridRow][gridCol].gridContains(value)) {
            value++;
        }

        /* Determine if we have placed all of the numbers in this grid. */
        if (value > this.grids.length * this.grids.length) {

            /* Advance the grid position. */
            gridCol++;

            /* If past the end of the column, move to the first column in the next row. */
            if (gridCol == this.grids.length) {
                gridCol = 0;
                gridRow++;
            }

            /* If not past the end of the rows, keep going. */
            if (gridRow < this.grids.length) {
                return recursiveSolver(gridRow, gridCol, 1, 0);
            }

            /* Past the end of the rows = we have placed everything successfully. */
            return true;
        }

        /* Determine if we can safely place this number in the grid, starting at the given offset. */
        while (offset < this.grids.length * this.grids.length) {

            /* If we are able to place this value at this offset, try to place the next value. Otherwise, adjust offset. */
            if (this.place(gridRow, gridCol, value, offset)) {

                /* Determine if subsequent placements were successful, or if we need to roll back and adjust. */
                if (recursiveSolver(gridRow, gridCol, value + 1, 0)) {
                    return true;
                } else {
                    this.grids[gridRow][gridCol].remove(value);
                    offset++;
                }
            } else {
                offset++;
            }
        }

        /* If we reach here, it means that the value was not able to be placed in the grid at any offset. */
        return false;
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
        if (this.recursiveSolver(0, 0, 1, 0)) {
            System.out.println("Solution found!");
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
