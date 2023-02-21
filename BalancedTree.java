// Given a binary tree, determine if it is 
// height-balanced
// .
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        else if (Math.abs(height(root.left) - height(root.right)) >1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight,rheight)+1;
    }
}
