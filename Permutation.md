# How to make ordered selection of R items from N items with out repetetion
To make an ordered selection of R items from N items, you can use the concept of permutations with repetition. The formula for the number of ordered selections is N^R (N raised to the power of R). 

If you would like to generate all possible ordered selections, you can use recursion to generate permutations. Here's an example Java program that demonstrates this:

```java
public class OrderedSelection {
    public static void main(String[] args) {
        int N = 4; // Number of items
        int R = 3; // Number of items to select
        
        int[] items = new int[N];
        for (int i = 0; i < N; i++) {
            items[i] = i + 1;
        }

        int[] selection = new int[R];
        generateSelections(items, selection, 0);
    }

    public static void generateSelections(int[] items, int[] selection, int index) {
        if (index == selection.length) {
            printSelection(selection);
            return;
        }

        for (int i = 0; i < items.length; i++) {
            selection[index] = items[i];
            generateSelections(items, selection, index + 1);
        }
    }

    public static void printSelection(int[] selection) {
        for (int item : selection) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
```

In this program, we set N to 4 and R to 3 to make an ordered selection of 3 items from a set of 4 items. We initialize an array `items` with the numbers from 1 to N.

The `generateSelections()` method uses recursion to generate all possible selections. It takes an array `items`, an array `selection` to store the current selection, and an `index` to track the current position in the selection. If the index is equal to the length of the selection, it means we have made a complete selection, so we print it. Otherwise, for each item in the `items` array, we assign it to the current position in the selection and recursively call `generateSelections()` for the next index.

When you run the program, it will output the following:

```
1 1 1
1 1 2
1 1 3
1 1 4
1 2 1
1 2 2
1 2 3
1 2 4
1 3 1
1 3 2
1 3 3
1 3 4
1 4 1
1 4 2
1 4 3
1 4 4
2 1 1
2 1 2
2 1 3
2 1 4
2 2 1
2 2 2
2 2 3
2 2 4
2 3 1
2 3 2
2 3 3
2 3 4
2 4 1
2 4 2
2 4 3
2 4 4
3 1 1
3 1 2
3 1 3
3 1 4
3 2 1
3 2 2
3 2 3
3 2 4
3 3 1
3 3 2
3 3 3
3 3 4
3 4 1
3 4 2
3 4 3
3 4 4
4 1 1
4 1 2
4 1 3
4 1 4
4 2 1
4 2 2
4 2 3
4 2 4
4 3 1
4 3 2
4 3 3
4 3 4
4 4 1
4 4 2
4 4 3
4 4 4
```
Each line represents a different ordered selection of 3 items from the set [1, 2, 3, 4].
# avoid repetition in this code
To avoid repetition in the ordered selections, you can modify the code by keeping track of the selected items and excluding them from further selection.

Here's an updated version of the code that avoids repetition:

In this updated version, we introduce a boolean array `used` to keep track of the used items. Before selecting an item, we check if it has been used before. If it hasn't, we mark it as used, add it to the selection, and recursively call `generateSelections()` for the next index. After the recursive call, we reset the used flag for backtracking, allowing other permutations to use the item.

By using the `used` array, we ensure that each item is selected only once in the ordered selections.
```java
import java.util.ArrayList;
import java.util.List;

public class OrderedSelection {
    public static void main(String[] args) {
        int N = 4; // Number of items/jobs
        int R = 3; // Number of items/jobs to select/in order
        
        int[] items = new int[N];
        for (int i = 0; i < N; i++) { // Initializing items
            items[i] = i + 1;
        }

        int[] selection = new int[R];
        boolean[] used = new boolean[N]; // Keep track of used items
        generateSelections(items, selection, used, 0);
    }

    public static void generateSelections(int[] items, int[] selection, boolean[] used, int index) {
        if (index == selection.length) {
            printSelection(selection);
            return;
        }

        for (int i = 0; i < items.length; i++) {
            if (!used[i]) {
                selection[index] = items[i];
                used[i] = true; // Mark item as used
                generateSelections(items, selection, used, index + 1);
                used[i] = false; // Reset the used flag for backtracking
            }
        }
    }

    public static void printSelection(int[] selection) {
        for (int item : selection) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
```
# The final code is 
In this program, we set N and R to make an ordered Execution of R jobs from a set of N jobs.
We initialize an array `Jobs` with the numbers from 1 to N.

The `generateSelections()` method uses recursion to generate all possible selections.
It takes an array `jobs`, an array `orderedJob` to store the current selection, and an `index` to track the current position in the orderedJob.
If the index is equal to the length of the orderedJob, it means we have made a complete ordered_selection, so we print it.
Otherwise, for each item in the `jobs` array, we assign it to the current position in the orderedJob and recursively call `generateSelections()` for the next index.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class JobSequenceGreedy{

    public static int maxDeadLine = 0,maxProfit = 0;
	public static ArrayList<Integer> jobSequence = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of jobs: ");
		int NO_OF_JOBS = sc.nextInt();
        final int Jobs[][] =  new int[NO_OF_JOBS][2];

		for (int i = 0; i < NO_OF_JOBS; i++) { //Takes: values
            System.out.print("Enter Deadline,Profit of Job{"+(i+1)+"}: ");
			for (int j = 0; j < 2; j++) {
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
    
    public static void generateSelections(int[][] jobs, int[] orderedJob, boolean[] used, int index) {
        if (index == orderedJob.length) {
            /* Evaluating OrderedJob
             * Here orderedJob is the Job sequence for evaluation */
            ArrayList<Integer> sequenceList = new ArrayList<Integer>();
            int profit = 0;
            for (int day = 0; day < maxDeadLine; day++) {
                if (jobs[orderedJob[day]][0] >= day+1) { //On this day what job we selected, that job's deadline
                profit += jobs[orderedJob[day]][1];      //should be <= to that day. Then that profit is gained
                sequenceList.add(orderedJob[day]+1);
                }
            }
            if (maxProfit < profit) {
                jobSequence = sequenceList;
                maxProfit = profit;
            }
            System.out.println(sequenceList+"profit:"+profit);//orderedJob complete
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
```