import java.util.*;
class Main{
    static int Islands(int r, int c, int rows, int cols, int[][]grid,
    int next){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]==0||grid[r][c]==4||
       grid[r][c]!=next )
        return 0 ;
        int current = grid[r][c];
        grid[r][c] = 0;
        if(current == 1)
        next = 2;
        else if(current == 2)
        next = 3;
        else if(current ==3)
        next = 1;
        int count =1;
        int[]dx = {0,1,-1,0,1,1,-1,-1};
        int[]dy = {1,0,0,-1,1,-1,1,-1};
        for(int i=0;i<8;i++){
           count+=Islands(r+dx[i],c+dy[i],rows,cols,grid,next);
        }
        return count;
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
        
        int max_area=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]!=0 && grid[i][j]!=4){
                    int ans = Islands(i,j,rows,cols,grid,grid[i][j]);
                    max_area = Math.max(ans,max_area);
                    
                    //.out.println(count+" "+i+" "+j);
                     //System.out.println("____");
            //         for(int k=0;k<rows;k++){
            // for(int l=0;l<cols;l++){
                   
                    
            //         System.out.print(grid[k][l]+" ");
                    
            // }
            // System.out.println();
            //         }
                }
            }
        }
        System.out.println(max_area);
    }
}
