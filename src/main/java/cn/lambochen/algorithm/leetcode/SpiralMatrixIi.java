package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class SpiralMatrixIi {

    // 模拟
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        res[0][0] = 1;
        if (n == 1) {
            return res;
        }

        int i = 0, j = 0;
        int tmp = res[0][0];
        int n2 = n * n;
        while (tmp < n2) {
            while (j < n - 1 && res[i][j + 1] == 0) {
                res[i][++j] = ++tmp;
            }
            while (i < n - 1 && res[i + 1][j] == 0) {
                res[++i][j] = ++tmp;
            }
            while (j > 0 && res[i][j - 1] == 0) {
                res[i][--j] = ++tmp;
            }
            while (i > 0 && res[i - 1][j] == 0) {
                res[--i][j] = ++tmp;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixIi handler = new SpiralMatrixIi();
        handler.generateMatrix(3);
    }

}
