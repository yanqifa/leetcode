105. Construct Binary Tree from Preorder and Inorder Traversal

https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
前序数组一个元素为root，找到中序数据的root元素，左边为左子树，右边为右子树，根据左子树的size即可知道前序数组中的左子树范围，之后递归即可
110. Balanced Binary Tree

 https://leetcode-cn.com/problems/balanced-binary-tree/
使用maxDetpth，用-1返回不平衡的
 116. Populating Next Right Pointers in Each Node

https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
利用next指针找到相邻子树！
120. Triangle

https://leetcode.com/problems/triangle/
自底向上取最小
121. Best Time to Buy and Sell Stock

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
保存最小的寻找最大的
122. Best Time to Buy and Sell Stock II

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
累加所有递增量
124. Binary Tree Maximum Path Sum

https://leetcode.com/problems/binary-tree-maximum-path-sum/
巧用0去除对负数的判断
128. Longest Consecutive Sequence

https://leetcode-cn.com/problems/longest-consecutive-sequence/
从hash中搜索
131. Palindrome Partitioning

https://leetcode.com/problems/palindrome-partitioning/
如果要求输出所有可能的解，往往都是要用深度优先搜索。如果是要求找出最优的解，或者解的数量，往往可以使用动态规划。
copy前面的数组
 134. Gas Station
https://leetcode.com/problems/gas-station/
记录两个位置start & end，start在数组尾部，end在首部，有油end推进，没油start往前找
135. Candy

https://leetcode-cn.com/problems/candy/
从前从后遍历两遍，已经大于的忽略
139. Word Break

https://leetcode.com/problems/word-break/
动态规划都可以用递归写出
用数组记录可分割点，两层循环，外循环为字串，内循环在字串中寻找可分割点，返回数组最后一位
143. Reorder List

https://leetcode.com/problems/reorder-list/
反转链表（烂熟于心中）记录pre指针和cur指针！注意判空！
146. LRU Cache

https://leetcode.com/problems/lru-cache/
1、双向链表（可以O(1)插头除尾） + hashMap（O(1)查询）
2、双向链表要判断头尾的加dummyHead & dummyTail
3、插入注意key相同的
147. Insertion Sort List

https://leetcode-cn.com/problems/insertion-sort-list/
链表前插入，可增加一个DumyNode简洁代码，链表的插入有前插和后插
148. Sort List

 https://leetcode-cn.com/problems/sort-list/
归并排序的思想
技巧：找到中间节点，快慢指针 
149. Max Points on a Line

https://leetcode.com/problems/max-points-on-a-line/
在这个点上斜率相同的线有多少个就是点的个数，注意没有斜率的情况
经验：活用map，set等hash工具！