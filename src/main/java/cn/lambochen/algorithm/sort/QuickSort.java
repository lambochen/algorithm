package cn.lambochen.algorithm.sort;

import org.junit.Test;

/**
 * @Description 快排
 * @Author chenlinghong
 * @Date 2019/3/21 19:26
 **/
public class QuickSort {

    /**
     * 1）选择一个基准元素,通常选择第一个元素或者最后一个元素,
     * <p>
     * 2）通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。
     * <p>
     * 3）此时基准元素在其排好序后的正确位置
     * <p>
     * 4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
     */

    public void quickSort(int[] data) {
        quickSort(data, 0, data.length);
    }

    /**
     * 快排(升序)
     *
     * @param data  待排序数组
     * @param start 开始下标
     * @param end   结束下标
     */
    public void quickSort(int[] data, int start, int end) {
        if (start >= end - 1) {
            return;
        }
        // 选第一个元素作为基准
        int first = start + 1, second = end - 1;
        while (first < second) {
            // 寻找左值中比基准大的元素下标
            while (first < second && data[first] <= data[start]) {
                first++;
            }
            // 寻找右部分中比基准小的元素下标
            while (first < second && data[second] >= data[start]) {
                second--;
            }
            if (first < second) {
                int tmp = data[first];
                data[first] = data[second];
                data[second] = tmp;
                first++;
                second--;
            }
        }
        if (first >= second) {
            // 前后指针相遇
            int tmp = start, tmpValue = data[start];
            while (tmp < first) {
                data[tmp] = data[tmp + 1];
                tmp++;
            }
            data[first] = tmpValue;
            quickSort(data, start, first);
            quickSort(data, first, end);
        }
    }


    @Test
    public void test() {
        int[] a = new int[]{4, 1, 57, 32, 5, 0};
        quickSort(a);
        for (int tmp : a) {
            System.out.println(tmp);
        }
    }

}
