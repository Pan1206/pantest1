package com.pan.al.sort;

import com.pan.al.order.Order;
import org.omg.CORBA.ORB;

/**
 * 归并排序（分治）
 *归并是把俩个已排序的文件，使用外排的方式合并陈一个更大的已排序的文件的过程
 * 时间复杂度O(NlogN)
 *
 */
public class MergeSort {

    public static  void merge(int[] arr,int left,int middle,int right) {
        int[] help = new int[right - left + 1];
        //int[] help = new int[arr.length];
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        while (p1 <= middle && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <=right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++)
        {
            arr[left+i]=help[i];
        }
    }

    public static  void  mergeSort(int[] arr,int left,int right)
    {
        if(left==right)
        {
            return;
        }
        int mid=left+((right-left)>>1);
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public static  void mergeSort(int[] arr)
    {
        if(arr==null||arr.length<1)
        {
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void main(String[] args) {

        int[] nums={2,4,5,3};
//        MergeSort.mergeSort(nums);
//        for(int i=0;i<nums.length;i++)
//            System.out.print(nums[i]);
        Order order=new Order();
        order.MergeSort(nums);
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]);
    }
}
