import java.io.File;

/**
 * Contains a class to represent a program to test code for lecture slides.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class LectureExamples {

    /**
     * Main method. Directs control of the program.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println(sumOfSquares(7));
        fibonacci(0, 1, 1000);
        mapFilesystem("/Users/kevin/IdeaProjects/cs106");
    }

    /**
     * A recursive method to compute the sum of squares.
     *
     * @param max The maximum number of squares to return.
     * @return The sum of the current square plus the next one, if applicable.
     */
    public static int sumOfSquares(int max) {
        /* As long as there are still numbers left, add the next square. */
        if (max > 1) {
            return max * max + sumOfSquares(max - 1);
        }

        return 1;
    }

    /**
     * Recursive method to compute Fibonacci numbers.
     *
     * @param current The current number in sequence.
     * @param next    The next number in sequence.
     * @param max     The maximum number to compute.
     */
    public static void fibonacci(int current, int next, int max) {
        if (next < max) {
            int total = current + next;
            current = next;
            next = total;
            System.out.print(current + " ");
            fibonacci(current, next, max);
        } else {
            System.out.println();
        }
    }

    /**
     * Recursive method to display the contents of a directory.
     *
     * @param src The source filepath. Can be absolute or relative to the root of this project.
     */
    public static void mapFilesystem(String src) {
        /* Convert source path into File object. */
        File f = new File(src);

        /* Determine if the source path is a file or a directory. */
        if (f.isDirectory()) {
            /* Loop through the directory contents and process each item. */
            for (String file : f.list()) {
                mapFilesystem(src + '/' + file);
            }
        } else {
            /* Print the filepath to this file. */
            System.out.println(src);
        }
    }
}