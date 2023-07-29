package cn.lambochen.algorithm.leetcode;

/**
 * https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj
 *
 * @author lambochen
 */
public class AddTwoNumbers {

    // 大数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = null;
        ListNode tail = null;
        int tmpNum = 0;
        while (null != l1) {
            int tmpRes = tmpNum + l1.val;
            l1 = l1.next;
            if (null != l2) {
                tmpRes += l2.val;
                l2 = l2.next;
            }

            ListNode tmp = new ListNode(tmpRes % 10);
            tmpNum = tmpRes / 10;
            if (null == header) {
                header = tmp;
                tail = tmp;
                continue;
            }
            tail.next = tmp;
            tail = tmp;
        }
        while (null != l2) {
            int tmpRes = tmpNum + l2.val;
            l2 = l2.next;
            ListNode tmp = new ListNode(tmpRes % 10);
            tmpNum = tmpRes / 10;
            tail.next = tmp;
            tail = tmp;
        }
        while (tmpNum > 0) {
            ListNode tmp = new ListNode(tmpNum % 10);
            tmpNum /= 10;
            tail.next = tmp;
            tail = tmp;
        }

        return header;
    }

    static class ListNode {
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
