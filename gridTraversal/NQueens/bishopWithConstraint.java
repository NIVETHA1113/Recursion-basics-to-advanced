import java.util.*;
public class bishopWithConstraint {
    {
   static boolean isSafe(int[][]grid, int r,int c){
    int N = grid.length;
    //check top-left diagonal
    for(int i= r-1,j=c-1;i>=0 && j>=0;i--,j--){
        if(grid[i][j] ==1)
        return false;
    }
    //check top-right diagonal
    for(int i=r-1,j=c+1;i>=0 &&j<N;i--,j++){
        if(grid[i][j]==1)
        return false;
    }
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
       for(int i=0;i<c;i++){
        if(grid[r][i]==1){
       findQueens(grid,r+1,0,N);
       return;}
           }
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
}
