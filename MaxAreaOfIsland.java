// Maximum Area of an Island (DFS)
// Problem Statement

// Given a binary matrix grid of size m × n:

// 1 represents land 🌱
// 0 represents water 🌊

// An island is a group of connected land cells (1s) connected horizontally or vertically.

// Find the maximum area of any island in the grid.

// The area of an island is the total number of land cells belonging to that island.

// Approach: DFS (Depth First Search)
// Main Idea
// Traverse every cell in the matrix.
// Whenever a land cell (1) is found:
// Start a DFS from that cell.
// Count all connected land cells.
// Mark visited cells as 2 to avoid revisiting.
// Compare the area of the current island with the maximum area found so far.
// Return the maximum area.
// DFS Logic
// Base Case

// Stop recursion when:

// r < 0 || c < 0 ||
// r >= rows || c >= cols ||
// grid[r][c] != 1

// This means:

// Out of bounds ❌
// Water cell ❌
// Already visited cell ❌
// Mark Current Cell as Visited
// grid[r][c] = 2;

// This prevents infinite recursion and duplicate counting.

// Explore All 4 Directions
// Right  -> (r, c+1)
// Down   -> (r+1, c)
// Up     -> (r-1, c)
// Left   -> (r, c-1)

// Using:

// int[] dx = {0, 1, -1, 0};
// int[] dy = {1, 0, 0, -1};
// Count Area

// Current cell contributes:

// count = 1;

// Then add the area obtained from all connected neighbors.

// count += DFS(neighbor);
// Dry Run
// Input
// 1 1 0 0
// 1 1 0 1
// 0 0 1 1
// 0 0 0 1
// Islands
// 1 1       Area = 4
// 1 1

//       1
//     1 1
//       1

// Largest area:

// 4
// Time Complexity

// Every cell is visited at most once.

// O(rows × cols)
// Space Complexity

// Recursive stack in worst case:

// O(rows × cols)

// when the entire grid is one big island.

// Revision Keywords 🎯
// Matrix Traversal
// DFS
// Flood Fill
// Connected Components
// Island Problems
// Mark Visited
// Area Counting
// Pattern to Remember
// For every cell:
//     if land:
//         DFS()
//         compute area
//         update maximum area

// This same pattern is used in:

// Number of Islands
// Max Area of Island
// Flood Fill
// Surrounded Regions
// Count Connected Components in a Grid
// Tiny Memory Trick 🧠

// Number of Islands → Count how many DFS calls are made.

// Maximum Area of Island → Count how many cells each DFS visits and keep the maximum.

import java.util.*;
class Main{
    static int noOfIslands(int r, int c, int rows, int cols,int[][]grid){
        if(r<0||c<0||r>=rows||c>=cols||grid[r][c]!=1)
        return 0;
        grid[r][c] = 2;
        int[]dx = {0,1,-1,0};
        int[]dy = {1,0,0,-1};
        int count=1;
        for(int i=0;i<4;i++){
            count+=noOfIslands(r+dx[i],c+dy[i],rows,cols,grid);
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
        int max_c=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                int area = noOfIslands(i,j,rows,cols,grid);
                max_c=Math.max(max_c,area);
                }
            }
        }
        System.out.println(max_c);
    }
}