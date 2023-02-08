//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
  
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	Solution g = new Solution();
                ArrayList<Integer> res = g.inOrder(root);
                for (int i = 0; i < res.size (); i++)
                    System.out.print (res.get (i) + " ");
                System.out.print("\n");
                t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node 

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Pair{
	int state;
	Node node;

	Pair(Node node,int state){
		this.node=node;
		this.state=state;
	}
}
class Solution
{
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> iterative(Node root){
        ArrayList<Integer>in=new ArrayList<>();
		ArrayList<Integer>pre=new ArrayList<>();
		ArrayList<Integer>post=new ArrayList<>();
		
		Stack<Pair>st=new Stack<>();
		st.push(new Pair(root,1));

		while(st.size()>0){
			Pair p=st.peek();

			if(p.state==1){
				pre.add(p.node.data);
				p.state++;
				if(p.node.left!=null)st.push(new Pair(p.node.left,1));
			}
			else if(p.state==2){
				in.add(p.node.data);
				p.state++;
				if(p.node.right!=null)st.push(new Pair(p.node.right,1));
			}
			else{
				post.add(p.node.data);	
				st.pop();
			}
		}
// 		for(int k:post)System.out.print(k+" ");
        return in;
    }
    ArrayList<Integer> inOrder(Node node)
    {
        // ArrayList<Integer>ans=new ArrayList<>();
        // Stack<Node>st=new Stack<>();
        
        // while(true){
        //     if(node!=null){
        //         st.push(node);
        //         node=node.left;
        //     }
        //     else{
        //         if(st.size()==0)break;
        //         node=st.pop();
        //         ans.add(node.data);
        //         node=node.right;
        //     }
        // }
        // return ans;
        return iterative(node);
    }
    
    
}