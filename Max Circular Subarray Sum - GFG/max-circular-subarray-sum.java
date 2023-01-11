//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int nums[], int n) {
          long total=0,curr=0,curr2=0;
        long maxSum=Integer.MIN_VALUE;
        long minSum=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
        //total sum
        total+=nums[i];

        //int minsum
        curr+=nums[i];
        if(minSum>curr){
            minSum=curr;
        }
        if(curr>0)curr=0;

        //int maxsum
        curr2+=nums[i];
        if(maxSum<curr2){
            maxSum=curr2;
        }
        if(curr2<0)curr2=0;
      }

        if(minSum==total)return (int)maxSum;

        maxSum=Math.max(maxSum,total-minSum);

        return (int)maxSum;
     
    }
    
}

