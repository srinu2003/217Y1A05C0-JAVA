import java.util.Scanner;

public class JobSequenceGreedy{
	/*INPUT: no.of jobs:5
	2 14
	2 15
	1 16
	3 19
	3 20
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.of jobs: ");
		int NO_OF_JOBS = sc.nextInt();
		int Job[][] = new int[NO_OF_JOBS][2];
		int /*maxAtIndex = 0,*/maxDeadLine=0;
		String sequence = new String("");
		
		System.out.println("Enter Deadline Profit: ");
		for (int i = 0; i < NO_OF_JOBS; i++) { //Takes: values
			for (int j = 0; j < 2; j++) {
				Job[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < NO_OF_JOBS; i++) { //Otput: Maximum Deadline
			if (maxDeadLine < Job[i][0]) {
				maxDeadLine = Job[i][0];
			}
		}
		
		// for (int i = maxDeadLine; i > 0; i--) {
		// 	String strJob = new String("");
		// 	int maxProfit = Job[0][1];
		// 	for (int j = 0; j < NO_OF_JOBS; j++) { //Gets: Maximum Profit
		// 		if (Job[j][0] >= maxDeadLine && maxProfit < Job[j][1]) {
		// 			strJob = String.valueOf(j);
		// 			maxProfit = Job[j][1];
		// 			maxAtIndex = j;
		// 		}
		// 	}
		// 	// System.out.println(strJob);
		// 	sequence += "<--" + (Integer.valueOf(strJob)+1); //System.out.println(sequence);
		// 	Job[maxAtIndex][0]=0;//Job executed
		// 	maxDeadLine--;
		// }
		System.out.println("The sequence is:");
		System.out.println(sequence);
		sc.close();
	}
}