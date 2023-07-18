import java.awt.*;

class APP{
	public static void main(String[] args){
		Frame f=new Frame("Displaying Textbox,checkbox");	
		f.setSize(400,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		TextField t1=new TextField("Helolo");
		Checkbox c1 = new Checkbox("item1");
		Checkbox c2 = new Checkbox("item2");
		//c1.setBounds(10, 50, 250, 30);
		f.add(t1);
		f.add(c1);
		f.add(c2);
	}
} 