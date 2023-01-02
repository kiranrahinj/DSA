 *************************************Tree*******************************************
 
 --------Path to Node

 public boolean path(TreeNode root,TreeNode b,ArrayList<TreeNode>ans){
		if(root==null)return false;
		if(root==b){
		    ans.add(root);
		   return true;    }
		boolean res=path(root.left,b,ans)||path(root.right,b,ans);
		if(res==true){
		   ans.add(root);    }
		return res;      }
-----------------------------------------------------------------------------------------------------------
public boolean path(Node root,int b,ArrayList<Integer>ans){
		if(root==null)return false;

		 ans.add(root.data);
		if(root.data==b)return true;

		if(path(root.left,b,ans) || path(root.right,b,ans) ){
			return true;
		}
		ans.remove(ans.size()-1);
		return false;
	}

------Diameter of tree

    class Solution {
           //[]{height,diameter}
    
         int []solve(TreeNode root){
            if(root==null)return new int[]{-1,0};
    
            int ldh[]=solve(root.left);
            int rdh[]=solve(root.right);
           
            int ans[]=new int[2];
            ans[0]=Math.max(ldh[0],rdh[0])+1;
    
            int md=ldh[0]+rdh[0]+2;
            ans[1]=Math.max(md,Math.max(ldh[1],rdh[1]));
           return ans; 
        }
    
        public int diameterOfBinaryTree(TreeNode root) {
            
           int ans[]=solve(root);
    
           return ans[1];
        }
    }
    …………………………………………………………………………………………………………………….
    class Solution {
        int height(TreeNode root){
            if(root==null)return -1;
    
            int rh=height(root.left);
            int lh=height(root.right);
            
           return Math.max(rh,lh)+1;
        }
    
        public int diameterOfBinaryTree(TreeNode root) {
            
            if(root==null)return 0;
    
            int ld=diameterOfBinaryTree(root.left);
            int rd=diameterOfBinaryTree(root.right);
              //my diameter
            int md=height(root.left)+height(root.right)+2;
            return Math.max(md,Math.max(ld,rd));
        }
    }
    
