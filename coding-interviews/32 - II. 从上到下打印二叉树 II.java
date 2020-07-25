import java.util.*;
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
    public List<List<Integer>> levelOrder(final TreeNode pRoot) {
        final List<List<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        final LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            final ArrayList<TreeNode> lineNode = new ArrayList<>();
            final ArrayList<Integer> lineVal = new ArrayList<>();
            do {
                final TreeNode node = queue.pop();
                lineNode.add(node);
                lineVal.add(node.val);
            } while (!queue.isEmpty());
            for (final TreeNode node : lineNode) {
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(lineVal);   
        }
        return ans;
    }
}