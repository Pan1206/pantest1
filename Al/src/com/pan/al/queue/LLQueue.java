package com.pan.al.queue;

import com.pan.al.line.ListNode;
import org.omg.CORBA.PUBLIC_MEMBER;

public class LLQueue {

    private ListNode frontNode;
    private ListNode rearNode;

   public LLQueue(){
        this.frontNode=null;
        this.rearNode=null;
    }

     public static LLQueue createQueue(){
        return  new LLQueue();
     }

     public boolean isEmpty()
     {
         return (frontNode==null);
     }

     public  void enQueue(int data)
     {
         ListNode newNode=new ListNode(data);
         if(rearNode!=null)
         {
             rearNode.setNext(newNode);
         }
          rearNode=newNode;
         if(frontNode==null)
         {
             frontNode=rearNode;
         }
     }

     public int deQueue() throws Exception {
        Integer data;
        if(isEmpty())
        {
            throw  new Exception("Queue Empty");
        }else{
            data= (Integer) frontNode.getData();
            frontNode=frontNode.getNext();
        }
          return data;
     }

     public int getQueueSize(){

       ListNode currentNode=frontNode;
       int size=0;
       if(frontNode==null)
       {
           return 0;
       }else{
           while (frontNode!=null)
           {
               size++;
               frontNode=frontNode.getNext();
           }
       }

       return size;
     }
}
