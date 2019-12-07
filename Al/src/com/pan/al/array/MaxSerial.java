package com.pan.al.array;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定K个整数组成的序列{ N​1​​, N​2​​, ..., N​K​​ }，“连续子列”被定义为{ N​i​​, N​i+1​​, ..., N​j​​ }，
 * 其中 1≤i≤j≤K。“最大子列和”则被定义为所有连续子列元素的和中最大者。
 * 例如给定序列{ -2, 11, -4, 13, -5, -2 }，其连续子列{ 11, -4, 13 }有最大的和20。
 * 现要求你编写程序，计算给定整数序列的最大子列和。
 */
public class MaxSerial {
    /**
     * 时间复杂度为O(n)
     * @param nums
     * @param N
     * @return
     */
    public int MaxSubseqSum(int nums[],int N)
    {
        int thisSum=0;
        int maxSum=0;
        int i;
        for(i=0;i<N;i++)
        {
            thisSum+=nums[i];//向右累加
            if(thisSum>maxSum)
            {
                maxSum=thisSum;//发现更大的则更新当前结果
            }
            else if(thisSum<0)  //如果当前子类和为负，不可能使后面的部分的和增大，弃之
            {
                 thisSum=0;
            }
        }
        return  maxSum;
    }

    /**
     * 最简单的添加数组到list
     * @param nums
     * @return
     */
    public List<Integer> function(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums.length; i++)
        {
            list.add(nums[i]);
        }
        return  list;
    }

    public List<Integer> function2(int[] nums){
        List<Integer> list=new ArrayList<>();
        list=function(nums);
        List a=function(nums);
        list.addAll(a);
        return list;
    }

    public void function3(){
        int[] nums={1,2,3,4,5,6,7};
        List<String> list=new ArrayList<>();
        String strs=nums.toString();

        list.addAll(Arrays.asList(strs));
        System.out.println(list);

    }

    public void run(){
        List<Integer> list=new ArrayList<>();
        int[] nums={1,2,3,4,5,6,7};
        list=function2(nums);

        System.out.println(list);
    }

}
