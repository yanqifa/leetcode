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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return coreBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode coreBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)return null;
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == val){
                node.left = coreBuildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                node.right = coreBuildTree(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
            }
        }
        return node;
    }
}
  