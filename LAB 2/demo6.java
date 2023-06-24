
class Demo{
	public static void main(String args[]){
		int a = 0,b=1,c,i;
		System.out.print(a+","+b);
		for(i = 0;i < 10;i++){
			c=a+b;
			System.out.print(","+c);
			a=b;
			b=c;
		}
	}
}