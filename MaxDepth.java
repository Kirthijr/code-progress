// Given the root of a binary tree, return its maximum depth.

class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if(root == null){
            return 0;
        }else{
            int left = 1+ maxDepth(root.left);
            int right = 1+ maxDepth(root.right);
            max =  Math.max(left, right);
        }
        return max;

    }
}
