//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int n, int m, int x, int y){
		int a[][]=new int[n][m];
// 		Arrays.fill(a,0);
		a[x-1][y-1]=1;
		boolean visited[][]=new boolean[n][m];
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[]{x-1,y-1});
		visited[x-1][y-1]=true;
		int level=0;
		
		 int dr[]={0,-1,0,1};
         int dc[]={-1,0,1,0};
         
		while(q.size()>0){
		    int size=q.size();
		    
		    for(int i=0;i<size;i++){
		        int temp[]=q.remove();
		        int r=temp[0];
		        int c=temp[1];
		        a[r][c]=1;
		        for(int j = 0; j < 4; j++){
                 int nr = r + dr[j];
                 int nc = c + dc[j];
                 if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if(visited[nr][nc] == false && a[nr][nc] == 0) {
                      q.add(new int[]{nr, nc});
                      visited[nr][nc] = true;
                    }
                }
		    }
		    level++;
		}
	  return level-1;	
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends