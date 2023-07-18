import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class NQueens{
    public static void main(String[] args) {
        int N = 4;
        int[] Q = new int[N];
        // Arrays.fill(Q,-1);
        // System.out.println(Arrays.toString(Q));
        Dynamic(Q,N,0);
    }

    private static void Dynamic(int[] q,int n,int row) {
        int i = 0;
        Arrays.fill( q, -1);
        Collection<Integer> position = new ArrayList<Integer>();
        while (i<n) {
            q[i] = (q[i]+1)%n;
            position.add(q[i]);
            // System.out.println(q[i]);
            System.out.println(Arrays.toString(q));
            System.out.println("pos:"+position);
            if (position.contains(i)) {
                q[i] = (q[i]+1)%n;
            }
            i++;
        }

    }
}
