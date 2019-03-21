package com.chenlinghong.algorithm.sort;

/**
 * @Description 直接插入排序
 * @Author chenlinghong
 * @Date 2019/3/21 11:45
 **/
public class StraightInsertionSort {

    /**
     * 基本思想:
     *
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
     * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     *
     * 要点：设立哨兵，作为临时存储和判断数组边界之用。
     *
     * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
     * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，
     *
     * 插入排序是稳定的。
     */

    /**
     * 时间复杂度：O(n*n)
     *
     *      最好情况 O(n)：数据已有序，即遍历一遍，不需要进行交换元素：
     *
     *      最坏情况 O(n*n)：数据与结果逆序排列，每个元素都需要从末尾逐一交换到第一个位置
     *
     * 空间复杂度：O(1)
     *
     */

    /**
     * 此方法直接在原数组中进行交换数据，可不进行返回值。
     * <p>
     * 优点：不进行新数组内存申请
     * <p>
     * 缺点：丢失原数据信息
     * <p>
     */
    /**
     * 升序实现
     */
    public void straightInsertionSort01(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[i]) {
                    int tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 降序实现
     */
    public void straightInsertionSort02(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] < data[i]) {
                    int tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
