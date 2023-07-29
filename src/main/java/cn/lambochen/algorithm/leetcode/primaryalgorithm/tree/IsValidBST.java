package cn.lambochen.algorithm.leetcode.primaryalgorithm.tree;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/10/11 19:57
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 **/
public class IsValidBST {

    /**
     * 验证二叉搜索树
     *
     * 解题思路：递归判断即可
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
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
