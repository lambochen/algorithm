package cn.lambochen.algorithm.leetcode.primaryalgorithm.tree;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/10/9 23:58
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 **/
public class MaxDepth {

    /**]
     * 二叉树的最大深度
     *
     * 解题思路：广度优先搜索
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }

        return res;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
