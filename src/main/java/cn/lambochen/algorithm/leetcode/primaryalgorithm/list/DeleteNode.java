package cn.lambochen.algorithm.leetcode.primaryalgorithm.list;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/21 23:53
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 **/
public class DeleteNode {

    /**
     * 删除链表中的节点
     * <p>
     * 解题思路： 将下一个节点的数据赋值给当前节点，然后删掉下一个节点（通过改变指向）
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
