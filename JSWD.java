import java.util.Arrays;

public class JSWD {
    /*
    In this program, we set N and D to make an ordered Execution of D jobs from a set of N jobs.
    We initialize an array `Jobs` with the numbers from 1 to N.

    The `generateSelections()` method uses recursion to generate all possible selections.
    It takes an array `items`, an array `selection` to store the current selection, and an `index` to track the current position in the selection.
    If the index is equal to the length of the selection, it means we have made a complete selection, so we print it.
    Otherwise, for each item in the `items` array, we assign it to the current position in the selection and recursively call `generateSelections()` for the next index.
    */
    public static void main(String[] args) {
        final int Jobs[][] =  {
			{2,14},
			{2,15},
			{1,16},
			{3,19},
			{3,20},
		};
        int NO_OF_JOBS = Jobs.length;
        int maxDeadLine = 0;
        int N = NO_OF_JOBS; // Number of items/jobs
        for (int i = 0; i < N; i++) { //Otput: Maximu m Deadline
			if (maxDeadLine < Jobs[i][0]) {
				maxDeadLine = Jobs[i][0];
			}
		}
        int R = maxDeadLine; // Number of items/jobs to select/inorder
        
        int[][] items = Jobs;
        // for (int i = 0; i < N; i++) { //Initializing items
        //     items[i] = i + 1;
        // }

        int[] selection = new int[R];
        boolean[] used = new boolean[N]; // Keep track of used items
        generateSelections(items, selection, used, 0);
    }

    public static void generateSelections(int[][] items, int[] selection, boolean[] used, int index) {
        if (index == selection.length) {
            int profit = 0;
            for (int item : selection) {
                profit += items[item][1];
                System.out.print(item + " ");
            }
            System.out.print("Profit:"+profit);
            System.out.println(Arrays.toString(selection));//selection complete
            // printSelection(selection);//selection complete
            return;
        }

        for (int i = 0; i < items.length; i++) {
            if (!used[i]) {
                selection[index] = i;
                used[i] = true; // Mark item as used
                generateSelections(items, selection, used, index + 1);
                used[i] = false; // Reset the used flag for backtracking
            }
        }
    }

    // public static void printSelection(int[] selection) {
    //     for (int item : selection) {
    //         System.out.print(item + " ");
    //     }
    //     System.out.println();
    // }
}