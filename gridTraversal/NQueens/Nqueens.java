
public class Nqueens {
   static boolean isSafe(int[][]grid, int r,int c){
    int N = grid.length;
    //to search in top -> column remains same, but row changes
    for(int i=0;i<r;i++){
        if(grid[i][c]==1)
        return false;
    }
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
   static void findQueens(int[][]grid, int r, int N){
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
       for(int col =0;col<N;col++){
       if(isSafe(grid,r,col)){
           grid[r][col]=1;
           findQueens(grid,r+1,N);
           grid[r][col] = 0;
       }
       }
   }
   public static void main(String[]arg){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[][]grid = new int[n][n];
       findQueens(grid,0,n);
   System.out.println(count);
   }
}



1. Base cond
2. check if isSafe safe -> place , not safe -> dont place
3. isSafe
current = grid[r][c]
inside for loop:
if(grid[i][c]!= current)
    return false
