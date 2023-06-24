import java.util.*;

public class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = sc.nextLine();
        int n = str.length();
        for(int i = 0;i < n;i++){
            if(str.charAt(i) != str.charAt(n - i - 1)){
                System.out.println("Not a Palindrome.");
                sc.close();
                return;
            }
        }
        System.out.println("Palindrome.");
        sc.close();
    }
}
