package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 *
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList handler = new RemoveNthNodeFromEndOfList();
//        handler.removeNthFromEnd(
//                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
//                2
//        );
        handler.removeNthFromEnd(new ListNode(1), 1);
    }

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }

        ListNode quick = head, slow = head;
        while (n-- > 0) {
            quick = quick.next;
        }
        // 1,2,3
        if (null == quick) {
            return head.next;
        }

        while (null != quick.next) {
            quick = quick.next;
            slow = slow.next;
        }

        if (null == slow.next) {
            slow.next = null;
        } else {
            slow.next = slow.next.next;
        }

        return head;
    }


    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
