package gridTraversal;
import java.util.*;
public class SearchMultipleWords {
    public static void findpaths(int r,int c, int rows, int cols, 
    char[][]grid,String word, int ind,List<String>paths, String curr){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]=='@'||
        grid[r][c]!=word.charAt(ind))
        return;
        int len = word.length();
        if(ind==len-1){
            if(word.charAt(ind) == grid[r][c]){
                paths.add(curr);
            }
            return;
        }
        char orig = grid[r][c];
        grid[r][c] = '@';
        int[]dx = {1,0,-1,0};  
        int[]dy = {0,1,0,-1};
        char[]dir = {'D','R','U','L'};
        for(int i=0;i<4;i++){
            findpaths(r+dx[i],c+dy[i],rows,cols,grid,word,ind+1,paths,
            curr+dir[i]);
        }
        grid[r][c] = orig;
    }
        public static void main(String[]arg){
            Scanner sc = new Scanner(System.in);
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            char[][]grid = new char[rows][cols];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    grid[i][j] = sc.next().charAt(0);
                }
            }
            int m = sc.nextInt();
            String[]words = new String[m];
            for(int i=0;i<m;i++){
                words[i] = sc.next();
            }
            List<List<String>>paths = new ArrayList<>();
            for(int i=0;i<m;i++){
            paths.add(new ArrayList<>());
            }
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    for(int k=0;k<m;k++){
                    
                        if(words[k].charAt(0)==grid[i][j])
                        findpaths(i,j,rows,cols,grid,words[k],0,paths.get(k),"");
                    }
                }
            }
            System.out.println(paths);
        }
}

