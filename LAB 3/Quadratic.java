//HELLO
import java.lang.*;
import java.util.*;
class Quadratic{
	public static void main(String args[]){
		int a,b,c,delta;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter a,b,c values:");
		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();
		delta = b*b-4*a*c;
		if(delta>0){
			double r1 = (-b + Math.sqrt(delta))/2*a;
			double r2 = (-b - Math.sqrt(delta))/2*a;
			System.out.print("Roots are:"+r1+","+r2);
		}
		else if (delta == 0){
			double r = (-b/2*a);
			System.out.print("Roots are:"+r+","+r);
		}
		else{
			System.out.print("Roots are imaginary");
		}
	}
}