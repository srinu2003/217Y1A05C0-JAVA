//Simple Matrix multiplication
//if (p == m && q == n)
import java.lang.*;
import java.util.*;
class MatrixAdd{
	public static void main(String args[]){
		int n,m,p,q;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter Dimentions of first matrix:");
		n = s.nextInt();
		m = s.nextInt();
		int a[][] = new int[n][m];
		System.out.println("Enter Elements of first matrix: ");
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				a[i][j] = s.nextInt();
			}
		}
		System.out.print("Enter Dimentions of second matrix:");
		p = s.nextInt();
		q = s.nextInt();
		if(p==n && q==m){
		int b[][] = new int[p][q];
		System.out.println("Enter Elements of second matrix: ");
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				b[i][j] = s.nextInt();
			}
		}
		int c[][] = new int[n][m];
		System.out.println("Resultant matrix after additon: ");
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				c[i][j] = a[i][j]+b[i][j];
				System.out.print(c[i][j]+" ");
			}
			System.out.println("");
		}
		}
		else{
			System.out.println("Matrices of given dimentions are incompatable for Addition!");
		}
	}
}