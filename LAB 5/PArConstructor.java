//Program on Parameterised Constructor

class Student{
	String Name;
	String RollNo;
	String Branch;
	double percentage;
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
public class PArConstructor{
	public static void main(String[] args){
		Student srinu = new Student("Srinivas Rao T","217Y1A05C0","CSE",95.6); //Parameterised Constructor
		srinu.GetDetails();
	}
}