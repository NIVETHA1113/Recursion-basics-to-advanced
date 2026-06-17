package gridTraversal.NQueens;

import java.util.*;
public class knights {
    
   static boolean isSafe(int[][]grid, int r,int c){
    int N = grid.length;
    if (r-2 >=0 && c-1 >=0 && grid[r-2][c-1] == 1)
       return false;

    if (r-1 >= 0 && c-2>=0 && grid[r-1][c-2] == 1)
        return false;

    if (r-2 >= 0 && c+1 < N && grid[r-2][c+1] == 1)
        return false;

    if (r-1 >= 0 && c+2 < N && grid[r-1][c+2] == 1)
        return false;
    return true;
   }
   static int count = 0;
   static void findQueens(int[][]grid, int r,int c, int N){
    //BLOCK 0 -> to check if we reached the end of the grid
    if(r>=N){
        count++;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return;
    }
    //BLOCK 1 -> to check if we reached the end of column
    if(c>=N){
       findQueens(grid,r+1,0,N);
           return;
    }
    //pick
    if(isSafe(grid,r,c)){
        grid[r][c] = 1;
        findQueens(grid,r,c+1,N);
    }
    grid[r][c] = 0;
    findQueens(grid,r,c+1,N);
    return;
   }
   public static void main(String[]arg){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[][]grid = new int[n][n];
       findQueens(grid,0,0,n);
   System.out.println(count);
   }
}

