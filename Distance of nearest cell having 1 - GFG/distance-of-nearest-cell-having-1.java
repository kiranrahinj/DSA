//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{

    private int[] dr = new int[]{-1, 0, 1, 0};
    private int[] dc = new int[]{0, 1, 0, -1};
    
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
       int m=grid[0].length;

       boolean vis[][]=new boolean[n][m];
       Queue<int[]>q=new LinkedList<>();

       for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==1){
                  vis[i][j]=true;
                  q.add(new int[]{i,j});
              }
          }
       }

        int level=0;

        while(q.size()>0){
            int size=q.size();       
            for(int j=0;j<size;j++){
                int temp[]=q.remove();
                int r=temp[0];
                int c=temp[1];
                grid[r][c]=level;
                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];

                    if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if(vis[nr][nc] == false) {
                      q.add(new int[]{nr, nc});
                      vis[nr][nc] = true;
                    }

                }
            }
            level++;
        }
        return grid;
    }
}