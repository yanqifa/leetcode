/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        corePathSum(root, sum, list, ret);
        return ret;
    }

    public void corePathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> ret) {
        if(root == null)return;
        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            ret.add(newList);
        }
        corePathSum(root.left, sum - root.val, newList, ret);
        corePathSum(root.right, sum - root.val, newList, ret);
    }
}