import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int N = 4;
        int[] Q = new int[N];
        Dynamic(Q, N, 0);
        // System.out.println(Arrays.toString(Q));
    }

    private static void Dynamic(int[] q, int n, int row) {
        if (row == n) {
            // All queens are placed successfully, print the solution
            System.out.println("Columns"+Arrays.toString(q));
            return;
        }

        for (int col = 0; col < n; col++) {
            q[row] = col; // Place the queen at (row, col)
            if (isSafe(q, row)) {
                Dynamic(q, n, row + 1); // Move to the next row
            }
        }
    }

    private static boolean isSafe(int[] q, int row) {
        for (int i = 0; i < row; i++) {
            // Check if there is a queen in the same column or diagonals
            if (q[i] == q[row] || Math.abs(q[i] - q[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}