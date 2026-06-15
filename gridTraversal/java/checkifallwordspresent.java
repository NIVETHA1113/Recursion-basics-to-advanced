package gridTraversal.java;

public class checkifallwordspresent {
    public static boolean findpaths(int r,int c, int rows, int cols, 
    char[][]grid,String word, int ind){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]=='@'||
        grid[r][c]!=word.charAt(ind))
        return false;
        int len = word.length();
        if(ind==len-1){
            return true;
        }
        char orig = grid[r][c];
        grid[r][c] = '@';
        int[]dx = {1,0,-1,0};  
        int[]dy = {0,1,0,-1};
        for(int i=0;i<4;i++){
        boolean ans =    findpaths(r+dx[i],c+dy[i],rows,cols,grid,word,ind+1);
            if(ans){
                grid[r][c] = orig;
            return true;
            }
        }
        grid[r][c] = orig;
        return false;
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
            boolean exists = false;
            for(int k=0;k<m;k++){
                exists  = false;
                for(int i=0;i<rows;i++){
                    for(int j=0;j<cols;j++){
                    
                        if(words[k].charAt(0)==grid[i][j] &&
                        (findpaths(i,j,rows,cols,grid,words[k],0))){
                         exists = true;  
                         break;
                        }
                        
                    }
                    if(exists)
                    break;
                    
                }
                if(!exists)
                break;
            }
            // int max = Integer.MIN_VALUE;
            // if(exists){
            //     for(int i=0;i<m;i++){
            //         if(words[i].length()>max){
            //             max = words[i].length();
            //         }
            //     }
            // }
             if(exists){
                 System.out.println("The words exists");
             }
             else{
                 System.out.print("doesnot exist");
             }
            
     }
}
