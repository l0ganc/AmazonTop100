package Day4;

public class LC234PalindromeLinkedList {
    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * Example 1:
     *
     * Input: 1->2
     * Output: false
     * Example 2:
     *
     * Input: 1->2->2->1
     * Output: true
     * Follow up:
     * Could you do it in O(n) time and O(1) space?
     */

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public ListNode reverse(ListNode root) {
        if (root == null) {
            return root;
        }

        ListNode prev = null;
        ListNode cur = root;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
