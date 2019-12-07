package com.pan.al.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 问题3：使用俩个队列实现栈的功能
 * 1）入栈操作（在任意一个非空队列中插入元素）
 *    a）检查队列Q1是否为空，如果q1为空，那么对Q2执行入队操作
 *    b)否则对Q1进行入栈操作
 *  2）出栈操作（将n-1个元素移到另一个队列中，删除当前队列的最后一个元素）
 *    如果队列Q1为非空，那么从Q1移n-1个元素到Q2中，然后对Q1中的最后一个元素执行出队操作，并返回该元素；
 *    如果队列Q2为非空，那么从Q2移n-1个元素到Q2中，然后对Q2中的最后一个元素执行出队操作，并返回该元素；
 */
public class StackWithQueue {
    LLQueue queue1;
    LLQueue queue2;

    public StackWithQueue(){
        queue1=new LLQueue();
        queue2=new LLQueue();
    }

    public void push(int data)
    {
        if(queue1.isEmpty())
        {
            queue2.enQueue(data);
        }else {
            queue1.enQueue(data);
        }
    }


    public  int pop() throws Exception {
        int i=0,size=0;
        if(queue2.isEmpty()){

            size=queue1.getQueueSize();
            while (i<size-1)
            {
                queue2.enQueue(queue1.deQueue());
                i++;
            }
            return  queue1.deQueue();
        }else{
            size=queue2.getQueueSize();
            while (i<size-1)
            {
                queue1.enQueue(queue2.deQueue());
                i++;
            }
            return  queue2.deQueue();
        }
    }

}
