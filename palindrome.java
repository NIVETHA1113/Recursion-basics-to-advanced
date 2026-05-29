import java.util.*;
class palindrome{
    public static int reverse(int n, int rev){
        if(n==0)
        return rev;
        rev = rev*10+n%10;
        return reverse(n/10, rev);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = reverse(n,0);
        if(r==n){
            System.out.println("The given number is palindrome");
        }
        else{
            System.out.println("The given number is not a palindrome");
        }
    }
}