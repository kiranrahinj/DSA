//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] BFS(int src,ArrayList<Integer>[] graph) {
	
		int[] ans=new int[graph.length];
		Queue<Integer>q=new LinkedList<>();
		boolean vis[]=new boolean[graph.length];
		Arrays.fill(ans,-1);

		q.add(src);
		vis[src]=true;
		int level=0;
		
		while(q.size()>0){
			int size=q.size();

			for(int i=0;i<size;i++){
				int temp=q.remove();
				ans[temp]=level;
				for(int nbr:graph[temp]){
					if(vis[nbr]==false) {
						q.add(nbr);
						vis[nbr]=true;
					}
				}
			}
			level++;
		}
		return ans;
    }
    public int[] shortestPath(int[][] edges,int vertices,int m ,int src) {
        ArrayList<Integer>[] graph=new ArrayList[vertices];	
	    
		for(int i=0;i<vertices;i++){
		    graph[i]=new ArrayList<>();
		}
		
		for(int x[]:edges){
		    int u=x[0];
		    int v=x[1];
		    
		    graph[u].add(v);
		    graph[v].add(u);
		    
		}
		return BFS(src,graph);
    }
}