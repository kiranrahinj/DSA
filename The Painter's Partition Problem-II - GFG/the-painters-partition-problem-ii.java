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
    // private static boolean validate(int []arr,int k,int mid){
    //     int painter=1;
    //     int sum=0;
    //     for(int i=0;i<arr.length;i++){
           
    //       if(arr[i]>mid)return false;
    //       if(sum+arr[i]>mid){
    //           painter++;
    //           sum=arr[i];
    //       }
    //       else sum+=arr[i];
    //     }
    //     return painter<=k;
    // } 
    // static long minTime(int[] arr,int n,int k){
    //     int mn=0,sum=0;
        
    //     for(int i:arr){
    //         mn=Math.max(mn,i);
    //         sum+=i;
    //     }
    //     long ans=0;
    //     int start=mn,end=sum;
        
    //     while(start<=end){
    //         int mid=start+(end-start)/2;
            
    //         if(validate(arr,k,mid)){
    //             end=mid-1;
    //             ans=mid;
    //         }
    //         else {
    //             start=mid+1;
    //         }
    //     }
    //     return ans;
    // }
    static long minTime(int[] arr,int n,int k){
        if(n<=1){
            return arr[0];
        }
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
           
          if(arr[i]>mid)return false;
          if(sum+arr[i]>mid){
              painter++;
              sum=arr[i];
          }
          else sum+=arr[i];
        }
        return painter<=k;
    }

}


