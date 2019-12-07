package com.pan.al.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 * 在一个长度为n的数组里面的所有数字都在0~n-1的范围里，找出重复的数字
 *
 */
public class Duplication {
    /**
     * 交换俩个数
     * @param arr
     * @param i
     * @param j
     */
    public  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /**
     * 数组下标与数字比较的方式
     * 时间复杂度O(n),空间复杂度O(1)
     *        解析
     * 当扫描下标为i的数字时，首先比较这个数字m和i是否相等，
     *    是：接着扫描下个数字
     *    否：nums[i]与nums[m]比较，
     *       等：找到重复的数字了；
     *       否：交换，在继续重复上面的过程
     * @param nums
     * @return
     */
   public boolean duplication(int[] nums,Integer temp){

       if(nums==null||nums.length<=0)
       {
           return false;
       }
       for (int i=0;i<nums.length;++i)
       {
           if(nums[i]<0||nums[i]>nums.length-1)
           {
               return  false;
           }
           while(nums[i]!=i)
           {
               if(nums[i]==nums[nums[i]])
               {
                   temp=nums[i];
                   return  true;
               }
               swap(nums,i,nums[i]);
           }
       }
       return  false;
   }

    /**
     *
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     */
      public static boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 此方法还没前面一个方法来的效率快，耗时短
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++)
        {

            for(Integer key:map.keySet())
            {
                if(map.containsKey(nums[i]))
                {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

    /**
     *   在一个二维数组里，每一行都是按照从左到右递增的顺序排列，每一列都是从上到下递增排序，输入一个数，判断二维
     *   数组中是否有这个数
     * @param matrix
     * @param rows 行
     * @param columns 列
     * @param number  数
     * @return
     */
    public boolean find(int[][] matrix,int rows,int columns,int number)
    {
         boolean found=false;
          if(matrix==null)
          {
              found=false;
          }
          if(matrix!=null &&rows>0&&columns>0)
          {
              int row=0;
              int column=columns-1;
              while(row<rows&&column>=0)
              {
                  if(matrix[row][column]==number)
                  {
                      found=true;
                      break;
                  }
                  else if(matrix[row][column]>number)
                  {
                      --column;
                  }else{
                      ++row;
                  }
              }
          }
        return found;
    }













}
