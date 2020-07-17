import java.util.*;
/* 
* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
       coreInorderTraversal(root, ans);
       return ans;
    }

    public void coreInorderTraversal(TreeNode root, List<Integer> ans){
        if(root == null)return;
        coreInorderTraversal(root.left, ans);
        ans.add(root.val);
        coreInorderTraversal(root.right, ans);
    }
}