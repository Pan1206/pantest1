package com.pan.al.test;

import com.pan.al.test.outerinterclass.Outer;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
//        int[][] mark=new int[5][5];
//        for(int i=0;i<mark.length;i++)
//            for(int j=0;j<mark[0].length;j++)
//        System.out.println(mark[i][j]);
//        List<String> localtion=new ArrayList<>();
//
//        for(int i=0;i<5;i++)
//        {
//            StringBuilder stringBuilder=new StringBuilder();
//            for(int j=0;j<5;j++)
//            stringBuilder.append(".");
//            localtion.add(stringBuilder.toString());
//        }
//        System.out.println(localtion);
         //testList();
        minMax();
    }


    public static void minMax()
    {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(7);
        queue.add(6);
        queue.add(10);
        System.out.println(queue.poll());

        PriorityQueue<Integer> queue1=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue1.add(1444);
        queue1.add(12);
        queue1.add(105555);
        System.out.println(queue1.poll()+" "+ queue1.poll());

    }

    public static void listAdd(List<Integer> list)
    {
        list.add(1);
        list.add(4);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int len=nums.length;
        Integer count=1<<len; //集合总数
        for(Integer i=0;i<count;++i)
        {
            List<Integer> list=new ArrayList<>();
            for(Integer j=0;j<len;++j)
            {
                int m=1<<j;
                if((i&m)>0)    //1<<j表示构建数组的第几个元素
                    list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); //排序
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public static void testList()
    {
        int[] nums={1,2,4,4,4,3,2,5,6,6};
        List<Integer> list=new ArrayList<>();


        for(int i=0;i<nums.length;i++)
        {
             list.add(nums[i]);
        }
        System.out.println(list);
        list.remove(list.size()-1);
        System.out.println(list);
        List<List<Integer>> lists=new ArrayList(list);
        System.out.println(lists);
    }
}
