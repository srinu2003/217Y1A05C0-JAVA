//Program on Constructor over loading
import java.lang.*;
import java.util.*;

class Student{
	String Name;
	String RollNo;
	String Branch;
	double percentage;
	Student(){
		Name = "Srinivas Rao T";
		RollNo = "217Y1A05C0";
		Branch = "CSE";
		percentage = 95.6;
	}
	Student(String Name,String RollNo,String Branch,double percentage){
		this.Name = Name;
		this.RollNo = RollNo;
		this.Branch = Branch;
		this.percentage = percentage;
	}
	void GetDetails(){
		System.out.println("Name: "+Name+"\nRollNo: "+RollNo+"\nBranch: "+ Branch+"\nPercentage: "+percentage);
	}
}
public class ConOverload{
	public static void main(String[] args){
		Student ravi = new Student();
		Student srinu = new Student("Sriraj D","217Y1A05C1","CSE",98.4); //Parameterised Constructor
		ravi.GetDetails();
		srinu.GetDetails();
	}
}