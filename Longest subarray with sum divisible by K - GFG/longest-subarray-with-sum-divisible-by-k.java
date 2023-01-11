//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int nums[], int n, int k)
    {
        Map<Integer,Integer>hm=new HashMap<>();
        hm.put(0,-1);
        int count=Integer.MIN_VALUE,sum=0;

        for(int i=0;i<nums.length;i++){
                 // we cal sum
                sum+=nums[i];
                // calculate rem
                int rem=sum%k;

               if(rem<0) rem=rem+k;
                // we r checking us that key is presetn in hm or not
                if(hm.containsKey(rem)){
                    count=Math.max(count,i-hm.get(rem));
                }
                else{
                  hm.put(rem,i);
                }
        }
    
    return count==Integer.MIN_VALUE ? 0:count;
       
    }
 
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends