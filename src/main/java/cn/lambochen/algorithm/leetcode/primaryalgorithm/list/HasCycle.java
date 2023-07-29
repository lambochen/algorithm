package cn.lambochen.algorithm.leetcode.primaryalgorithm.list;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/10/9 23:40
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 **/
public class HasCycle {

    /**
     * 环形链表： 快慢指针，只要指针能够相遇，说明有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null) {
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            } else {
                break;
            }
        }

        return false;
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
