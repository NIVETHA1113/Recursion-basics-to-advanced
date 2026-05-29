import java.util.*;
class numReverse{
    public static int reverse(int n, int rev){
        if(n==0)
        return rev;
        rev = rev*10+n%10;
        return reverse(n/10,rev);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverse(n,0));
    }
}

