/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode curr = head;
        while(curr.next != null){
            if(curr.val == curr.next.val){
                ListNode sucks = curr.next;
                while(sucks != null && curr.val == sucks.val){
                    sucks = sucks.next;
                }
                curr.next = sucks;
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }
}