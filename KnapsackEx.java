import java.lang.*;
class KnapsackEx{
   static int KnapSack(int W,int wt[],int val[],int n){
      int[] dp = new int[W + 1];
       for (int i = 1; i < n + 1; i++) {
           for (int w = W; w >= 0; w--) {
               if (wt[i - 1] <= w)
                  dp[w] = Math.max(dp[w], dp[w - wt[i - 1]]+ val[i - 1]);
            }
        }
        return dp[W];
    }
    public static void main(String[] args)
    {
        int profit[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.print(KnapSack(W, weight, profit, n));
    }
}
 