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
     * Method to determine if a column contains a value.
     *
     * @param pos   The column to retrieve.
     * @param value The value to check.
     * @return true if the column contains the value, false otherwise.
     */
    public boolean colContains(int pos, int value) {

        /* Loop through each row and determine if the value exists at the given column. */
        for (int[] row : this.values) {
            if (row[pos] == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to determine if the grid contains a value.
     *
     * @param value The value to check.
     * @return true if the grid contains the value, false otherwise.
     */
    public boolean gridContains(int value) {

        /* Loop through each row. */
        for (int[] row : this.values) {

            /* Loop through each column. */
            for (int i : row) {
                if (i == value) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * A method to remove a given value.
     *
     * @param value The value to remove.
     */
    public void remove(int value) {
        for (int row = 0; row < this.values.length; row++) {
            for (int col = 0; col < this.values.length; col++) {
                if (this.values[row][col] == value) {
                    this.values[row][col] = 0;
                    return;
                }
            }
        }
    }

    /**
     * Method to determine if a row contains a value.
     *
     * @param pos   The row to retrieve.
     * @param value The value to check.
     * @return true if the row contains the value, false otherwise.
     */
    public boolean rowContains(int pos, int value) {

        /* Loop through the row and determine if any column contains the value. */
        for (int i : this.values[pos]) {
            if (i == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * A method to set the value of a specific point.
     *
     * @param row   The row for the value.
     * @param col   The col for the value.
     * @param value The value to set.
     */
    public void set(int row, int col, int value) {
        this.values[row][col] = value;
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
