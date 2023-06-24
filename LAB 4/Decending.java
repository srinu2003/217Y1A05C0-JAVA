//IMPLIMENTING BUBBLE SORT
import java.lang.*;
import java.util.*;
class Decending{
	public static void main(String args[]){
		int n;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter size of array: ");
		n = s.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements in the list");
		for(int i = 0 ; i < n ; i++){
			System.out.print("a["+i+"] = ");
			a[i] = s.nextInt();
		}
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n-i-1 ; j++){
				if(a[j]<a[j+1]){
					a[j]   = a[j] + a[j+1];
					a[j+1] = a[j] - a[j+1];
					a[j]   = a[j] - a[j+1];
				}
			}
		}
		System.out.println("Elements in list in Decending order:");
		for(int i = 0 ; i < n ; i++){
			System.out.print(a[i]+" | ");
		}
		//System.out.print(n*"_____");
	}
}