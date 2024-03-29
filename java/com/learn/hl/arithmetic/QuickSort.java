package com.learn.hl.arithmetic;

import java.util.Arrays;

/**
 * @Auther: hl
 * @Date: 2019/12/2 17:12
 * @Description: 快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要Ο(n log n)次比较。
 * 在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。事实上，快速排序通常明显比其他Ο(n log n) 算法更快，
 * 因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
 * <p>
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 * <p>
 * 算法步骤：
 * <p>
 * 1 从数列中挑出一个元素，称为 “基准”（pivot），
 * 2 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * <p>
 * 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。
 * 虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去
 */
public class QuickSort {
    public static void main(String[] args) {
       int[] arys = new int[]{30,5,89,65,4,7,15,54,60,28,30,45};
        //int[] arys = new int[]{55,44,99};
//        int[] arys = new int[]{30,28,29,50};
        System.out.println("快速排序前:" + Arrays.toString(arys));
        long l = System.currentTimeMillis();
        quickSort(arys,0,arys.length-1);
        System.out.println("快速排序后:" +Arrays.toString(arys));
        System.out.println("用时:"+(System.currentTimeMillis()-l)+ "毫秒");
       // System.out.println(arys.length);
    }

    public static void quickSort(int[] arys, int low, int high) {

        //结束条件
        if (low > high) {
            return;
        }
        int key = arys[low];
        int i = low;
        int j = high;

        //从左到右遍历,和从右至左遍历,退出循环条件,即遍历到相同位置时
        while (i < j) {
            //从右往左找到第一个小于key的值
            while (i < j && arys[j] >= key) {
                j--;
            }
            //从数组左侧查找比key值大的数据
            while (i < j && arys[i] <= key) {
                i++;
            }

            if (i < j) {
                int temp = arys[i];
                arys[i] = arys[j];
                arys[j] = temp;
            }
        }

        //将key值放数组中间
        arys[low] = arys[i];
        arys[i] = key;
        //递归调用左半数组
        quickSort(arys, low, i-1);
        //递归调用右半数组
        quickSort(arys, j+1, high);
    }
}
