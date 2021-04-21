/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode node, Integer lowerBound, Integer upperBound){
        if(node==null)
            return true;
        
        if((upperBound!=null && node.val>=upperBound) || (lowerBound!=null && node.val<=lowerBound))
            return false;
        
        return helper(node.left, lowerBound, node.val) && helper(node.right, node.val, upperBound);
    }
}