//HELLO
import java.util.*;
class Spalin{
	public static void main(String args[]){
		String a,b;
		int alen;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter a Line:");
		a = s.nextLine();
		alen = a.length();
		char[] ac = new char[alen],bc = new char[alen];
		for(int i = 0;i < alen; i++){
			ac[i] = a.charAt(i);
			bc[alen - i] = ac[i];
		}
		b = new String(bc);
		if(a==b){
			System.out.print("String is Pallindrom!");
		}
		else{
			System.out.print("String is not Pallindrom!");
		}
	}
}