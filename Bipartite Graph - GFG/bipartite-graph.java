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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private boolean check(int start,ArrayList<ArrayList<Integer>>adj,int []color){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        
        while(q.size()>0){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                int temp=q.remove();
                
                for(int nbr :adj.get(temp)){
                    if(color[nbr]==-1){
                        color[nbr]=1-color[temp];
                        q.add(nbr);
                    }
                    
                    else if(color[nbr]==color[temp])return false;
                }
            }
        }
        return true;
    }
    
    
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        int color[]=new int[v];
        Arrays.fill(color,-1);
        
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                boolean flag=check(i,adj,color);
                if(flag==false)return false;
            }
        }
        return true;
    }
}