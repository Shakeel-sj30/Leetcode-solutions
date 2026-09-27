class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        ListNode tail = head;
        int size = 1;

        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k = k % size;

        if (k == 0) {
            return head;
        }

        int j = size - k;

        for (int i = 0; i < j - 1; i++) {
            temp = temp.next;
        }

        tail.next = head;

        head = temp.next;

        temp.next = null;

        return head;
    }
}