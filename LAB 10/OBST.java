import java.util.Arrays;

/**
 * OBSTMatrix
 * Constructs an OBST Matrix
 */
class OBSTMatrix {
    public int[][][] Matrix;
    public static int[] p,q;
    OBSTMatrix(int NO_OF_KEYS,int[] p,int[] q){
        OBSTMatrix.p = p;
        OBSTMatrix.q = q;
        Matrix = new int[NO_OF_KEYS+1][NO_OF_KEYS+1][3];
        for (int n = 0; n <= NO_OF_KEYS; n++) {
            System.out.println("For i-j = "+ n +":");
            int i = 0 ,j = n;
            while(j-i == n && i <= NO_OF_KEYS && j <= NO_OF_KEYS ) {
                setWeight(Matrix, i, j);
                setCostRoot(Matrix,i,j);
                System.out.println("{w,c,r}("+i+","+j+"):"+Arrays.toString(Matrix[i][j]));
                i++;
                j++;
            }
            // j++;
        }
    }
    
    public static int[] Min(int[][][] args,int i ,int j) {
        int min = args[i][i][1] + args[i+1][j][1];
        int minAt = i+1;
        for (int k = i+1; k <= j; k++) {
            int sum = args[i][k-1][1] + args[k][j][1];
            if (min > sum) {
                min = sum;
                minAt = k ;
            }
        }
        // System.out.println(Arrays.toString(new int[] {min,minAt}));
        return new int[] {min,minAt};
    }
    public static void setCostRoot(int[][][] args,int i, int j) {
        if (i==j) {
            args[i][j][1] = 0;
            args[i][j][2] = 0;
        }
        else{
            args[i][j][1] += args[i][j][0];
            int min[]  = Min(args,i,j);
            args[i][j][1] += min[0];
            args[i][j][2] = min[1];
        }
    }
    public static void setWeight(int[][][] args,int i, int j) {
        if (i==j) {
            args[i][j][0] = q[i];
        }
        else{
            args[i][j][0] = args[i][j-1][0] + p[j-1] + q[j];
        }
    }
}
public class OBST
{
    public static int NO_OF_KEYS;
    public static void main(String[] args) {
        System.out.println("Enter no. of keywords");
		// Scanner sc=new Scanner(System.in);
		// NO_OF_KEYS=sc.nextInt();
        int[] p = {1,2,4,2};
        int[] q = {1,2,1,4,1};//new int[NO_OF_KEYS];
        NO_OF_KEYS = p.length;
        OBSTMatrix mat = new OBSTMatrix(NO_OF_KEYS,p,q);
        // System.out.println(Arrays.toString(mat.Matrix));
        for (int[][] i : mat.Matrix) {
            for (int[] j : i) {
                System.out.print(Arrays.toString(j));
            }
            System.out.println();
            // System.out.println(Arrays.toString(i));
        }
        // sc.close();
    }
}