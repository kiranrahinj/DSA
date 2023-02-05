//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private static void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        int row=adj.size(); 
        vis[src]=true;
        
        for(int i=0;i<row;i++){
            if(adj.get(src).get(i)==1 && vis[i]==false){
                dfs(i,adj,vis);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int vertices) {
      
      boolean vis[]=new boolean[vertices];
      
      int row=adj.size();
      int col=adj.get(0).size();
      int ans=0;
      
      for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
              if(vis[i]==false){
                  dfs(i,adj,vis);
                  ans++;
              }
          }
      }
      return ans;
    }
};