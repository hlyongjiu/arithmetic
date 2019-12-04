package com.learn.hl.arithmetic;

import java.util.Arrays;

/**
 * @Auther: hl
 * @Date: 2019/12/3 14:14
 * @Description: 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 堆排序的平均时间复杂度为Ο(nlogn) 。
 *
 * 基本思想：
 *
 * 1.首先将待排序的数组构造成一个大根堆，此时，整个数组的最大值就是堆结构的顶端
 *
 * 2.将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
 *
 * 3.将剩余的n-1个数再构造成大根堆，再将顶端数与n-1位置的数交换，如此反复执行，便能得到有序数组
 */
public class HeapSort {
    public static void main(String[] args) {
        //二叉树父节点下的子节点为2n+1,2n+2.其中n为0时,是根节点
        int[] arys = new int[]{3, 6, 8, 5, 5, 7, 9, 6};

        int max = 0;
        for (int i=1;i<arys.length-1;i++) {
            if (arys[i] > arys[0]) {
               int temp = arys[i];
               arys[i] = arys[0];
               arys[0] = temp;
            }
        }
        System.out.println(Arrays.toString(arys));
    }

    //交换数组中,两个数的位置
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
