import java.util.*;
class findWays4ways{
    static int findWays(int r, int c, int rows, int cols, int[][]grid,
    boolean[][]vis){
        if(r<0|| c<0||grid[r][c]==1)
        return 0;
        if(r==rows-1|| c==cols-1)
        return 0;
        if(vis[r][c])
        return 0;
        vis[r][c]= true;
        int right = findWays(r,c+1,
        rows,cols,grid,vis);
        int down = findWays(r+1,c,rows,cols,grid,vis);
        int left = findWays(r,c-1,rows,cols,grid,vis);
        int up = findWays(r-1,c,rows,cols,grid,vis);
        vis[r][c] = false;
        return right+down+left+up;
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][]grid = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] vis = new boolean[rows][cols];
        System.out.println(findWays(0,0,rows,cols,grid,vis));
    }
    
}