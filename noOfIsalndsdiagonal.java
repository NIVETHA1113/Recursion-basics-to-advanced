 import java.util.*;
class Main{
    public static void noOfIslands(int r, int c, int rows, int cols, int[][]grid){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]!=1)
        return;
        grid[r][c]=2;
        int[]dx = {0,1,-1,0,1};
        int[]dy = {1,0,0,-1,1};
        for(int i=0;i<5;i++){
            noOfIslands(r+dx[i],c+dy[i],rows,cols,grid);
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
            int count =0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j]==1){
                        noOfIslands(i,j,rows,cols,grid);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

