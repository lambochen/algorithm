package cn.lambochen.algorithm.sort;

import org.junit.Test;

/**
 * @Description 冒泡排序
 * @Author chenlinghong
 * @Date 2019/3/21 19:16
 **/
public class BubbleSort {

    /**
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
     *
     * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */

    /**
     * 升序
     */
    public void bubbleSort01(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 2; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 降序
     */
    public void bubbleSort02(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    @Test
    public void test(){
        int [] a = new int[]{1,5,2,5,7};
        bubbleSort02(a);
        for (int tmp : a){
            System.out.println(tmp);
        }
    }

}
