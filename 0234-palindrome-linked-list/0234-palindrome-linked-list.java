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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head ;
        while(fast!=null && fast.next!=null){
            fast =fast.next.next;
            slow= slow.next; 
        }
        ListNode secondhalf = reverse(slow);
        ListNode  firsthalf = head;
        while(secondhalf!=null){
            if(secondhalf.val!=firsthalf.val){
                return false;
            }
            secondhalf= secondhalf.next;
            firsthalf=firsthalf.next;

        }
        return true;
        
    }
    private  ListNode reverse(ListNode head){
        ListNode curr= head;
        ListNode prev = null;
        while(curr!= null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr= next;
        }
        return prev;
    }
}