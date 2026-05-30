import java.util.*;
class NthLargestIsland{
    static int maxArea(int r,int c, int rows, int cols,int[][]grid){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]!=1)
        return 0;
        int count =1;
        grid[r][c] = 2;
        int[]dx = {0,1,-1,0};
        int[]dy = {1,0,0,-1};
        for(int i=0;i<4;i++){
            count+=maxArea(r+dx[i],c+dy[i],rows,cols,grid);
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
        int n = sc.nextInt();
        int max_n = 0;
        ArrayList<Integer>res = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                res.add(maxArea(i,j,rows,cols,grid));
                }
            }
        }
        int[]arr = new int[res.size()];
        int ind =0;
        for(Integer num:res){
            arr[ind++] = num;
        }
        Arrays.sort(arr);
        System.out.println(arr[n-1]);
    }
}