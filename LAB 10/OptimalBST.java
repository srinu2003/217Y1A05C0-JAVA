public class OptimalBST{
    public static void main(String[] args) {
        int keys[] = {3,3,1,1};
        int freq[] = {2,3,1,1,1};
        int n = keys.length;
        System.out.println("Cost of Optimal BST is"+optimalSearchTree(keys, freq, n));
    }
    static int optCost(int freq[], int i, int j){
        if (j < i)      
            return 0;
        if (j == i)     
            return freq[i];
        int fsum = sum(freq, i, j);
        int min = Integer.MAX_VALUE;
        for (int r = i; r <= j; ++r){
            int cost = optCost(freq, i, r-1) + optCost(freq, r+1, j);
            if (cost < min)
                min = cost;
        }
        return min + fsum;
    }
    static int optimalSearchTree(int keys[], int freq[], int n){
        return optCost(freq, 0, n-1);
    }
    static int sum(int freq[], int i, int j){
        int s = 0;
        for (int k = i; k <=j; k++)
            s += freq[k];
        return s;
    }
}