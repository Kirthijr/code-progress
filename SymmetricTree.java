// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
  
  class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return isSameTree(root.left, root.right);
        }
    }

    public boolean isSameTree(TreeNode a, TreeNode b){
        if (a == null && b == null)
        return true;
        else if ((a == null && b != null) || (a != null && b == null)) return false;
        else if(a.val == b.val)
        return isSameTree(a.left, b.right) && isSameTree(a.right, b.left);
        else
            return false;
    }
}
