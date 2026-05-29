import java.util.*;
class print1ToN
{
    public static void printNum(int n){
        if(n==0)
        return;
        printNum(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNum(n);
    }
}