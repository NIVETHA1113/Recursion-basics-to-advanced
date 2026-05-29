import java.util.*;
class countDigits{
    public static int counter(int n, int count){
        if(n==0)
        return count;
        return counter(n/10,count+1);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(counter(n,0));
    }
}
