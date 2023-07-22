// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collection;

public class NQueens{
    
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
        Arrays.fill( q, -1);
        ArrayList<Integer> Column = new ArrayList<>(n); //Arrays.asList(q)
       for (int row = 0; row < q.length; row++) {
            q[row] = (q[row]+1)%n;
            count++;
            col = q[row];
            // System.out.println(q[row]);
            // Column.remove(q[row]);
            // System.out.println(Arrays.toString(q));
            // System.out.println("pos:"+Column);
            if (Column.contains(col)) {
                q[row] = (q[row]+1)%n;
                // Column.add(q[row]);
                row--;
            }else{
                Column.add(q[row]);
                System.out.println(Column.get(0));
            }
        }

    }

    // private static boolean issafe(int[] q) {
    //     return false;
    // }
}
