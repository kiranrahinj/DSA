//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int dr[]={-1,0,0,1};
    private int dc[]={0,-1,1,0};
    private void dfs(int r,int c,int [][]grid,boolean vis[][]){
        vis[r][c]=true;

        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<0 ||nr>=row ||nc<0 ||nc>=col)continue;

            if(grid[nr][nc]==1 && vis[nr][nc]==false){
                dfs(nr,nc,grid,vis);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

         int row=grid.length;
        int col=grid[0].length;

        boolean vis[][]=new boolean[row][col];

        for(int i=0;i<col;i++){
            if(grid[0][i]==1 && vis[0][i]==false){
                dfs(0,i,grid,vis);
            }

            if(grid[row-1][i]==1 && vis[row-1][i]==false){
                dfs(row-1,i,grid,vis);
            }
        }

        for(int i=0;i<row;i++){
            if(grid[i][0]==1 && vis[i][0]==false){
                dfs(i,0,grid,vis);
            }

            if(grid[i][col-1]==1 && vis[i][col-1]==false){
                dfs(i,col-1,grid,vis);
            }
        }
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    ans++;
                }
            }
        }
        return ans;
    }
}