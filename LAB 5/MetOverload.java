//Program on Constructor over loading


class Addition{
	void add(){
		System.out.println(0);
	}
	void add(int a,int b,int c){
		System.out.println((a+b+c));
	}
	void add(int a,int b){
		System.out.println((a+b));
	}
}
public class MetOverload{
	public static void main(String[] args){
		Addition a = new Addition();
		a.add();
		a.add(1,2,3);
		a.add(6,7);
	}
}