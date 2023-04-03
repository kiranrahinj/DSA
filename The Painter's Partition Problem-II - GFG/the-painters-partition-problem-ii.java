//{ Driver Code Starts
//Initial Template for Java

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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
   
    static long minTime(int[] arr,int n,int k){
      
        long sum=0;
        for(int i=0;i<n;i++)
         sum+=arr[i];
        long end=sum;
        long start=0;
        long ans=-1;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(isPossibleSolution(arr,n,k,mid)){
               ans=mid;
               end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    private static boolean isPossibleSolution(int[] arr,int n,int k,long mid){
        
        int painter=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
           sum+=arr[i];
          if(arr[i]>mid)return false;
          if(sum>mid){
              painter++;
              sum=arr[i];
          }
          
        }
        return painter<=k;
    }

}


