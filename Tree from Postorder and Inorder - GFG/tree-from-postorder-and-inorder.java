//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
       Map<Integer,Integer>hm=new HashMap<>();
       int i=0;
       for(int k:in){
           hm.put(k,i++);
       }
      return solve(in,0,in.length-1,post,0,post.length-1,hm);
    }
    
    Node solve(int in[],int is,int ie,int pos[],int ps,int pe, Map<Integer,Integer>hm){
        
        if(is>ie && ps>pe)return null;
        
        Node root=new Node(pos[pe]);
        
        int indRoot=hm.get(pos[pe]);
        int size=indRoot-is;
        
        root.left=solve(in,is,indRoot-1,pos,ps,ps+size-1,hm);
        root.right=solve(in,indRoot+1,ie,pos,ps+size,pe-1,hm);
        return root;
    }
}
