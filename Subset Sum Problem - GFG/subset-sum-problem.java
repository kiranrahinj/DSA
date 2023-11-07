//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][]=new int[105][(int)1e4];
    
    static int helper(int level,int taken,int arr[],int target,int n){
        //prunning
        if(level>n)return 0;
        
        //base
        if(level==n){
            if(taken==target)return 1;
            else return 0;
        }
        //check
        if(dp[level][taken]!=-1)return dp[level][taken];
        
        //compute
        int ans=0;
        
        //states take or not take
        if(helper(level+1,taken,arr,target,n)==1){ //not take
            ans=1;
        }
        else if(helper(level+1,taken+arr[level],arr,target,n)==1){ //taken
            ans=1;
        }
        
        return dp[level][taken]=ans;
    }

    static Boolean isSubsetSum(int n, int arr[], int sum){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        
        int ans=helper(0,0,arr,sum,n);
        
        return ans==1 ? true:false;
    }
}