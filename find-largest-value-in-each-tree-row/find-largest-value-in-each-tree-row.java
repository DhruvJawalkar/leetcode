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
    
    public List<Integer> largestValues(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int depth = 0;
        dfs(root, depth, map);
        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<map.size(); i++)
            result.add(map.get(i));
        
        return result;
    }
    
    private void dfs(TreeNode node, int depth, HashMap<Integer, Integer> map){
        if(node==null) return;
        
        if(!map.containsKey(depth))
            map.put(depth, node.val);
        else
            map.put(depth, Math.max(node.val, map.get(depth))); 
        
        dfs(node.left, depth+1, map);
        dfs(node.right, depth+1, map);
    }
}