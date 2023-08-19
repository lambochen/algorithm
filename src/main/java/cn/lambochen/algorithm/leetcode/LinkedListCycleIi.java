package cn.lambochen.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lambochen
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleIi {

    // 引入集合存储
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        while (null != head) {
            if (set.contains(head)) {
                return head;
            }

            set.add(head);
            head = head.next;
        }

        return null;
    }

    // 双指针法
    public ListNode detectCycle_(ListNode head) {
        if (null == head) {
            return null;
        }

        // 快慢指针
        ListNode slow = head, quick = head;
        // 标记是否相遇过
        boolean flag = false;
        while (null != slow && null != quick) {
            if (slow == quick) {
                if (!flag) {
                    // 两指针第一次相遇
                    flag = true;

                    quick = head;
                } else {
                    // 第二次相遇
                    return slow;
                }
            }

            quick = quick.next;
            if (null == quick) {
                break;
            }
            if (!flag) {
                // 未相遇前，走两步
                quick = quick.next;
            }

            slow = slow.next;
        }

        return null;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
