import java.util.*;
class OBST72{
	public static void main(String args[]){
		int NO_OF_KEYS, i, j, k, m, n;
		System.out.println("Enter no. of keywords");
		Scanner sc=new Scanner(System.in);
		NO_OF_KEYS=sc.nextInt();
		int p[]= new int[NO_OF_KEYS];
		int q[]= new int[NO_OF_KEYS+1];
		int w[][]= new int[NO_OF_KEYS][NO_OF_KEYS];
		int c[][]= new int[NO_OF_KEYS][NO_OF_KEYS];
		int r[][]= new int[NO_OF_KEYS][NO_OF_KEYS];
		int kArray[]= new int[NO_OF_KEYS];
		String keywords[]= new String[NO_OF_KEYS];
		System.out.println("Enter "+NO_OF_KEYS+" keywords");
		for(i=0;i<=NO_OF_KEYS;i++){
			keywords[i]=sc.nextLine();
		}
		System.out.println("Enter "+NO_OF_KEYS+" values for p");
		for(i=0;i<NO_OF_KEYS;i++){
			p[i]=sc.nextInt();
		}
		System.out.println("Enter "+(NO_OF_KEYS+1)+" values for q");
		for(i=0;i<NO_OF_KEYS;i++){
			q[i]=sc.nextInt();
		}

		for(i=0;i<=NO_OF_KEYS;i++)
		{
			w[i][i]=q[i];
			c[i][i]=0;
			r[i][i]=0;
		}
		for(i=0;i<NO_OF_KEYS;i++){
			for(j=i+1;j<=NO_OF_KEYS;j++){
				w[i][j]=q[j]+p[j]+w[i][j-1];
				n=i+1;
				for(k=n;k<=j;k++){
					c[i][j]=c[i][k-1]+c[k][j]+w[i][j];
					kArray[i]=c[i][j];
					}
				k=kArray[0];  
				for(i=1;i<kArray.length;i++)  
 					if(k>kArray[i])  
 						k=kArray[i]; 
				r[i][j]=k;
				}
		}
		System.out.println("Root node is "+ keywords[r[0][NO_OF_KEYS]]);
		
	}
}