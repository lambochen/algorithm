package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        SwapNodesInPairs handler = new SwapNodesInPairs();
        handler.swapPairs(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
        );
    }

    // 别只进行指针操作，编码复杂度很高。转而采用一次取两个 node，然后添加到新节点的方式
//    public ListNode swapPairs(ListNode head) {
//        if (null == head || null == head.next) {
//            return head;
//        }
//
//        ListNode newHead = null;
//        ListNode newTail = null;
//        while (null != head) {
//            ListNode first = head;
//            ListNode second = head.next;
//            head = null == second ? null : second.next;
//
//            if (null == second) {
//                if (null == newTail) {
//                    newHead = newTail = first;
//                    newHead.next = null;
//                } else {
//                    newTail.next = first;
//                    newTail = first;
//                }
//                newTail.next = null;
//                break;
//            }
//
//            second.next = first;
//            first.next = null;
//            if (null == newHead) {
//                newHead = second;
//                newTail = first;
//                continue;
//            }
//            newTail.next = second;
//            newTail = first;
//        }
//
//        return newHead;
//    }

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode newHead = null;
        ListNode newTail = null;
        while (null != head) {
            ListNode first = head;
            ListNode second = head.next;
            head = null == second ? null : second.next;

            if (null != second) {
                if (null == newHead) {
                    newHead = newTail = second;
                    newHead.next = null;
                } else {
                    newTail.next = second;
                    newTail = second;
                }
            }

            if (null == newHead) {
                newHead = newTail = first;
                newHead.next = null;
            } else {
                newTail.next = first;
                newTail = first;
            }

            newTail.next = null;
        }

        return newHead;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
