import java.util.*;
class proOfDig{
    public static int proofdig(int n, int pro){
        if(n==0)
        return pro;
        pro = pro*(n%10);
        return proofdig(n/10,pro);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(proofdig(n,1));
    }
}
