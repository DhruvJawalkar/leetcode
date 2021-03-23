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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //base case
        if(root==null)
            return new ArrayList<List<Integer>>();
        
        //init hashmap, minCol, maxCol
        HashMap<Integer, ArrayList<Integer>> columnwiseMap = new HashMap<>();
        int minCol = 0, maxCol = 0;
        
        //init level order traversal
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));
        
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> nodePair = queue.poll();
            TreeNode node = nodePair.getKey();
            Integer col = nodePair.getValue();
            
            if(!columnwiseMap.containsKey(col))
                columnwiseMap.put(col, new ArrayList<Integer>());
            
            columnwiseMap.get(col).add(node.val);
            
            if(node.left!=null){
                queue.offer(new Pair<TreeNode, Integer>(node.left, col-1));
                minCol = Math.min(minCol, col-1);
            }
            
            if(node.right!=null){
                queue.offer(new Pair<TreeNode, Integer>(node.right, col+1));
                maxCol = Math.max(maxCol, col+1);
            }
                
        }
        
        //form output
        ArrayList<List<Integer>> output = new ArrayList<List<Integer>>();
        
        for(int col=minCol; col<=maxCol; col++){
            output.add(columnwiseMap.get(col));
        }
        
        //return output
        return output;
    }
}