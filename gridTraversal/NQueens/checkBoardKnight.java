import java.util*;
public class checkBoardKnight {
    static boolean isSafe(int[][]grid, int r,int c){
        
        int N = grid.length;
        int current = grid[r][c];
        int[] dx = {-2,-2,-1,-1,1,1,2,2};
        int[] dy = {-1,1,-2, 2,-2,2,-1,1};
       for(int i=0;i<8;i++){
           int x = r+dx[i];
           int y = c+dy[i];
           if((x>=0)&&(x<N)&&(y>=0)&&(y<N)){
               if((grid[x][y]!= current) && (grid[x][y]!=0) )
               return false;
           }
       }
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

