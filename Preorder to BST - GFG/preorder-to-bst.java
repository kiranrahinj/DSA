//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


class GFG {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = post_order(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
// } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.
static int idx;
	private static Node helper(int[] pre,int n,int mn,int mx){
		if(idx>=n || pre[idx]>mx ||pre[idx]<mn)return null;
		Node root=new Node(pre[idx++]);
		root.left=helper(pre,n,mn,root.data);
		root.right=helper(pre,n,root.data,mx);
		return root;
	}
public static Node post_order(int pre[], int n) 
{
   idx=0;
 return helper(pre,n,Integer.MIN_VALUE,Integer.MAX_VALUE);
} 

//{ Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}
// } Driver Code Ends