
import java.util.*;
public class CheckboardQueens {
    static boolean isSafe(int[][]grid, int r,int c){
        
        int N = grid.length;
        int current = grid[r][c];
       
        
        //to search in top -> column remains same, but row changes
        for(int i=0;i<N;i++){
            if(grid[i][c]!=current && grid[i][c]!=0)
                return false;
        }
        
        //to check left to right 
        
        for(int i=c+1;i<N;i++){
            if(grid[r][i]!=current && grid[r][i]!=0)
                return false;
        }
         
        System.out.print("b1 -> ");
        // check top-right(i,j) & top-left(i,k) diagonal
        for(int i=r-1,j=c+1,k=c-1;i>=0 && (j<N||k>=0);i--,j++,k--){
            if(
                // top-right(i,j)
                (j<N && (grid[i][j]!=current && grid[i][j]!=0)) ||
                // top-left(i,k)
                (k>=0 && (grid[i][k]!=current && grid[i][k]!=0))
            ) {
                return false;
            }
        }
        
        System.out.print("b2 -> ");
        // check bottom-left(i,j) & right(i,k) diagonal
        for(int i=r+1,j=c-1,k=c+1;i<N && (j>=0||k<N);i++,j--,k++){
            if(
                // bottom-left(i,j)
                (j>=0 && (grid[i][j]!=current && grid[i][j]!=0)) ||
                // right(i,k)
                (k<N && (grid[i][k]!=current && grid[i][k]!=0))
            )
                return false;
        }

        System.out.println("b3\n");
        return true;
   }
   public static void main(String[]arg){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[][]grid = new int[n][n];
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               grid[i][j]=sc.nextInt();
           }
       }
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]!=0){
                   if(!(isSafe(grid,i,j))){
                       System.out.println("The board is not safe");
                       return;
                   }
               }
           }
       }
   System.out.println("The board is safe");
   }
}

