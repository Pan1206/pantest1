package com.pan.al.stack;

import java.util.Stack;

/**
 * 问题1：
 * 给定一个栈，如何只使用栈操作(push和pop)逆置栈中的内容
 */
public class StackReveral {
      public static  void reverseStack(Stack stack)
      {
          if(stack.isEmpty()) return;
          int temp=(int)stack.pop();
          reverseStack(stack);
          insertAtBottom(stack,temp);
      }

    private static void insertAtBottom(Stack stack, int data) {
          if(stack.isEmpty())
          {
              stack.push(data);
          }
          int temp= (int) stack.pop();
          insertAtBottom(stack,data);
          stack.push(temp);
    }
    /**问题2：
     * 计算跨度，给定数组A，A[i]的跨度S[i]定义为：满足A[j]<=A[j+1]且A[i]之前的连续元素啊A[j]的最大个数
     * 如股票
     *
     * 日期      输入的数组A[i]    s[i]
     * 0          6               1
     * 1          3               1
     * 2          4               2
     * 3          5               3
     * 4          3               1
     *
     */
    /**
     * 获得跨度
     * 时间复杂度为O(n2)  空间复杂度O(1)
     * @param inputArray
     * @return
     */
     public  int[] findSpans(int[] inputArray)
     {
         int[] spans=new int[inputArray.length];
         for(int i=0;i<inputArray.length;i++)
         {   int span=1;
             int j=i-1;
             while (j>=0&&inputArray[j]<=inputArray[j+1])
             {
                 span++;
                 j--;
             }
             spans[i]=span;
         }
         return spans;
     }
    /**
     *观察上题的例子可发现，如果能找到最近股票比第i天低的是哪天，那么就能很容易得计算出第i天
     * 的跨度S[i].假设这天记为P,S[i]-p;
     * 时间复杂度o(n),空间复杂度O(n);
     * @param inputArray
     * @return
     */
    public int[] FindingSpans(int[] inputArray){
        int[] spans=new int[inputArray.length];
        Stack<Integer> stack=new Stack<>();
        int p=0;
        for(int i=0;i<inputArray.length;i++)
        {
            while (!stack.isEmpty()&&inputArray[i]>inputArray[stack.peek()])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                p=-1;
            }
            else{
                p=stack.peek();
            }
            spans[i]=i-p;
            stack.push(i);
        }
        return spans;
    }


    /**
     * 问题3：设计一个可以把栈中元素按照升序排列的排列算法
     * 且算法不能对栈的具体实现方式有限定；
     * 时间复杂度o(n2),空间复杂度O(n)
     * @param s
     * @return
     */
     public static  Stack<Integer> sort(Stack<Integer> s) {
         Stack<Integer> r = new Stack<>();
         while (!s.isEmpty()) {
             int temp = s.pop();
             while (!r.isEmpty() && r.peek() > temp) {
                 s.push(r.pop());
             }
             r.push(temp);
         }
         return r;

     }
}
