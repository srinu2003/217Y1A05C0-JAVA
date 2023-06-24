//HELLO
import java.lang.*;
import java.util.*;
class Amstrong{
	public static void main(String args[]){
		int n,sum=0,m;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter a number:");
		n = s.nextInt();
		m = n;
		while(m!=0){
			sum += (m%10)*(m%10)*(m%10);
			m /= 10;
		}
		if (sum==n){
			System.out.print("Is Amstrong!");
		}
		else{
			System.out.print("Is not Amstrong!");
		}
	}
}