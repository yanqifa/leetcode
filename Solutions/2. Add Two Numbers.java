/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode tempNode3 = dummyNode;
        int carry = 0;
        while(tempNode1 != null || tempNode2 != null || carry == 1){

            int val = carry;
            if(tempNode1 != null)val += tempNode1.val;
            if(tempNode2 != null)val += tempNode2.val;
            ListNode newNode = new ListNode(val%10);
            carry = val/10;
            tempNode3.next = newNode; 
            if(tempNode1 != null)tempNode1 = tempNode1.next;
            if(tempNode2 != null)tempNode2 = tempNode2.next;
            tempNode3 = tempNode3.next;
        }

        return dummyNode.next;
    }
}