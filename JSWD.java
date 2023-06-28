import java.util.Arrays;

public class JSWD {
    /*
    In this program, we set N and D to make an ordered Execution of D jobs from a set of N jobs.
    We initialize an array `Jobs` with the numbers from 1 to N.

    The `generateSelections()` method uses recursion to generate all possible selections.
    It takes an array `jobs`, an array `selection` to store the current selection, and an `index` to track the current position in the selection.
    If the index is equal to the length of the selection, it means we have made a complete selection, so we print it.
    Otherwise, for each item in the `jobs` array, we assign it to the current position in the selection and recursively call `generateSelections()` for the next index.
    */
    public static int maxDeadLine = 0,maxProfit = 0;
    public static void main(String[] args) {
        final int Jobs[][] =  {
            /* 0 */	{2,14},
            /* 1 */	{2,15},
            /* 2 */	{1,16},
            /* 3 */	{3,19},
            /* 4 */	{3,20},
		};
        int NO_OF_JOBS = Jobs.length;
        for (int i = 0; i < NO_OF_JOBS; i++) { //Otput: Maximu m Deadline
			if (maxDeadLine < Jobs[i][0]) {
                maxDeadLine = Jobs[i][0];
			}
		}
        int N = NO_OF_JOBS; // Number of items/jobs
        int R = maxDeadLine; // Number of items/jobs to select/inorder
        
        int[][] jobs = Jobs;
        // for (int i = 0; i < N; i++) { //Initializing jobs
        //     jobs[i][] = {i,i + 1};
        // }

        int[] orderedJob = new int[R];
        boolean[] used = new boolean[N]; // Keep track of used jobs
        generateSelections(jobs, orderedJob, used, 0);
        System.out.print("Job Sequence:" + Arrays.toString(jobSequence));
        System.out.println("Profit:" + maxProfit);
    }
    public static int[] jobSequence = new int[maxDeadLine];

    public static void generateSelections(int[][] jobs, int[] orderedJob, boolean[] used, int index) {
        if (index == orderedJob.length) {
            /*Here orderedJob is the Job sequence for evaluation */
            int profit = 0;
            // System.out.print(Arrays.toString(orderedJob));
            for (int day = 0; day < orderedJob.length; day++) {
                if (jobs[orderedJob[day]][0] >= day+1) { //On this day what job we selected, that job's deadline
                profit += jobs[orderedJob[day]][1];      //should be <= to that day. Then that profit is gained
                System.out.print(orderedJob[day] + " ");
                }
                // else{
                //     profit=0;
                //     return;
                // }
            }
            if (maxProfit < profit) {
                jobSequence = orderedJob.clone();
                // System.arraycopy(orderedJob, 0, jobSequence, 0, orderedJob.length-1);
                maxProfit = profit;
            }
            System.out.print(Arrays.toString(orderedJob));
            System.out.println("Profit:"+profit);
            // System.out.println(Arrays.toString(orderedJob)+"profit:"+profit);//orderedJob complete
            // printSelection(orderedJob);//orderedJob complete
            return;
        }

        for (int i = 0; i < jobs.length; i++) {
            if (!used[i]) {
                orderedJob[index] = i;
                used[i] = true; // Mark item as used
                generateSelections(jobs, orderedJob, used, index + 1);
                used[i] = false; // Reset the used flag for backtracking
            }
        }
    }

    // public static void printSelection(int[] orderedJob) {
    //     for (int item : orderedJob) {
    //         System.out.print(item + " ");
    //     }
    //     System.out.println();
    // }
}