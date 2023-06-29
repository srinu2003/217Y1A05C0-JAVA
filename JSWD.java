import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
		// sc.useDelimiter(","  javaWhitespace);
        System.out.print("Enter no.of jobs: ");
		int NO_OF_JOBS = sc.nextInt();
        final int Jobs[][] =  new int[NO_OF_JOBS][2];

		for (int i = 0; i < NO_OF_JOBS; i++) { //Takes: values
			for (int j = 0; j < 2; j++) {
                System.out.print("Enter Deadline,Profit of Job{"+(i+1)+"}: ");
				Jobs[i][j] = sc.nextInt();
			}
		}
        for (int i = 0; i < NO_OF_JOBS; i++) { //Opts: Maximum Deadline
			if (maxDeadLine < Jobs[i][0]) {
                maxDeadLine = Jobs[i][0];
			}
		}
        int N = NO_OF_JOBS; // Number of items/jobs
        int R = maxDeadLine; // Number of items/jobs to select/inorder
        
        int[] orderedJob = new int[R];
        boolean[] used = new boolean[N]; // Keep track of used jobs
        generateSelections(Jobs, orderedJob, used, 0); //Gives P(N,R) ordered selections
        System.out.print("Job Sequence:" + jobSequence);
        System.out.println("Profit:" + maxProfit);
        sc.close();
    }
    public static ArrayList<Integer> jobSequence = new ArrayList<Integer>(maxDeadLine);
    
    public static void generateSelections(int[][] jobs, int[] orderedJob, boolean[] used, int index) {
        if (index == orderedJob.length) {
            /* Evaluating OrderedJob
             * Here orderedJob is the Job sequence for evaluation */
            ArrayList<Integer> sequenceList = new ArrayList<Integer>();
            // sequenceList.clear();
            int profit = 0;
            // System.out.print(Arrays.toString(orderedJob));
            for (int day = 0; day < orderedJob.length; day++) {
                if (jobs[orderedJob[day]][0] >= day+1) { //On this day what job we selected, that job's deadline
                profit += jobs[orderedJob[day]][1];      //should be <= to that day. Then that profit is gained
                sequenceList.add(orderedJob[day]+1);
                // System.out.print(orderedJob[day] + " ");
                }
            }

            if (maxProfit < profit) {
                jobSequence = sequenceList;
                maxProfit = profit;
            }

            System.out.print(sequenceList);
            System.out.println("Profit:"+profit);
            // System.out.println(Arrays.toString(orderedJob)+"profit:"+profit);//orderedJob complete
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
}