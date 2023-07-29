package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 *
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode idx = head.next;
        head.next = null;
        while (idx != null) {
            ListNode tmp = idx;
            idx = idx.next;
            tmp.next = head;
            head = tmp;
        }

        return head;
    }



    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
