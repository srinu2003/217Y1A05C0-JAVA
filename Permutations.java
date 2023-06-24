import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        int arr[][] =  {
			{2,14},
			{2,15},
			{1,16},
			{3,19},
			{3,20},
		};
        printPermutations(arr);
    }

    public static void printPermutations(int[][] arr) {
        int n = arr.length;
        boolean[] used = new boolean[n];
        int[] permutation = new int[n];
        permute(arr, used, permutation, 0);
    }

    public static void permute(int[][] arr, boolean[] used, int[] permutation, int currentIndex) {
        if (currentIndex == arr.length) {
            // for (int i : permutation) {
            //     if (arr[i][0]) {
                    
            //     }
            // }
            System.out.print(Arrays.toString(permutation));
            System.out.println("Profit:"+arr[permutation[0]][1]);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation[currentIndex] = i;//arr[i][0];
                permute(arr, used, permutation, currentIndex + 1);
                used[i] = false;
            }
        }
    }
}
