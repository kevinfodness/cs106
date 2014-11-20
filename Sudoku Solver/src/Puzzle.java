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
    Grid[][] grids;

    /**
     * Constructor. Initializes object.
     */
    public Puzzle() {
        this.grids = new Grid[3][3];
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
                        this.grids[gridRow][gridColumn].set(gridValue, gridLine, line.charAt(gridColumn * 3 + gridValue) - 48);
                    }
                }
            }
        }
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
     * Method to return a string representing this object.
     *
     * @return The string representing this object.
     */
    public String toString() {

        /* Create string to store return value. */
        String value = "";

        return value;
    }
}
