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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //base case
        if(root==null) 
            return new ArrayList<List<Integer>>();

        List<List<Integer>> paths = new ArrayList<List<Integer>>();
    
        int curSum = 0;
        List<Integer> curPath = new ArrayList<Integer>();

        dfs(root, curSum, curPath, paths, sum);

        return paths;
    }
    
    private void dfs(TreeNode root, int curSum, List<Integer> curPath, List<List<Integer>> paths, int sum){
        if(root==null)
            return;
        
        curSum += root.val;
        curPath.add(root.val);

        if(root.left==null && root.right==null){
            if(curSum==sum)
                paths.add(new ArrayList<Integer>(curPath));
            
            curPath.remove(curPath.size()-1);
            return;
        }
        
        dfs(root.left, curSum, curPath, paths, sum);
        dfs(root.right, curSum, curPath, paths, sum);

        curPath.remove(curPath.size()-1);
    }
}