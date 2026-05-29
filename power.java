import java.util.*;
class findPower{
    public static int power(int n, int m){
        if(m==0)
        return 1;
        return n*power(n,m-1);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(power(n,m));
    }
}

