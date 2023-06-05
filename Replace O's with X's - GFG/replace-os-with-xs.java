//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java\
class Solution{
 static int[] dr = new int[]{-1, 0, 1, 0};
 static int[] dc = new int[]{0, 1, 0, -1};

 static void dfs(int r, int c, char[][] grid, boolean[][] vis)
{
    vis[r][c]=true;

    int row = grid.length;
    int cols = grid[0].length;

    for(int i=0;i<4;i++){
        int nr=r+dr[i];
        int nc=c+dc[i];

        if(nr<0 ||nr>=row ||nc<0 ||nc>=cols)continue;
        if(grid[nr][nc]=='O' && vis[nr][nc]==false){
            dfs(nr,nc,grid,vis);
        }
    }
}


    static char[][] fill(int n, int m, char grid[][])
    {
        int row = grid.length;
     int col = grid[0].length;
  
    boolean[][] vis = new boolean[row][col];

    
    for(int i=0;i<col;i++){
        if(grid[0][i]=='O'&& vis[0][i]==false){
            dfs(0,i,grid,vis);
        }

        if(grid[row-1][i]=='O'&& vis[row-1][i]==false){
            dfs(row-1,i,grid,vis);
        }
    }
    for(int i=1;i<row;i++){
        if(grid[i][0]=='O'&& vis[i][0]==false){
            dfs(i,0,grid,vis);
        }
        if(grid[i][col-1]=='O'&& vis[i][col-1]==false){
            dfs(i,col-1,grid,vis);
        }
    }
    
    
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]=='O' && vis[i][j]==false){
                grid[i][j]='X';
            }
        }
    }
        return grid;
    }
}