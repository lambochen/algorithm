package cn.lambochen.algorithm.leetcode.primaryalgorithm.list;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/28 23:16
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 **/
public class ReverseList {

    /**
     * 反转列表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head.next;
        // 很重要，断开链接
        head.next = null;

        while (first.next != null) {
            ListNode tmp = first.next;
            first.next = head;
            head = first;
            first = tmp;
        }

        first.next = head;
        head = first;
        return head;
    }

    public static void main(String[] args) {
        ReverseList handler = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = handler.reverseList(head);

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
        System.out.println(head.next.next.next.next.val);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
