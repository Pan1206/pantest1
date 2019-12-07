package com.pan.al.queue;

import java.util.Stack;

public class QueueWithStack {
    /**
     * 问题2：如何用俩个栈来实现队列
     *   1）入队算法
     *      只需将元素压入栈S1；
     *   2）出队算法
     *      如果栈S2不为空，那么对栈S2执行出栈操作，并返回出栈元素
     *      如果栈S2为空，那么把栈S1中的所有元素移到栈S2中，然后弹出S2栈顶，
     *      并返回该元素；
     */
     Stack stack1;
     Stack stack2;
     
     public  QueueWithStack(){
         stack1=new Stack<Integer>();
         stack1=new Stack<Integer>();
     }

     public  boolean isEmpty(){
         if(stack2.isEmpty())
         {
             while (!stack1.isEmpty())
             {
                 stack2.push(stack1.pop());
             }
         }
         return  stack2.isEmpty();
     }

     public  void enQueue(Object data)
     {
          stack1.push(data);
     }

     public Object deQueue(){
         if(!stack2.isEmpty())
         {
             return stack2.pop();
         }else{
             while (!stack1.isEmpty()){
                 stack2.push(stack1.pop());
             }
             return stack2.pop();
         }
     }
}
