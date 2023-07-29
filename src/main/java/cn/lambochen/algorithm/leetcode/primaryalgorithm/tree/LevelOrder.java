package cn.lambochen.algorithm.leetcode.primaryalgorithm.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/10/11 20:54
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 **/
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> ite = new ArrayDeque<>();
        ite.add(root);

        while (!ite.isEmpty()) {
            Queue<TreeNode> tmp = new ArrayDeque<>();
            List<Integer> res = new LinkedList<>();
            while (!ite.isEmpty()) {
                TreeNode node = ite.poll();
                res.add(node.val);
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            ite = tmp;
            result.add(res);
        }

        return result;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
