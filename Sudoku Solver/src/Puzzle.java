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
    Grid[] grids;

    /**
     * Constructor. Initializes object.
     */
    public Puzzle() {
        this.grids = new Grid[9];
    }

    /**
     * Method to process a file into this object, given a valid Scanner object.
     *
     * @param s The scanner object to use when reading the file.
     */
    private void processFile(Scanner s) {

        /* Loop three times for three rows of grids. */
        for (int i = 0; i < 3; i++) {

            /* Read in lines, three at a time. */
            String first = s.nextLine();
            String second = s.nextLine();
            String third = s.nextLine();

            /* Create arrays for grids. */
            int[] grid1 = {
                    first.charAt(0) - 48,
                    first.charAt(1) - 48,
                    first.charAt(2) - 48,
                    second.charAt(0) - 48,
                    second.charAt(1) - 48,
                    second.charAt(2) - 48,
                    third.charAt(0) - 48,
                    third.charAt(1) - 48,
                    third.charAt(2) - 48
            };
            int[] grid2 = {
                    first.charAt(3) - 48,
                    first.charAt(4) - 48,
                    first.charAt(5) - 48,
                    second.charAt(3) - 48,
                    second.charAt(4) - 48,
                    second.charAt(5) - 48,
                    third.charAt(3) - 48,
                    third.charAt(4) - 48,
                    third.charAt(5) - 48
            };
            int[] grid3 = {
                    first.charAt(6) - 48,
                    first.charAt(7) - 48,
                    first.charAt(8) - 48,
                    second.charAt(6) - 48,
                    second.charAt(7) - 48,
                    second.charAt(8) - 48,
                    third.charAt(6) - 48,
                    third.charAt(7) - 48,
                    third.charAt(8) - 48
            };

            /* Process arrays into grids. */
            this.grids[i * 3] = new Grid(grid1);
            this.grids[i * 3 + 1] = new Grid(grid2);
            this.grids[i * 3 + 2] = new Grid(grid3);
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

        /* Loop over grids in blocks of three. */
        for (int i = 0; i < 3; i++) {
            Grid first = this.grids[i * 3];
            Grid second = this.grids[i * 3 + 1];
            Grid third = this.grids[i * 3 + 2];
            value += first.valueAt(0) + " "
                    + first.valueAt(1) + " "
                    + first.valueAt(2) + " "
                    + second.valueAt(0) + " "
                    + second.valueAt(1) + " "
                    + second.valueAt(2) + " "
                    + third.valueAt(0) + " "
                    + third.valueAt(1) + " "
                    + third.valueAt(2) + "\n"
                    + first.valueAt(3) + " "
                    + first.valueAt(4) + " "
                    + first.valueAt(5) + " "
                    + second.valueAt(3) + " "
                    + second.valueAt(4) + " "
                    + second.valueAt(5) + " "
                    + third.valueAt(3) + " "
                    + third.valueAt(4) + " "
                    + third.valueAt(5) + "\n"
                    + first.valueAt(6) + " "
                    + first.valueAt(7) + " "
                    + first.valueAt(8) + " "
                    + second.valueAt(6) + " "
                    + second.valueAt(7) + " "
                    + second.valueAt(8) + " "
                    + third.valueAt(6) + " "
                    + third.valueAt(7) + " "
                    + third.valueAt(8) + "\n";
        }

        return value;
    }
}
