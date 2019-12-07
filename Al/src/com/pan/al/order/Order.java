package com.pan.al.order;

import java.util.*;

/**
 * 基于比较的排序
 */
public class Order {
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }

    /**
     * ①冒泡排序(稳定)
     *    迭代地对输入序列中的第个元素到最后一个元素进行俩来比较，当需要时交换来个元素的位置。（将大的往后排）
     * @param A
     * @param n
     *    基础版(即使在最好的情况下，时间复杂度为O(n2))
     */
    public void bubbleSort(int A[],int n)
    {
        for(int pass=n-1;pass>=0;pass--){
            for(int i=0;i<pass-1;i++)
            {
                if(A[i]>A[i+1])
                {
                    int temp=A[i];
                    A[i]=A[i+1];
                    A[i+1]=temp;
                }
            }
        }
    }

    /**
     *  冒泡排序改进版
     *     可以通过增加一个附加标记来改进，在排序中，没有交换操作则意味着排序完成，如果序列已经是有序的，则
     *     可以通过判断该标记来结束算法
     *     (在最好的情况下，时间复杂度为O(n))
     * @param A
     * @param n
     */
    public void bubbleSortImproved(int A[],int n){
        int pass,temp;
        boolean swapped=true;
        for(pass=n-1;pass>=0;pass--)
        {
            swapped=true;
            for(int i=0;i<pass-1;i++)
            {
                if(A[i]>A[i+1])
                {
                    temp=A[i];
                    A[i]=A[i+1];
                    A[i+1]=temp;
                    swapped=false;
                }
            }
            if(swapped)
                break;
        }
    }

    /**
     * ②选择排序（不稳定）
     *    （1）优点：原地排序算法，适合小文件，
     *    （2）缺点：时间复杂度为O(n2)
     *    算法步骤（最小的往前排）
     *    1）寻找序列中的最小值
     *    2）用当前位置的值交换最小值；
     *    3）对所有的元素重复上述的过程，直到整个序列拍完序；
     * @param A
     * @param n
     */
    public void selectionSort(int A[],int n)
    {
        if (A == null || A.length < 2) {
            return;
        }
        int i,j,min,temp;
        for(i=0;i<n-1;i++){
            min=i;
            for(j=i+1;j<n;j++)
            {
                if(A[j]<A[min])
                {
                    min=j;
                }
            }
            temp=A[min];
            A[min]=A[i];
            A[i]=temp;
        }
    }

    /**
     * ③插入排序（稳定）
     *   优点：实现简单；
     *        数据量少的时候效率高；
     *        在插入待排元素的同时对其进行排序；
     *        比冒泡，选择排序来的快，虽然最坏情况下的时间复杂度相同；
     * @param arr
     */

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
                return;
            }
            for (int i = 1; i < arr.length; i++) {
                int j = i;
                while (j > 0 && arr[j] < arr[j - 1]) {
                    swap(arr,j,j-1);
                    j--;
                }
        }
    }

    /**
     * ④希尔排序（缩小增量排序）（不稳定）
     *     希尔排序在数组中采用跳跃式分组的策略，通过某个增量h将数组元素划分为若干组，
     *     然后分组进行插入排序，随后逐步缩小增量，继续按组进行插入排序操作，直至增量为1；
     *     希尔通过快速移动元素位置到目的提高了插入排序的效率
     *
     *     平均时间复杂度取决于间隔序列，
     *     最好的情况下：O(nlogN)
     *
     */
    void shell_sort(int[] numbers,int start, int end)
    { int increment = end - start + 1;
    //初始化划分增量
        int temp;
        do { //每次减小增量，直到increment = 1
            increment = increment / 3 + 1;
            for (int i = start + increment; i <= end; ++i) {
                //对每个划分进行直接插入排
                if (numbers[i - increment] > numbers[i])
                {
                    temp = numbers[i];
                    int j = i - increment;
                do { //移动元素并寻找位置
                    numbers[j + increment] = numbers[j];
                    j -= increment;
                } while (j >= start && numbers[j] > temp);
                    numbers[j + increment] = temp;  //插入元素

                    }
            }
        }
        while (increment > 1);
    }

    /**
     * ⑤归并排序(稳定，时间复杂度为O(NlogN))
     *      1)归并是把已排列好的俩个序列，利用外排的方式排列在一起，
     *         当其中一个已经到达列尾，另一个剩下的直接拷贝
     *      2）归并是快速排序的补充；
     *      3）归并是以连续的方式访问数据；
     *      4）归并使用于链表的排序；
     *      5）分治的一个实例；
     *
     * @param arr
     */
    public void MergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);//中间位置
        mergeSort(arr, l, mid); //利用递归对左右序列进行各自的排列；
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    /**
     * ⑥快速排序
     *    分治的实例
     *    稳定性：不确定；
     *    最坏情况下，时间复杂度O(n2)
     *    最好的情况下，时间复杂度O(nlogn)
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);//确定分割点；
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;//小于区域指针
        int more = r;    //大于区域指针
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] { less + 1, more };  //返回小于大于区的分割点；
    }


}
