package com.pan.al.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    //private int[] index;
    //private int[] temp;
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return list;
        }
        //temp = new int[len];
        count = new int[len];
        int[] index = new int[len];

        for(int n=0;n<nums.length;n++)
        {
            index[n] = n;
        }

        MergeSort(nums,index);

        for(int i=0;i<count.length;i++)
            list.add(count[i]);
        return list;
    }

    public  void MergeSort(int[] arr,int[] index){
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1,index);
    }


    public  void mergeSort(int arr[],int left,int right,int[] index)
    {
        if(left==right)
        {
            return;
        }
        int mid=left+(right-left)/2;
        mergeSort(arr,left,mid,index);
        mergeSort(arr,mid+1,right,index);
        merge(arr,left,mid,right,index);
    }




    public  void merge(int arr[],int l,int mid,int r,int[] index)
    {
        int[] temp=new int[r-l+1];

        int[] helper=new int[r-l+1];
        int p1=l;
        int p2=mid+1;
        int i=0;
        while(p1<=mid&&p2<=r)
        {
            if(arr[p1]<=arr[p2])
            {

                temp[i]=index[p1];
                count[temp[i]]+=p2-mid-1;
                helper[i++]=arr[p1++];
            }else{

                temp[i]=index[p2];
                helper[i++]=arr[p2++];
            }

        }
        while(p1<=mid)
        {

            temp[i]=index[p1];
            count[temp[i]]+=r-mid;
            helper[i++]=arr[p1++];
        }
        while(p2<=r)
        {

            temp[i]=index[p2];
            helper[i++]=arr[p2++];
        }
        for (i = 0; i < helper.length; i++)
        {
            arr[l+i]=helper[i];
            index[l+i]=temp[i];

        }


    }
    public static void main(String[] args) {
        int[] nums = new int[]{6, 5,4,3,2,1};
        Test2 solution = new Test2();
        List<Integer> countSmaller = solution.countSmaller(nums);
        System.out.println(countSmaller);
        for(int i=0;i<nums.length;i++)
        System.out.print(nums[i]);
    }


}
