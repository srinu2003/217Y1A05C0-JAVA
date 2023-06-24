import java.lang.*;
import java.util.Scanner;
interface Multiplication {
    public void mul();
}
class cal implements Multiplication {
    int a,b;
    public void mul() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        a = s.nextInt();
        b = s.nextInt();
        System.out.println("Multiplication: "+(a*b));
    }
}
public class Interface{
    public static void main(String[] args) {
        cal obj = new cal();
        obj.mul();
    }
}