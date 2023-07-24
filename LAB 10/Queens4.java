// import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queens4{

    public static void main(String[] args) {
        // args[0] = "4";
        ArrayList<int[]> Q = new ArrayList<int[]>(4);//new int[args[0]];
        // Q.set(0, null);
        // Q.add(0, 10);
        // Q.add(12);
        Q.add(new int[]{11});
        Q.add(0, new int[]{2,2,6});
        System.out.println(Q.size());
        System.out.println(Q.toString());
        // Dynamic(Q);
    }

    // private static void Dynamic(Collection<int[]> q) {
    //     int n = q.size();
    //     // q.iterator();
    //     for (int row = 0; row < n; row++) {
    //         if (q.contains(row)) {
    //             System.out.println("YES");
    //         } else {
    //             System.out.println("NO");
    //         }
    //     }
    // }
}
