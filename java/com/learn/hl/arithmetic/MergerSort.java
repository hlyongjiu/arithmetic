package com.learn.hl.arithmetic;

import java.util.Arrays;

/**
 * description: MergerSort
 * 归并排序（Merge sort，台湾译作：合并排序）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 <br>
 * 基本思想
 * 归并排序的主要思想是分治法。
 * 主要过程是：
 * 1.将n个元素从中间切开，分成两部分。（左边可能比右边多1个数）
 * 2.将步骤1分成的两部分，再分别进行递归分解。直到所有部分的元素个数都为1。
 * 3.从最底层开始逐步合并两个排好序的数列。
 * date: 2019/12/10 11:14 <br>
 * author: huanglong <br>
 * version: 1.0 <br>
 */
public class MergerSort {

    public static void main(String[] args) {
        int[] arys = new int[]{30,5,89,65,4,7,15,54,60,28,30,45};
        System.out.println(Arrays.toString(arys));
        mergeSort(arys);
        System.out.println(Arrays.toString(arys));
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);

    }

    // 归并
    private static void mergeSort(int array[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, first, mid, temp); // 递归归并左边元素
            mergeSort(array, mid + 1, last, temp); // 递归归并右边元素
            mergeArray(array, first, mid, last, temp); // 再将二个有序数列合并
        }
    }

    /**
     * 合并两个有序数列
     * array[first]~array[mid]为第一组
     * array[mid+1]~array[last]为第二组
     * temp[]为存放两组比较结果的临时数组
     */
    private static void mergeArray(int array[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1; // i为第一组的起点, j为第二组的起点
        int m = mid, n = last; // m为第一组的终点, n为第二组的终点
        int k = 0; // k用于指向temp数组当前放到哪个位置
        while (i <= m && j <= n) { // 将两个有序序列循环比较, 填入数组temp
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while (i <= m) { // 如果比较完毕, 第一组还有数剩下, 则全部填入temp
            temp[k++] = array[i++];
        }
        while (j <= n) {// 如果比较完毕, 第二组还有数剩下, 则全部填入temp
            temp[k++] = array[j++];
        }
        for (i = 0; i < k; i++) {// 将排好序的数填回到array数组的对应位置
            array[first + i] = temp[i];
        }
    }
}
