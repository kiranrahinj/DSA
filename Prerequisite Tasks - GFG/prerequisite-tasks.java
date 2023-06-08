//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n, int[][] p)
    {
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
    
        
        for(int a[]:p){
            graph[a[0]].add(a[1]);
        }
        
        int indegree[]=new int[n];
        
        for(int i=0;i<n;i++){
            for(int a:graph[i]){
                indegree[a]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(q.size()>0){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                int node=q.remove();
                cnt++;
                for(int nbr:graph[node]){
                    indegree[nbr]--;
                    if(indegree[nbr]==0)q.add(nbr);
                }
            }
        }
        if(cnt==n)return true;
        return false;
    }
    
}