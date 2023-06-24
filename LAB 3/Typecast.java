//HELLO
import java.lang.*;
import java.util.*;
class Typecast{
	public static void main(String args[]){
		int a=7;
		float f  = 3.876f;
		char c1 = 's',c2 = 56, c3 = 260;
		double d = 52.46516444231;
		float f1 = a;
		double d2 = f;
		System.out.println("Float of 7 = " + f1);
		System.out.println("Double of 3.876 = " + d2);
		System.out.println("Int of 3.876 = " + (int)f);
		System.out.println("Float of 52.46516444231 = " + (float)d);
		System.out.println("Int of 52.46516444231 = " + (int)d);
		System.out.println("Charecters are:"+c1+","+c2+","+c3);
	}
}