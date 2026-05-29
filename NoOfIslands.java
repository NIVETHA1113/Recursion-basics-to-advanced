/**

* Problem: Number of Islands
* ---
* Given a 2D grid consisting of 0s and 1s:
*
* • 1 represents land.
* • 0 represents water.
*
* An island is formed by connecting adjacent land cells
* horizontally or vertically (4-directional connectivity).
*
* The task is to count the total number of islands present
* in the grid.
*
* Method: noOfIslands(int r, int c, int rows, int cols, int[][] grid)
* ---
* Recursively traverses and marks all connected land cells
* belonging to the same island.
*
* Logic:
* • The function explores all 4 directions:
* ```
  - Right
  ```
* ```
  - Down
  ```
* ```
  - Up
  ```
* ```
  - Left
  ```
*
* • A cell is processed only if:
* ```
  - It lies within the grid boundaries.
  ```
* ```
  - It contains land (value 1).
  ```
*
* • Recursive Step:
* ```
  - Mark the current land cell as visited by changing
  ```
* ```
    its value from 1 to 2.
  ```
* ```
  - Recursively visit all 4 neighboring cells.
  ```
*
* • Counting Islands:
* ```
  - Traverse every cell of the grid.
  ```
* ```
  - Whenever a cell with value 1 is found:
  ```
* ```
      → Start DFS from that cell.
  ```
* ```
      → Mark all connected land cells.
  ```
* ```
      → Increment the island count.
  ```
*
* Example:
*
* Input:
* 4 5
* 1 1 1 1 0
* 1 1 0 1 0
* 1 1 0 0 1
* 0 0 1 1 0
*
* Output:
* 3
*
* Explanation:
*
* Island 1:
* 1 1 1 1
* 1 1   1
* 1 1
*
* Island 2:
* ```
      1
  ```
*
* Island 3:
* ```
  1 1
  ```
*
* Therefore, total number of islands = 3.
*
* Complexity:
* • Time  : O(rows × cols)
* ```
        Each cell is visited at most once.
  ```
*
* • Space : O(rows × cols)
* ```
        Due to recursion stack in the worst case.
  ```
*
* Concepts Used:
* • Depth First Search (DFS)
* • Matrix Traversal
* • Flood Fill Technique
* • Connected Components
  */


import java.util.*;
class Main{
    static void findIslands(int r, int c,int rows, int cols,int[][]grid){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]!=1)
        return;
        grid[r][c] = 2;
        int[]dx = {0,1,-1,0};
        int[]dy = {1,0,0,-1};
        for(int i=0;i<4;i++){
            findIslands(r+dx[i],c+dy[i],rows,cols,grid);
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
                        findIslands(i,j,rows,cols,grid);
                        count++;
                    }
                    
                }
            }
            System.out.println(count);
        }
    }
