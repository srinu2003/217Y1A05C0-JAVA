// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import  java.util.*;
import  java.lang.*;
public class Knapsack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter capacity of Knapsack:");
        int W = s.nextInt();
        System.out.println("Enter no.of Items:");
        int objCount = s.nextInt();
        int profit[]      = new int[objCount];
        int weight[]      = new int[objCount];
        double pDensity[] = new double[objCount];
        double temp;
        int tempI;
        for (int i = 0;i<objCount;i++){
            System.out.print("Enter Profit,Weight of Item "+i+":");
            profit[i]   = s.nextInt();
            weight[i]   = s.nextInt();
            pDensity[i] = (double)profit[i]/weight[i];
        }
        System.out.println("Itemp Details:"+"\n Items\t Profit\t Weight\t Profit/Weight");
        for(int i = 0;i<objCount;i++){
            System.out.println((i+1)+"\t"+profit[i]+"\t"+weight[i]+"\t"+pDensity[i]);
        }
        for (int i = 0;i<objCount;i++){
            for(int j = i+1 ; j< objCount;j++){
                if(pDensity[i]<pDensity[j]){
                    temp        = pDensity[i];
                    pDensity[i] = pDensity[j];
                    pDensity[j] = temp;
                    
                    tempI     = profit[i];
                    profit[i] = profit[j];
                    profit[j] = tempI;
                    
                    tempI     = weight[i];
                    weight[i] = weight[j];
                    weight[j] = tempI;
                }
            }
        }
        double Profit = 0.00;
        for (int i = 0;i<objCount;i++){
            if(weight[i]<W){
                Profit += (double)profit[i];
                W -= weight[i];
            }else{
                if(W>0){
                    Profit += (double)((weight[i]*profit[i])/(double)W);
                    W -= W;
                }
            }
        }
        
        System.out.println("Itemp Details:"+"\n Items\t Profit\t Weight\t Profit/Weight");
        for(int i = 0;i<objCount;i++){
            System.out.println((i+1)+"\t"+profit[i]+"\t"+weight[i]+"\t"+pDensity[i]);
        }
        System.out.println("Total Profit:"+Profit);
    }
}
