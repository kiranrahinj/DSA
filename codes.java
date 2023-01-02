 Tree
 Path to Node

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
