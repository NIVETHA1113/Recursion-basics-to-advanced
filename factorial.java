import java.util.*;
class factorial{
  public static int fact(int n){
      if(n==0)
      return 0;
      if(n==1)
      return 1;
      return n*fact(n-1);
  }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
}
