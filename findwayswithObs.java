import java.util.*;
class Main{
    static int findWays(int r, int c, int R, int C, int[][]grid){
        if(grid[r][c]==1)
        return 0;
        if(r==R-1|| c==C-1)
        return 1;
        return findWays(r+1,c,R,C,grid)+findWays(r,c+1,R,C,grid);
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int R= sc.nextInt();
        int C = sc.nextInt();
        int[][]grid = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        if(grid[0][0]==1 || grid[R-1][C-1]==1){
            System.out.println(0);
        }
        System.out.println(findWays(0,0,R,C,grid));
    }
}