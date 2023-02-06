//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String s) {
        Map<Character,Integer>hm=new HashMap<>();
        for(char ch:s.toCharArray())hm.put(ch,hm.getOrDefault(ch,0)+1);
        String ans="";
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                ans+=s.charAt(i);
                hm.remove(s.charAt(i));
            }
        }
        return ans;
    }
}