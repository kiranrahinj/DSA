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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class tuple{
    int first ,second,third;
    public tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] src, int[] dest) {
        int row=grid.length;
        int col=grid[0].length;
        int dist[][] =new int[grid.length][grid[0].length];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dist[i][j]=(int)1e9;
            }
        }
        if(src[0]==dest[0]&&src[1]==dest[1])return 0;
        Queue<tuple>q=new LinkedList<>();
        dist[src[0]][src[1]]=0;
        q.add(new tuple(0,src[0],src[1]));
        
        while(q.size()>0){
            int dt=q.peek().first;
            int x=q.peek().second;
            int y=q.peek().third;
            q.remove();
            
            int dr[]={-1,0,0,1};
            int dc[]={ 0,1,-1,0};
            
            for(int i=0;i<4;i++){
                int nr=x+dr[i];
                int nc=y+dc[i];
                
                if(nr<0 ||nr>=row ||nc<0 ||nc>=col)continue;
                
                if(dt+1<dist[nr][nc] && grid[nr][nc]==1){
                    dist[nr][nc]=dt+1;
                    q.add(new tuple(dt+1,nr,nc));
                    if(nr==dest[0] && nc==dest[1])return dist[nr][nc];
                }
            }
        }
        return -1;
    }
}
