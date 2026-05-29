import java.util.*;
class sumOfDigits{
    public static int sumofdig(int n, int sum){
        if(n==0)
        return sum;
        sum = sum+(n%10);
        return sumofdig(n/10,sum);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumofdig(n,0));
    }
}