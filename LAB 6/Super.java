import java.lang.*;
class Parent
{

  void display() 
{
    System.out.println("Hi I am parent method.");
  }
}
class Child extends Parent 
{

  void display() 
{
    System.out.println("Hi I am child method.");
}

  void print() 
{
    super.display();
    display();
  }
}

class Super 
{
 	public static void main(String args[]) 
{
    Child obj = new Child();
    obj.print();
  }
}