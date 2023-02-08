//{ Driver Code Starts
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
    	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    long ans=g.verticallyDownBST(root,target);
        	    out.println(ans);
                t--;
            
        }
        out.close();
    }
  
}




// } Driver Code Ends


//User function Template for Java
 class Pair{
        Node node;
        int scale;
        
        Pair(Node node,int scale){
            this.node=node;
            this.scale=scale;
        }
 }
class Solution
{
    Node node;
    boolean find(Node root,int target){
        if(root==null)return false;
        if(root.data==target){
            node=root;
            return true;
        }
        if(root.data>target)return find(root.left,target);
        return find(root.right,target);
    }
    
     long getSum(Node root,int scale1,int target){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
       
       HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
       
       while(q.size()>0){
           int size=q.size();
           for(int i=0;i<size;i++){
               Pair p=q.remove();
               root=p.node;
               int scale=p.scale;
               
               if(hm.containsKey(scale))hm.get(scale).add(root.data);
               else{
                     ArrayList<Integer>al=new ArrayList<>();
                     al.add(root.data);
                     hm.put(scale,al);
               }
               
               if(root.left!=null){
                   q.add(new Pair(root.left,scale-1));
               }
               if(root.right!=null){
                   q.add(new Pair(root.right,scale+1));
               }
           }
       }
       long ans=0;
       if(hm.containsKey(scale1)){
           ArrayList<Integer>al=hm.get(scale1);
           for(int k:al)ans+=k;
       }
       ans=ans-target;
       return ans;
    }
    
    long verticallyDownBST(Node root,int target)
    {
       if(!find(root,target))return -1;
       long ans=getSum(node,0,target);
       return ans;
    }
}