/**
 * Parent
 */
class Parent {

    void display() {
        System.out.println("Parent Method");
    }
}
/**
 * Child
 */
class Child extends Parent {

    void display() {
        System.out.println("Child Method");
    }
    void show() {
        super.display();
        display();
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();
    }
}
