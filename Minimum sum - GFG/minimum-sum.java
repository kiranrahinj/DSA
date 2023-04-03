//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        
        Arrays.sort(arr);
        
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();        
        for(int i=0;i<n;i++){
            if(arr[i]==0)continue;
            if(i%2==0){
                s1.append(arr[i]);
            }
            else s2.append(arr[i]);
        }
        StringBuilder ans=new StringBuilder();
        int i=s1.length()-1,j=s2.length()-1;
        int carry=0;
        
        while(i>=0 && j>=0){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(j);
            int sum=(ch1-'0')+(ch2-'0')+carry;
            ans.append(sum%10);
            carry=sum/10;
            i--;j--;
        }
        while(i>=0){
           char ch1=s1.charAt(i);
           int sum=(ch1-'0')+carry;
           ans.append(sum%10);
           carry=sum/10;
           i--;
        }
        while(j>=0){
           char ch1=s2.charAt(j);
           int sum=(ch1-'0')+carry;
           ans.append(sum%10);
           carry=sum/10;
           j--;
        }
        while(carry!=0){
            int sum=carry;
            ans.append(sum%10);
            carry=carry/10;
        }
        ans.reverse();
        return ans.toString();
    }
}
