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
     * Method to get a column of values.
     *
     * @param pos The column to retrieve.
     * @return An integer array of values in the column.
     */
    public int[] getCol(int pos) {
        int[] column = new int[this.values.length];

        for (int row = 0; row < this.values.length; row++) {
            column[row] = this.values[row][pos];
        }

        return column;
    }

    /**
     * Method to get a row of values.
     *
     * @param pos The row to retrieve.
     * @return An integer array of values in the row.
     */
    public int[] getRow(int pos) {
        return this.values[pos];
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
