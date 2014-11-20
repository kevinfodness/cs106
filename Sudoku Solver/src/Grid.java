/**
 * A class to represent a 3x3 grid inside of a Sudoku puzzle.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Grid {

    /* A variable to keep track of the values in this grid. */
    private int[] values;

    /**
     * Constructor. Sets initial values.
     *
     * @param values The initial values to populate this grid with.
     */
    public Grid(int[] values) {
        this.values = values;
    }
}
