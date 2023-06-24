//HELLO
import java.lang.*;
import java.util.*;
class Demo{
	public static void main(String args[]){
		Scanner S=new Scanner(System.in);
		int age;
		System.out.print("Enter age:");
		age = S.nextInt();
		if (age>=18){
			System.out.print("Eligible for voting");
		}
		else{
			System.out.print("Not eligible for voting");
		}
	}
}