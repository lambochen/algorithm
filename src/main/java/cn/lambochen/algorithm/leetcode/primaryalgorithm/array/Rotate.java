package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/19 18:02
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 **/
public class Rotate {

    /**
     * 旋转图像
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 对角线对折
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 竖中线对折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }

}
