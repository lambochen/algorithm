package cn.lambochen.algorithm.leetcode.primaryalgorithm.list;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/29 23:08
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 **/
public class MergeTwoLists {

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode res = null, tmp = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (tmp == null) {
                    tmp = l1;
                } else {
                    tmp.next = l1;
                    tmp = tmp.next;
                }
                l1 = l1.next;
            } else {
                if (tmp == null) {
                    tmp = l2;
                } else {
                    tmp.next = l2;
                    tmp = tmp.next;
                }
                l2 = l2.next;
            }

            if (res == null) {
                res = tmp;
            }
        }

        tmp.next = l1 == null ? l2 : l1;

        return res;
    }

    public static void main(String[] args) {
        MergeTwoLists handler = new MergeTwoLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        handler.mergeTwoLists(l1, l2);
    }

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


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */