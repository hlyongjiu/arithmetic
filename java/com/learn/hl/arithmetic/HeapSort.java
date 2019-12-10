package com.learn.hl.arithmetic;

import java.util.Arrays;

/**
 * @Auther: hl
 * @Date: 2019/12/3 14:14
 * @Description: 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * <p>
 * 堆排序的平均时间复杂度为Ο(nlogn) 。
 * <p>
 * 基本思想：
 * <p>
 * 1.首先将待排序的数组构造成一个大根堆，此时，整个数组的最大值就是堆结构的顶端
 * <p>
 * 2.将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
 * <p>
 * 3.将剩余的n-1个数再构造成大根堆，再将顶端数与n-1位置的数交换，如此反复执行，便能得到有序数组
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arys = new int[]{30,5,89,65,4,7,15,54,60,28,30,45};
        System.out.println(Arrays.toString(arys));
        heapSort(arys);
        System.out.println(Arrays.toString(arys));
    }

    private static void heapSort(int[] arr) {
        //创建大根堆
        createBigHeap(arr);
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, size - 1);
            size--;
            //构建大根堆
            bigHeap(arr, 0, size);
        }
    }

    //构建大根堆(从上往下寻找大根)
    private static void createBigHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //获取当前索引
            int currentIndex = i;
            //获取父索引
            int fatherIndex = (currentIndex - 1) / 2;
            //如果当前插入的值大于其父节点的值,则交换值,并且将索引指向新的父节点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //获取新的父节点
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    public static void bigHeap(int arr[], int index, int size) {
        //左子节点,右子节点
        int leftNode = 1;
        int rightNode = 2;
        while (leftNode < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (rightNode < size && arr[leftNode] < arr[rightNode]) {
                largestIndex = rightNode;
            } else {
                largestIndex = leftNode;
            }

            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }

            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            leftNode = 2 * index + 1;
            rightNode = 2 * index + 2;
        }
    }

    //交换数组中,两个数的位置
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
