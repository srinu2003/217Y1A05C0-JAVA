// import java.lang.reflect.Array;
// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collection;

public class Queens{
    
    static int count = 0;
    public static void main(String[] args) {
        int N = 4;
        int[] Q = new int[N];
        // Arrays.fill(Q,-1);
        // System.out.println(Arrays.toString(Q));
        Dynamic(Q,N);
    }
    private static void Dynamic(int[] q,int n) {
        int col = 0;
        boolean notsafe = false;
        
        Arrays.fill( q, -1);//Queens are not placed in bord
        // Array.set(q, 2, 2);
        ArrayList<Integer> Column = new ArrayList<>(n); //Arrays.asList(q)
        for (int row = 0; row < q.length; row++) {
            q[row] = (q[row]+1)%n;
            count++;
            col = q[row];
            // System.out.println(q[row]);
            // Column.remove(q[row]);
            // System.out.println(Arrays.toString(q));
            // System.out.println("pos:"+Column);
            for (int r = 0; r < row; r++) {
                // Check if there is a queen in the same column or diagonals
                if (Math.abs(q[r] - q[row]) == row - r) {
                    notsafe = true;
                    break;
                }
            }
            if (Column.contains(q[row]) || notsafe){
                // q[row] = (q[row]+1)%n;
                // Column.add(q[row]);
                row--;
            }else{
                Column.add(q[row]);
                // System.out.println(Column.get(0));
            }
        }

    }

    // private static boolean issafe(int[] q) {
    //     return false;
    // }
}
