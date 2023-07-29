package cn.lambochen.algorithm.leetcode.primaryalgorithm.list;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/10/6 19:56
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 **/
public class IsPalindrome {

    /**
     * 解题思路：
     * 1. 快慢指针遍历找中点
     * 2. 将链表后半部分进行反转
     * 3. 两半部分进行逐一 check
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        // 判断列表个数是否奇数
        boolean flag = false;
        // 1. 找中点
        while (fast != null) {
            if (fast.next == null) {
                flag = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2. 反转后半部分
        ListNode headBack = slow;
        slow = slow.next;
        headBack.next = null;
        while (slow != null) {
            if (slow.next != null) {
                ListNode tmp = slow;
                slow = slow.next;
                tmp.next = headBack;
                headBack = tmp;
            } else {
                slow.next = headBack;
                headBack = slow;
                break;
            }
        }

        // 逐一比较
        while (headBack != null) {
            // 如果是奇数，则去掉 head
            if (flag && headBack.next == null) {
                break;
            }
            if (head.val != headBack.val) {
                return false;
            }
            head = head.next;
            headBack = headBack.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome handler = new IsPalindrome();

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);
        System.out.println(handler.isPalindrome(head));

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
