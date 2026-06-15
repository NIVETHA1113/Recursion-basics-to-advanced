package gridTraversal.java;
import java.util.*;
class island12{
    static void Islands(int r, int c, int rows, int cols, int[][]grid,
    boolean flag){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]==0||grid[r][c]==3||
        (!flag && grid[r][c]==1)
        ||(flag && grid[r][c]==2))
        return ;
        grid[r][c] = 3;
        int[]dx = {0,1,-1,0};
        int[]dy = {1,0,0,-1};
        for(int i=0;i<4;i++){
           Islands(r+dx[i],c+dy[i],rows,cols,grid,!flag);
        }
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
        boolean flag;
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1||grid[i][j]==2){
                    if(grid[i][j]==1)
                    Islands(i,j,rows,cols,grid,true);
                    else
                    Islands(i,j,rows,cols,grid,false);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}