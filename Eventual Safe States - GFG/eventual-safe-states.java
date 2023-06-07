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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private boolean dfs(int src,List<List<Integer>> adj,boolean vis[],boolean vis_path[],boolean safe[]){
        vis[src]=true;
        vis_path[src]=true;
        safe[src]=false;
        
        for(int nbr:adj.get(src)){
            if(!vis[nbr]){
                if(dfs(nbr,adj,vis,vis_path,safe)==false)return false;
            }
            else if(vis[nbr]&&vis_path[nbr])return false;
        }
        safe[src]=true;
        vis_path[src]=false;
        return true;
    }
    
    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        List<Integer>ans=new ArrayList<>();
        
        boolean vis[]=new boolean[v];
        boolean vis_path[]=new boolean[v];
        boolean safe[]=new boolean[v];
        
        for(int i=0;i<v;i++){
            dfs(i,adj,vis,vis_path,safe);
        }
        
        for(int i=0;i<v;i++){
            if(safe[i])ans.add(i);
        }
        return ans;
    }
}
