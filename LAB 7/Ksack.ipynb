```mermaid
graph TD;
A((Start)) --> B[Initialize input];
B --> C[Initialize the Ksack matrix];
C --> D[/Calculate maximum value/];
D --> E[Print maximum value];
E --> F((Stop));
```
```java
import java.util.Scanner;
public class Knap {
    
    public static int knapsack(int M, int[] wt, int[] profit) {
        int n = wt.length;
        int[][] Ksack = new int[n+1][M+1];
        
        // Build the table Ksack[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= M; w++) {
                if (i == 0 || w == 0)
                    Ksack[i][w] = 0;
                else if (wt[i-1] <= w)
                    Ksack[i][w] = Math.max(profit[i-1] + Ksack[i-1][w-wt[i-1]], Ksack[i-1][w]);
                else
                    Ksack[i][w] = Ksack[i-1][w];
            }
        }
 
        return Ksack[n][M];
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int[] profit = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int M = 50;
        int maxVal = knapsack(M, wt, profit);
        
        System.out.println("Maximum value that can be obtained: " + maxVal);
        s.close();
    }
}
```
