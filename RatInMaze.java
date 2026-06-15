
import java.util.*;

class RatInMaze {

    /**
     * Method: solve(int[][] maze, int i, int j, int N, String cur, ArrayList<String> paths)
     * -------------------------------------------------------------------------------------
     * Recursively explores all valid paths from the top-left (0,0) to the bottom-right (N-1,N-1)
     * of an N x N maze grid, collecting path directions using backtracking.
     *
     * Logic:
     * • The function explores all 4 directions from the current cell: Down, Left, Right, Up.
     * • A cell can only be visited if:
     *     - It is within the bounds of the grid.
     *     - It is not a wall (represented by 0).
     *     - It has not been visited before in the current path (marked as 2).
     *
     * • Base Case:
     *     If (i == N-1 && j == N-1), a valid path has been found.
     *     → Add the path string `cur` to the result list `paths`.
     *
     * • Backtracking:
     *     - Mark the current cell as visited by setting maze[i][j] = 2.
     *     - Explore all four directions recursively with updated path string.
     *     - After exploring, unmark the cell (restore original value) to allow other paths.
     *
     * Example:
     * Input:
     * maze = [[1, 0, 0, 0],
     *         [1, 1, 0, 1],
     *         [1, 1, 0, 0],
     *         [0, 1, 1, 1]]
     *
     * Output:
     * ["DDRDRR", "DRDDRR"]
     *
     * Path letters:
     * - D → Down
     * - L → Left
     * - R → Right
     * - U → Up
     *
     * Complexity:
     * • Time  : O(4^(N^2)) – worst case explores all directions from each cell.
     * • Space : O(N^2) – for recursion stack and path string storage.
     */

    public static void solve(int maze[][],int r,int c,int N,String cur,ArrayList<String> paths) {

        if(r==N-1 && c==N-1) {
            paths.add(cur);
            return;
        }
        
        if(r<0 || c<0 || r>=N || c>=N || maze[r][c]==0 || maze[r][c]==2)
            return;
            
        int orig=maze[r][c];
        maze[r][c]=2;

        char dir[]={'D','R','L','U'};
        int dx[]={1,0,0,-1};
        int dy[]={0,1,-1,0};
            
        for(int ind=0;ind<4;ind++)
            solve(maze,r+dx[ind],c+dy[ind],N,cur+dir[ind],paths);
        
        maze[r][c]=orig;
    }

    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int maze[][]=new int[N][N];

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                maze[i][j]=sc.nextInt();

        ArrayList<String> paths=new ArrayList<>();
        String cur="";
        
        solve(maze,0,0,maze.length,cur,paths);

        System.out.print(paths);

        sc.close();
    }
}

// Basics:

// Add the function into the stack: (which means moving to the new state)
// 1. calling function (i.e -> during [3. Traversal in all direction])

// Remove the function from the stack: (which means it moves to the prev state (i.e) backtrack)
// 1.explicit (return)
// 2.implicit (end of function (i.e) '}')

// ________________________________________________________________________________________________

// Genral terminologies used:
// 1 -> can traverse
// 0,2 -> cannot traverse (where 0->obstracle and 2-> visited)

// ________________________________________________________________________________________________

// Process

// 1. Base condition (r<0 || c<0 || r>=R || c>=C || g[r][c]==0 || g[r][c]==2)

// 2. Store curr(org) val in temp 

// 3. make curr val as 2 (which means marking as visited)

// 4. Traversal in all direction

// Add the function into the stack 
// R = r,c+1
// Remove the function from the stack
// Add the function into the stack
// D = r+1,c 
// Remove the function from the stack
// Add the function into the stack
// L = r,c-1 
// Remove the function from the stack
// Add the function into the stack
// U = r-1,c
// Remove the function from the stack

// 5. make curr val as temp (i.e -> 1) (which means marking as unvisited)

// ________________________________________________________________________________________________


// Rough works    D R L U   Path=[DDRR,DRDR] curr=DRDR

//   0    1    2
// 0 2()  0()  0()
// 1 2(D) 2(DR)  0()
// 2 1()  2(DRD)  1()

//   0 1 2
// 0 2 X X
// 1 1 X X
// 2 1 X X

// State 2 : T (Before back tracking make bool as F) 
// State 1 : F

//   ind =>      0  1  2  3
//      dir =  { D  R  L  U }
// row => dx = { 1  0  0 -1 }
// col => dy = { 0  1 -1  0 }

// for(int ind=0;ind<4;ind++)
//     solve(maze,r+dx[ind],c+dy[ind],N,cur+dir[ind],paths);


// 0 solve(maze,i+1,j,N,cur+'D',paths);
// 1 solve(maze,i,j-1,N,cur+'L',paths);
// 2 solve(maze,i,j+1,N,cur+'R',paths);
// 3 solve(maze,i-1,j,N,cur+'U',paths);

1 0 0 
1 1 0
1 1 0
0 0
1 1