import java.util.*;
class Main{
    public static void findWord(int r, int c, int rows, int cols, 
    char[][]grid, String[] words,int ind1,int ind2, String curr,
    List<String>paths,int m){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]!=words[ind2].charAt(ind1)||
        grid[r][c]=='@')
        return;
        int len = words[ind2].length();
        if(ind1==len-1 && ind2 == m-1){
            if(grid[r][c]==words[ind2].charAt(ind1)){
            paths.add(curr);}
        return;
        }
        char orig= grid[r][c];
        grid[r][c] = '@';
        int[]dx = {1,0,-1,0};
        int[]dy = {0,1,0,-1};
        char[]dir ={'D','R','U','L'};
        for(int i=0;i<4;i++){
            findWord(r+dx[i],c+dy[i],rows,cols,grid,words,ind1+1,ind2+1,
            curr+dir[i],paths,m);
        }
        grid[r][c] = orig;
    }
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        char[][]grid = new char[rows][cols];
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        grid[i][j] = sc.next().charAt(0);
        int m = sc.nextInt();
        String[]words = new String[m];
        for(int i=0;i<m;i++)
            words[i]= sc.next();
        List<String>ans = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(words[0].charAt(0)==grid[i][j])
                findWord(i,j,rows,cols,grid,words,0,0,"",ans,m);
            }
            }
        System.out.println(ans);
    }
}