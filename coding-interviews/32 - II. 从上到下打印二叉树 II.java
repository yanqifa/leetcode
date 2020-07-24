/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode pRoot) {
    List<List<Integer>> ans = new ArrayList<>();
        if(pRoot == null) return ans;
        LinkedList<TreeNode> queue= new LinkedList<>();
        queue.add(pRoot);
        
        while(!queue.isEmpty()){
            ArrayList<TreeNode> lineNode = new ArrayList<>();
            ArrayList<Integer> lineVal = new ArrayList<>();
            do{
                TreeNode node = queue.pop();
                lineNode.add(node);
                lineVal.add(node.val);
            }while(!queue.isEmpty());
            for(TreeNode node : lineNode){
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(lineVal);   
        }
        return ans;
    }
}