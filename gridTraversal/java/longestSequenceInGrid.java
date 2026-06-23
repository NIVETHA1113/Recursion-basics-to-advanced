package gridTraversal.java;
import java.util.*;
public class longestSequenceInGrid {
    
    static int findCount(char[][]grid, int r, int c,int rows,int cols){
        int count = 1;
        if(r<0||c<0||r>=rows||c>=cols){
            return count;
        }
        int[]dx = {1,0,-1,0}; 
        int[]dy = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int x = r+dx[i];
            int y = c+dy[i];
            if(x>=0 && x<rows && y>=0 && y<cols){
            if(grid[x][y] == grid[r][c]+1){
                count = Math.max(count, 1+findCount(grid,x,y,rows,cols));
            }
                
            }
        }
        return count;
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int rows= sc.nextInt();
        int cols = sc.nextInt();
        char[][]grid = new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        int ans = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans = Math.max(ans,findCount(grid,i,j,rows,cols));
            }
        }
        System.out.println(ans);
    }
}
