package com.pan.al.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueDemo {
    /**
     * 问题1：
     * 设计一个逆置队列元素的算法
     * 时间复杂度为O（n）
     * @param queue
     * @return
     */
    public static Queue reverseQueue(Queue queue)
    {
        Stack stack=new Stack();
        while (!queue.isEmpty())
        {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty())
        {
            queue.add(stack.pop());
        }
        return  queue;
    }

    /**
     * 问题4：
     * 给定一个整数队列，如何把队列中前半部分和后半部分的元素相互交叉，完成队列中元素的重新排列；
     * @param q
     */
    public void interLeavingQueue(Queue<Integer> q){
        if(q.size()%2!=0)
        {
            throw  new IllegalArgumentException();
        }
        Stack<Integer> s=new Stack<Integer>();
        int halfSize=q.size()/2;
        for(int i=0;i<halfSize;i++){
            s.push(q.poll());
        }
        while (!s.isEmpty())
        {
            q.add(s.pop());
        }
        for(int i=0;i<halfSize;i++){
            s.push(q.remove());
        }
        while (!s.isEmpty()){
            q.offer(s.pop());
            q.offer(q.remove());
        }
    }

    /**
     * 问题5：给定一个整数和一个整数队列，如何把队列前k个元素逆置，其余的元素
     * @param k
     * @param q
     */
    public static  void reverseQueueFirstKElenments(int k,Queue<Integer> q)
    {
        if(q==null||k<q.size()){
            throw  new IllegalArgumentException();
        }else if(k>0) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i = 0; i < k; i++)
            {
                s.push(q.remove());
            }
            while (!s.isEmpty())
            {
                q.add(s.pop());
            }
            for(int i=0;i<q.size()-k;i++)
            {
                q.add(q.remove());
            }
        }
    }



}
