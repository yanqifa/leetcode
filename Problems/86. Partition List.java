/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode tempNode1 = dummyHead1;
        ListNode tempNode2 = dummyHead2;
        ListNode tempNode = head;
        while(tempNode != null){
            if(tempNode.val < x){
                tempNode1.next = tempNode;
                tempNode1 = tempNode1.next;
            }else{
                tempNode2.next = tempNode;
                tempNode2 = tempNode2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode1.next = dummyHead2.next;
        tempNode2.next = null;
        return dummyHead1.next;
    }
}
