public class APSP {
    public static void main(String[] args) {
        int[][] p = {   { 0, 6,14},
                        { 6, 0, 2},
                        {14, 2, 0}};
        int n = p.length;
        OptimalAPSP(p,n);
    }
    /**
     * This is to solve All Pair Shortest Path problem
     * using  Dynamic programming
     */
    public static void OptimalAPSP(int a[][],int n){
        for(int k = 0;k<n;k++){ //recurring : Dynamic programming
            for(int i = 0; i<n;i++){
                for(int j = 0; j<n;j++){
                    a[i][j] = Math.min(a[i][j],a[i][k]+a[k][j]);
                }
            }
        }
        System.out.println("All Pair Shortest Path is:");
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                System.out.print(a[i][j]+", ");
            }
            System.out.println();
        }
    }
}