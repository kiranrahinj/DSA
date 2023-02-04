//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String island;
    char val[]={'t','b','r','l'};
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    private void dfs(int r,int c,int grid[][],boolean vis[][]){
        int row=grid.length;
        int col=grid[0].length;
        vis[r][c]=true;
        
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            
            if(nr>=row ||nr<0 ||nc>=col||nc<0)continue;
            
            if(!vis[nr][nc] && grid[nr][nc]==1){
                island+=val[i];
                dfs(nr,nc,grid,vis);
            }
        }
        island+='x';
    }
    
    int countDistinctIslands(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        
        Map<String,Integer>hm=new HashMap<>();
        boolean vis[][]=new boolean[row][col];
       
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               if(!vis[i][j]&&grid[i][j]==1){
                   island="";
                   dfs(i,j,grid,vis);
                   hm.put(island,hm.getOrDefault(island,0)+1);
               } 
            }
        }
        return hm.size();
    }
}
