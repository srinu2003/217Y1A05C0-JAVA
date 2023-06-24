//HELLO
import java.util.*;
class CurrentBill{
	public static void main(String args[]){
		int units;
		double amt=0.0;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter no.of units:");
		units=s.nextInt();
		if(units<=100){
			amt=units*1.25;
		}
		else if(100<units && units<=200){
			amt=100*1.25+(units-100)*2;
		}
		else if(200<units && units<=300){
			amt=100*1.25 + 100*2 + (units-200)*2.75;
		}
		else{
			amt=100*1.25 + 100*2 + 100*2.75 + (units-300)*3;
		}
		System.out.print("Amount = "+amt);
		s.close();
	}
}