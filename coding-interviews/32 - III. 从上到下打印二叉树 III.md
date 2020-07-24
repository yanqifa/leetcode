# 32 - III. 从上到下打印二叉树 III

## 地址

https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof

## 描述

请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。


## 思路

主要还是用队列来缓存行node的结果，先pop完再把子节点添加

## 代码

```java
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
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int lineNum = 0;
        while(!queue.isEmpty()){
            lineNum++;
            ArrayList<TreeNode> lineNode = new ArrayList<>();
            do{
                TreeNode node = queue.pop();
                lineNode.add(node);
            }while(!queue.isEmpty());
            for(TreeNode node : lineNode){
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ArrayList<Integer> line = new ArrayList<>();
            if(lineNum % 2 == 1) {
                for(int i = 0; i < lineNode.size(); i++){
                    line.add(lineNode.get(i).val);
                }
            }else{
                for(int i = lineNode.size() - 1; i >= 0 ; i--){
                    line.add(lineNode.get(i).val);
                }
            }
            ans.add(line);
        }
        return ans;
    }
}
```