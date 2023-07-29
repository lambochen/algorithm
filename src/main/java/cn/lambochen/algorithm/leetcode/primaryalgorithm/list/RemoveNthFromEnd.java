package cn.lambochen.algorithm.leetcode.primaryalgorithm.list;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/22 0:03
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 **/
public class RemoveNthFromEnd {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     * <p>
     * 删除链表的倒数第N个节点
     * <p>
     * 解题思路：
     * <p>
     * 采用双指针法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, second = head;
        while (n-- > 0 && first != null) {
            first = first.next;
        }

        if (n > 0 || first == null) {
            // 说明删除第一个节点
            if (head.next == null) {
                return null;
            }
            head.val = head.next.val;
            head.next = head.next.next;
            return head;
        }

        // 双指针移动，寻找待删除节点。。。 此处做了优化，删除节点为 second.next
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // 删除节点
        if (second.next.next == null) {
            second.next = null;
        } else {
            second.next.val = second.next.next.val;
            second.next.next = second.next.next.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        RemoveNthFromEnd handler = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        tmp.next = new ListNode(2);
//        tmp = tmp.next;
//        tmp.next = new ListNode(3);
//        tmp = tmp.next;
//        tmp.next = new ListNode(4);
//        tmp = tmp.next;
//        tmp.next = new ListNode(5);
//
//        head = handler.removeNthFromEnd(head, 2);
//
//        System.out.println(head.val);
//        System.out.println(head.next.val);
//        System.out.println(head.next.next.val);
//        System.out.println(head.next.next.next.val);

        head = handler.removeNthFromEnd(head, 1);
    }
}
