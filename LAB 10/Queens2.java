import java.util.ArrayList;
import java.util.Arrays;

public class Queens2 {
    static int count = 0;

    public static void main(String[] args) {
        int N = 4;
        int[] Q = new int[N];
        Dynamic(Q, N);
    }

    private static void Dynamic(int[] q, int n) {
        Arrays.fill(q, -1);
        ArrayList<Integer> column = new ArrayList<>(n);

        // Call the helper method to find all solutions
        placeQueens(q, 0, column);
    }

    private static void placeQueens(int[] q, int row, ArrayList<Integer> column) {
        if (row == q.length) {
            // All queens are placed successfully, print the solution
            count++;
            System.out.println("Solution " + count + ": " + Arrays.toString(q));
            return;
        }

        for (int col = 0; col < q.length; col++) {
            if (isSafe(q, row, col, column)) {
                q[row] = col; // Place the queen at (row, col)
                column.add(col); // Add the queen's column to the list
                placeQueens(q, row + 1, column); // Move to the next row
                column.remove(column.size() - 1); // Backtrack and remove the last added column
            }
        }
    }

    private static boolean isSafe(int[] q, int row, int col, ArrayList<Integer> column) {
        for (int i = 0; i < row; i++) {
            // Check if there is a queen in the same column or diagonals
            if (q[i] == col || Math.abs(q[i] - col) == row - i) {
                return false;
            }
        }
        return !column.contains(col);
    }
}