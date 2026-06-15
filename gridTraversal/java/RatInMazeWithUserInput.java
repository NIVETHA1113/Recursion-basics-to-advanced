package gridTraversal.java;

//Rat in Maze
import java.util.*;
class Main{
    static void ratInMaze(int N,int row1,int col1, int row_l,int col_l, 
    int [][]maze, String curr, ArrayList<String>paths){
        if(row1<0||col1<0||row1>=N||col1>=N||maze[row1][col1]==0||
        maze[row1][col1] == 2)
        return;
        if(row1==row_l && col1==col_l)
        {
            paths.add(curr);
            return;
        }
        int orig = maze[row1][col1];
        maze[row1][col1] =2;
        char dir[]={'D','R','L','U'};
        int dx[]={1,0,0,-1};
        int dy[]={0,1,-1,0};
        for(int i=0;i<4;i++){
            ratInMaze(N,row1+dx[i],col1+dy[i],row_l,col_l,
            maze,curr+dir[i],paths);
        }
        maze[row1][col1] = orig;
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][]maze = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int row_l = sc.nextInt();
        int col_l = sc.nextInt();
        ArrayList<String>paths = new ArrayList<>();
        String curr="";
        ratInMaze(N,row1,col1,row_l,col_l,maze,curr,paths);
        System.out.println(paths);
    }
}
