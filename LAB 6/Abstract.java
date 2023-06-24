//Abstraction
import java.util.Scanner;
abstract class shape{
    int l,b,h;
    Scanner s = new Scanner(System.in);
    abstract void printArea();
}
class Rectangle extends shape {
    void printArea() {
        System.out.println("Enter Lenght & Breadth:");
        l = s.nextInt();
        b = s.nextInt();
        System.out.println("Area of Rectangle:"+(l+b));
    }
}
class Square extends shape {
    void printArea() {
        System.out.println("Enter side:");
        l = s.nextInt();
        System.out.println("Area of Square:"+ (l*l));
    };
}
class Tryangle extends shape {
    void printArea() {
        System.out.println("Enter Base & Height:");
        b = s.nextInt();
        h = s.nextInt();
        System.out.println("Area of Tryangle:"+((b*h)/2));
    };
}
class Circle extends shape {
    void printArea() {
        System.out.println("Enter Radius:");
        l = s.nextInt();
        System.out.println("Area of Circle:"+(3.141*l*l));
    };
}
/**
 * Abstract
 */
public class Abstract {
    public static void main(String[] args) {
        Rectangle a = new Rectangle();
        Square b = new Square();
        Tryangle c = new  Tryangle();
        Circle d = new Circle();
        a.printArea();
        b.printArea();
        c.printArea();
        d.printArea();
    }
}