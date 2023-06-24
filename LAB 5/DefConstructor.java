//Program on Default constructor

class Student{
	String Name;
	String RollNo;
	String Branch;
	double percentage;
	
	void GetDetails(){
		System.out.println("Name: "+Name+"\nRollNo: "+RollNo+"\nBranch:"+ Branch+"\nPercentage:"+percentage);
	}
}
public class DefConstructor{
	public static void main(String[] args){
		Student srinu = new Student(); //Default Constructor
		srinu.Name = "Srinivas Rao T";
		srinu.RollNo = "217Y1A05C0";
		srinu.Branch = "CSE";
		srinu.percentage = 95.6;
		srinu.GetDetails();
	}
}