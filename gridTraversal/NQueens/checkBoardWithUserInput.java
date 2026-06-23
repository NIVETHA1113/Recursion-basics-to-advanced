public class checkBoardWithUserInput {
    static boolean isSafe(int[][]grid, int r,int c,int piece){
        
        int N = grid.length;
        int current = grid[r][c];
       
        if(piece==1 || piece==2){
            if(piece==1){
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
        return true;
            
}
        
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
       System.out.println("Enter the piece");
       System.out.println("Enter 1 for queen");
       System.out.println("Enter 2 for bishop");
       System.out.println("Enter 3 for knight");
       int piece = sc.nextInt();
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]!=0){
                   if(!(isSafe(grid,i,j,piece))){
                       System.out.println("The board is not safe");
                       return;
                   }
               }
           }
       }
   System.out.println("The board is safe");
   }
}


