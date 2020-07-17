/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //头插法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newEmptyNode = new ListNode(0);
        ListNode newTempNode = newEmptyNode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                newTempNode.next = l1;
                l1 = l1.next;
            }else{
                newTempNode.next = l2;
                l2 = l2.next;
            }
            newTempNode = newTempNode.next;
        }
        if(l1 != null){
            newTempNode.next = l1;
        }else{
            newTempNode.next = l2;
        }
        return newEmptyNode.next;
    }
}