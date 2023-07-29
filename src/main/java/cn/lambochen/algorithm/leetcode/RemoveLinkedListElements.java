package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 *
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {


    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        }

        while (head.val == val) {
            head = head.next;
            if (null == head) {
                return null;
            }
        }

        ListNode tmp = head;
        while (null != tmp.next) {
            if(tmp.next.val == val) {
                if (null == tmp.next.next) {
                    tmp.next = null;
                    break;
                } else {
                    tmp.next = tmp.next.next;
                }
            } else {
                tmp = tmp.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        RemoveLinkedListElements handler = new RemoveLinkedListElements();

        ListNode head = new ListNode(
                7,
                new ListNode(
                        7,
                        new ListNode(
                                7,
                                new ListNode(
                                        7,
                                        new ListNode(7)
                                )
                        )
                )
        );

        handler.removeElements(head, 7);
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
