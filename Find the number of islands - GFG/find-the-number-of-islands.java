//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
   
    int dr[]={0,-1,0,1,-1,1,1,-1};
    int dc[]={-1,0,1,0,1,1,-1,-1};

    void dfs(char grid[][],int r,int c,boolean vis[][]){
       vis[r][c]=true;
       int n=grid.length;
       int m=grid[0].length;

       for(int i=0;i<8;i++){
           int nr=r+dr[i];
           int nc=c+dc[i];
           
           if(nr>=n ||nc>=m||nc<0||nr<0)continue;

           if(vis[nr][nc]==false &&grid[nr][nc]=='1'){
               dfs(grid,nr,nc,vis);
           }
       }
    }

    public int numIslands(char[][] grid) {
     int n=grid.length;
        int m=grid[0].length;

        boolean vis[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }
}