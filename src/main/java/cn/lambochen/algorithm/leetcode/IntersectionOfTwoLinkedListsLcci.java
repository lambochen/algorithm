package cn.lambochen.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class IntersectionOfTwoLinkedListsLcci {


    // 集合存储法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }

        Set<ListNode> aSet = new HashSet<>();
        while (null != headA) {
            aSet.add(headA);
            headA = headA.next;
        }

        while (null != headB) {
            if (aSet.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    // 双指针法
    public ListNode getIntersectionNode_(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }

        ListNode a = headA, b = headB;
        boolean flaga = false, flagb = false;
        while (true) {
            if (a == b) {
                return a;
            }

            if (null == a) {
                // do nothing
            } else if (null == a.next && !flaga) {
                a = headB;
                flaga = true;
            } else {
                a = a.next;
            }
            if (null == b) {
                // do nothing
            } else if (null == b.next && !flagb) {
                b = headA;
                flagb = true;
            } else {
                b = b.next;
            }
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
