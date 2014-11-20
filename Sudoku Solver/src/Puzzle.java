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
                    first.charAt(0),
                    first.charAt(1),
                    first.charAt(2),
                    second.charAt(0),
                    second.charAt(1),
                    second.charAt(2),
                    third.charAt(0),
                    third.charAt(1),
                    third.charAt(2)
            };
            int[] grid2 = {
                    first.charAt(3),
                    first.charAt(4),
                    first.charAt(5),
                    second.charAt(3),
                    second.charAt(4),
                    second.charAt(5),
                    third.charAt(3),
                    third.charAt(4),
                    third.charAt(5)
            };
            int[] grid3 = {
                    first.charAt(6),
                    first.charAt(7),
                    first.charAt(8),
                    second.charAt(6),
                    second.charAt(7),
                    second.charAt(8),
                    third.charAt(6),
                    third.charAt(7),
                    third.charAt(8)
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
}
