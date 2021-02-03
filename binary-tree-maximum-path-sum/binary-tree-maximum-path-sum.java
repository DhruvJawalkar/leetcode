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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        
        helper(root);

        return max;            
    }
    
    private int helper(TreeNode node){
        if(node==null)
            return 0;

        int maxFromLeft = Math.max(helper(node.left), 0);
        int maxFromRight = Math.max(helper(node.right), 0);  
        int maxValFromCurrentNode = node.val + Math.max(maxFromLeft, maxFromRight);

        max = Math.max(max, node.val + maxFromLeft + maxFromRight);

        return maxValFromCurrentNode;    
    }
}