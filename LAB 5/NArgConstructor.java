
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
	void GetDetails(){
		System.out.println("Name: "+Name+"\nRollNo: "+RollNo+"\nBranch:"+ Branch+"\nPercentage:"+percentage);
	}
}
public class NArgConstructor{
	public static void main(String[] args){
		Student srinu = new Student(); //Non Argument Constructor
		srinu.GetDetails();
	}
}