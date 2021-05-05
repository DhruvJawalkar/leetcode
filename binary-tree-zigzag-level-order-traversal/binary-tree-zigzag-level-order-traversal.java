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
 SC - O(n) worst case, O(log n) avg case
 
 Input: root = [3,9,20,null,null,15,7]
 
 output [[3],[20,9],[15,7]]
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        
        List<List<Integer>> output = new ArrayList<>();
        
        int depth = 0;
        helper(root, output, depth);
        
        return output;
    }
    
    private void helper(TreeNode node, List<List<Integer>> output, int depth){
        if(node==null)
            return;
        
        if(depth==output.size())
            output.add(new LinkedList<Integer>());
        
        if(depth%2==0)
            output.get(depth).add(node.val);
        else
            output.get(depth).add(0, node.val);
        
        helper(node.left, output, depth+1);
        helper(node.right, output, depth+1);
    }
}