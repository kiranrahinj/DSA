//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    private boolean dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean path[]){
        path[src]=vis[src]=true;
        
        for(var nbr :adj.get(src)){
            if(!vis[nbr]){
                boolean check=dfs(nbr,adj,vis,path);
                if(check)return true;
            }
            else if(vis[nbr]&& path[nbr])return true;
        }
        path[src]=false;
        return false;
    }
    
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[n];
        boolean path[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                boolean check=dfs(i,adj,vis,path);
                if(check)return true;
            }
        }
        return false;
    }
}