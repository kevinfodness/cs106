/**
 * A class to represent a 3x3 grid inside of a Sudoku puzzle.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Grid {

    /* A variable to keep track of the values in this grid. */
    private int[][] values;

    /**
     * Constructor. Sets size of grid.
     *
     * @param size The size of the grid.
     */
    public Grid(int size) {
        this.values = new int[size][size];
    }

    /**
     * A method to set the value of a specific point.
     *
     * @param x     The X coordinate for the value.
     * @param y     The Y coordinate for the value.
     * @param value The value to set.
     */
    public void set(int x, int y, int value) {
        this.values[x][y] = value;
    }

    /**
     * A method to return the value at a particular position.
     *
     * @param x The X position to look up.
     * @param y The Y position to look up.
     * @return The value at the specified position.
     */
    public int valueAt(int x, int y) {
        return this.values[x][y];
    }
}
