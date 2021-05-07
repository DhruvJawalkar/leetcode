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
 
 TC - O(n)
 SC - O(n) worst case, O(log n) avg case for recursion stack space
 
 Input: root = [-10,9,20,null,null,15,7]
 maxOverall = 42
 */
class Solution {
    int maxOverall = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        
        return maxOverall;
    }
    
    private int helper(TreeNode node){
        if(node==null)
            return 0;
        
        int maxFromLeft = Math.max(helper(node.left), 0);
        int maxFromRight = Math.max(helper(node.right), 0);
        
        maxOverall =  Math.max(maxOverall, node.val + maxFromLeft + maxFromRight);
        
        return node.val + Math.max(maxFromLeft, maxFromRight);
    }
}