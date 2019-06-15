package Day1;

import java.util.List;
import java.util.PriorityQueue;

public class LC23MergekSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     *
     * time = O(nlogk)
     * space = O(n)
     */

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return new ListNode(-1);
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            if (node.next != null) {
                pq.add(node.next);
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
