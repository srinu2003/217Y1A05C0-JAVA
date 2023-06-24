import java.lang.*;
interface Emp {
	public void ursalary();
}
interface Empbonus {
	public void urbonus();
}
class tot implements Emp,Empbonus {
	public void ursalary() {
        int salary=500000;
        System.out.println("Salary:"+salary);
    }
	public void urbonus() {
	    int bonus=50000;
	    System.out.println("Bonus:"+bonus);
    }
}

class Interface2 {
	public static void main(String args[]) {
		tot me=new tot();
		me.ursalary();
		me.urbonus();
	}
}