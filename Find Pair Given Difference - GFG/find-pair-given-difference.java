//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
      
        HashMap<Integer,Integer>hm=new HashMap<>();
        // hm.put(0,1);
        for(int i:arr)hm.put(i,hm.getOrDefault(i,0)+1);
        if(n==0){
            for(int k:hm.keySet()){
                if(hm.get(k)>=2)return true;
            }
        }
        else{
        for(int i:arr){
            if(hm.containsKey(Math.abs(n-i)))return true;
        }
        }
       
      return false;  
    }
}