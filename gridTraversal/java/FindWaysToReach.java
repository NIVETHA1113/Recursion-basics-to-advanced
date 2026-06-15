package gridTraversal.java;
import java.util.*;
class findWays1{
    public static int findWays(int r, int c, int rows, int cols){
        if(r==rows-1||c ==cols-1)
        return 1;
        return findWays(r+1,c,rows,cols)+findWays(r,c+1,rows,cols);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int res = findWays(0,0,rows,cols);
        System.out.println(res);
    }
}