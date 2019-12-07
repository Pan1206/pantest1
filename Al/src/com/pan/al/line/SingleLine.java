package com.pan.al.line;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 单向链表的基本操作
 */
public class SingleLine {
    /**
     * 计算链表的长度
     * @param headNode
     * @return
     */
    public int listLength(ListNode headNode)
    {
        int length=0;
        ListNode currentNode=headNode;
       while(currentNode!=null)
       {
           length++;
           currentNode=currentNode.getNext();
       }
       return  length;
    }

    /**
     * 插入新的结点
     * 链表的开始，随机中间位置，结尾
     * 时间复杂度O(n),空间复杂度O（1）
     * * @param headNode
     * @param nodeTOInsert
     * @return
     */
    public ListNode insertInLinkedList(ListNode headNode,ListNode nodeTOInsert,int position){
        if(headNode==null)
        {
            return nodeTOInsert;
        }
        int size=listLength(headNode);

        if(position>size+1||position<1)
        {
            System.out.println("postion of node to insert is invalid");
            return headNode;
        }
        if(position==1)//在开头插入
        {
            nodeTOInsert.setNext(headNode);
            return nodeTOInsert;
        }else {
            //在链表中间或者末尾插入
            ListNode previousNode=headNode;
            int count=1;
            while (count<position-1)
            {
                previousNode=previousNode.getNext();
                count++;
            }
            ListNode currentNode=previousNode.getNext();
            nodeTOInsert.setNext(currentNode);
            previousNode.setNext(nodeTOInsert);

        }
         return headNode;
    }

    /**
     * 单向链表的删除
     * @param headNode
     * @param position
     * @return
     */
    public ListNode DeleteNodeFromLinkedList(ListNode headNode,int position)
    {
        int length=listLength(headNode);
        if(position>length+1||position<1)
        {
            System.out.println("postion of node to insert is invalid");
            return headNode;
        }
        if(position==1)
        {
            ListNode currentNode=headNode.getNext();
            headNode=null;
            return  currentNode;
        }else {
            ListNode previousNode=headNode;
            int count=1;
            while (count<position)
            {
                previousNode=previousNode.getNext();
                count++;
            }
            ListNode currentNode=previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode=null;
        }
        return  headNode;
    }

    /***************************************************************
     * 问题1：给定一个链表，找到链表的倒数第 n 个节点，
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pTemp=head;
        ListNode pNthNode=null;
        if(head==null||n==0)
        {
            return null;
        }
        for(int count=1;count<n;count++) {
            if (pTemp != null) {
                pTemp = pTemp.getNext();
            }else {
                return null;
            }
        }
            while (pTemp!=null){
                if(pNthNode==null)
                {
                    pNthNode=head;
                }
                else {

                    pNthNode=pNthNode.getNext();
                }
                pTemp=pTemp.getNext();
            }
            if(pNthNode!=null)
            {
                return pNthNode;
             }
             return null;

    }

    /*************************************************
     * 问题2：判断链表是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        if(head==null)
        {
            return false;
        }
        while(fastPtr.getNext()!=null&&fastPtr.getNext().getNext()!=null)
        {
            slowPtr=slowPtr.getNext();
            fastPtr=fastPtr.getNext().getNext();
            if(slowPtr==fastPtr)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * 求链表是否存在环，存在则返回环的长度
     * 在找到环之后，fastPtr继续遍历，并开始计数，保证slowPtr不变，直到俩者再次相遇；
     */


    /************************************************************************
     * 问题3：反转一个单向链表
     * 非递归方式,一次循环解决问题
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode currentNode=head;
        ListNode previousNode=null;
        ListNode nextNode=null;
        while(currentNode!=null)
        {
            nextNode=currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }

    /**
     * 利用栈来解决问题
     * @param head
     * @return
     */
   public ListNode reversingly(ListNode head)
   {
       ListNode currentNode=head;
       Stack<ListNode> stack=new Stack<>();
       while (currentNode.getNext()!=null)
       {
           stack.push(currentNode);
           currentNode=currentNode.getNext();
       }
       head=currentNode;
       while (stack.empty())
       {
           currentNode.setNext(stack.pop());
           stack.pop();
       }
       currentNode.setNext(null);
       return head;
   }

    /***************************************
     * 问题4：
     * 假设俩个单向链表在某个结点相交之后，成为一个单向链表。俩个链表得表头结点是已知的。但相交点是未知的
     * 它们在相交之前各自的结点数也是未知的，并且俩个链表的结点数也有可能不同，设计一个算法，找到俩个链表
     * 的合并点
     *
     * 1）蛮力法：时间复杂度高 O(mn)
     * 2）哈希表技术O(m+n)
     *    分析：
     *    A)选择结点数少的链表(未知的话随意)，将其所有的结点的指针值保存在哈希表
     *    B）遍历另一个链表，去检查哈希表中是否保存了其结点指针；
     *    C）如果俩个链表存在合并点，那么必定在散列表中找到记录。
     * 3)排序搜索法  o(max(mlogm,nlogn))
     *    分析
     *    A)创建数数组A，在数组中保存第一个链表中所有结点的后继指针
     *    B）对于第二个链表中的每个结点，在排序数组中搜索（使用折半查找法）
     *  4)快慢指针方法
     *    A）获取俩个链表的长度O（max(m,n)）
     *    B)计算俩者之间的差d
     *    C）从较长的表头开始，移动d步、
     *    D)在俩个链表中开始同时移动，直至出现俩个后继指针相等的情况 O(min(m.n))
     *
     */
      public ListNode findIntersectingNode(ListNode head1,ListNode head2)
      {
          int length1=0;
          int length2=0;
          int diff=0;
          ListNode currentNode1=head1;
          ListNode currentNode2=head2;
          while (currentNode1!=null)
          {
              length1++;
              currentNode1=currentNode1.getNext();
          }
          while (currentNode2!=null)
          {
              length2++;
              currentNode2=currentNode2.getNext();
          }
          if(length1<length2)
          {
              currentNode1=head2;
              currentNode2=head1;
              diff=length2-length1;
          }else
          {
              currentNode1=head1;
              currentNode2=head2;
              diff=length1-length2;
          }
          for(int i=0;i<diff;i++)
          {
              currentNode1=currentNode1.getNext();
          }
          while(currentNode1!=null&&currentNode2!=null)
          {
              if(currentNode1==currentNode2)
              {
                  return currentNode1;
              }
              currentNode1=currentNode1.getNext();
              currentNode2=currentNode2.getNext();
          }
          return  null;
      }

    /**********************************************
     * 问题5：查找链表的中间位置（快慢指针方法,快的是慢的2倍）
     * @param head
     * @return
     */
      public  ListNode findMiddle(ListNode head)
      {
          ListNode ptr1,ptr2;
          ptr1=ptr2=head;
          int i=0;
          while(ptr1.getNext()!=null) {
              if (i == 0)
              {
                  ptr1=ptr1.getNext();
                  i=1;
              }else if(i==1)
              {
                  ptr1=ptr1.getNext();
                  ptr2=ptr2.getNext();
                  i=0;
              }
          }
          return  ptr2;
      }


}
