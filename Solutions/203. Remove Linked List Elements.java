/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode emptyNode = new ListNode(0);
        emptyNode.next = head;
        ListNode temp = emptyNode;
        while(temp.next != null){
            if(temp.next.val == val)temp.next = temp.next.next;
            else temp = temp.next;
        }
        return emptyNode.next;
    }
}