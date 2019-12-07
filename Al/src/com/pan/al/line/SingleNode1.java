package com.pan.al.line;

public class SingleNode1 {
    /**问题6：
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     *
     */
    public ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        ListNode1 currentNode1=l1;
        ListNode1 currentNode2=l2;
        ListNode1 list=null;
        if(l1==null&&l2!=null)
        {
            return l2;
        }
        if(l1!=null&&l2==null)
        {
            return l1;
        }
        if(l1==null&&l2==null)
        {
            return null;
        }

        if(currentNode1.val<currentNode2.val)
        {
            list=currentNode1;
            currentNode1=currentNode1.next;
        }else {
            list=currentNode2;
            currentNode2=currentNode2.next;
        }

        ListNode1 head=list;

        while(currentNode1!=null&&currentNode2!=null)
        {
            if(currentNode1.val<currentNode2.val)
            {
                list.next=currentNode1;
                currentNode1=currentNode1.next;

            }else{
                list.next=currentNode2;
                currentNode2=currentNode2.next;

            }
            list=list.next;
        }

        if(currentNode1!=null)
        {
            list.next=currentNode1;
        }
        if(currentNode2!=null)
        {
            list.next=currentNode2;
        }

        return head;

    }
    /*******************************/
    /**
     * 递归方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode1 mergeTwoLists1(ListNode1 l1, ListNode1 l2) {
        if(l1==null)
        {
            return l2;
        }else if(l2==null)
            return l1;
        ListNode1 head=null;
        if(l1.val<l2.val)
        {
            head=l1;
            head.next= mergeTwoLists( l1.next, l2);

        }else{
            head=l2;
            head.next= mergeTwoLists( l1,  l2.next);
        }
        return head;
    }

    /**
     * 打印
     * @param head
     */
    public void printLinkList(ListNode1 head)
    {
        System.out.print("linked list:");
        while (head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }

    }

    /**问题7：
     * 判断链表长度是奇数还是偶数
     * @param head
     * @return
     */
    public int isListLengthEven(ListNode head)
    {

        while (head.getNext()!=null&&head.getNext()!=null)
        {
            head=head.getNext().getNext();
        }
        if(head==null)
        {
            return 0;
        }
        return 1;
    }

    /**问题8：
     * 逐对逆置链表
     * 方法一：递归方式
     * @param head
     * @return
     */
    public ListNode1 Reversecuvise(ListNode1 head){
         if(head==null||head.next!=null)
             return head;
         ListNode1 temp=null;
         temp=head.next;
         head.next=temp.next;
         head=temp;
         head.next.next=Reversecuvise(head.next.next);
        return  head;
    }

    /**
     * 方法二：迭代
     * @param head
     * @return
     */
    public ListNode1 ResversePairIterative(ListNode1 head){
        ListNode1 temp1=null;
        ListNode1 temp2=null;
        while (head!=null&&head.next!=null)
        {
            if(temp1!=null)
            {
                temp1.next.next=head.next;
            }
            temp1=head.next;
            head.next=head.next.next;
            temp1.next=head;
            if(temp2==null)
            {
                temp2=temp1;
            }
            head=head.next;
        }
        return temp2;
    }

    /**问题9；
     *   将循环链表分割成俩个长度相等的部分，如果链表是奇数长度，
     *           就让第一个链表的的结点数比第二个多一个；
     * @param head
     * @param head1
     * @param head2
     */
    public void splitList(ListNode head,ListNode head1,ListNode head2)
    {
        ListNode slowPtr=head,fastPtr=head;
        if(head==null)
            return;
       /*
        奇数：fastPtr.next->head;
        偶数：fastPtr.next.next->head;
        */
        while (fastPtr.getNext()!=head&&fastPtr.getNext().getNext()!=head)
        {
            fastPtr=fastPtr.getNext().getNext();
            slowPtr=slowPtr.getNext();
        }
        //偶数个元素，fastPtr需要后移一次
        if(fastPtr.getNext().getNext()==head)
        {
            fastPtr=fastPtr.getNext();
        }
        head1=head;
        if(head.getNext()!=head)
        {
            head2=slowPtr.getNext();
        }
        fastPtr.setNext(slowPtr.getNext());
        slowPtr.setNext(head);
    }

    /**问题10：
     *   对于给定的k(k>0)，逆置链表中的包含K个结点的块
     *   输入：1，2，3，4，5，6，7，8，9，10
     *   输出：k=2; 2,1,4,3,6,5,8,7,10,9;
     *        K=3; 3,2,1,6,5,4,9,8,7,10;
     *        K=4; 4,3,2,1,8,7,6,5,9,10;
     *  算法分析：
     *     1）检查当前链表剩余部分是否还有k个结点
     *       a）有，则获取当前剩余的第k+1个结点的指针
     *       b)没有，则返回；
     *     2）你逆置前面的k个结点
     *     3）k个结点逆置后，将其最后一个结点的后继指针指向第k+1的
     *     4）当前位置移动打K+1个结点；
     *     5）跳转步骤1
     *     6）如果执行了逆置操作，那么第一块的第k-1个结点成为新的表头结点，
     *     否则返回原表头结点；
     */
    /**
     * 判断是否含有k个结点
     * @param head
     * @param k
     * @return
     */
      public boolean hasKnodes(ListNode head,int k){
          int i;
          for(i=0;head!=null&&(i<k);i++,head=head.getNext());
          if(i==k)
          {
              return true;
           }
           return  false;
      }

    /**
     * 返回链表的头结点
     * @param k
     * @param head
     * @return
     */
      ListNode GetKPlusOneThNode(int k,ListNode head)
      {
          ListNode kth;
          int i;
          if(head==null) return  head;
          for(i=0,kth=head;kth!=null&&(i<k);i++,kth=kth.getNext());
          if(i==k&&kth!=null)
          {
              return kth;
          }
          return head.getNext();
      }

    /**
     * 判断+获取+逆置
     * @param head
     * @param k
     * @return
     */
      ListNode ReverseBlockOfK_nodesInLinkedList(ListNode head,int k){
          ListNode temp,next,cur=head,newHead;
          if(k==0||k==1)
          {
              return  head;
          }
            if(hasKnodes(cur,k-1))
            {
                newHead=GetKPlusOneThNode(k-1,cur);
            }else
            {
                newHead=head;
            }

            while (cur!=null&&hasKnodes(cur,k))
            {
                temp=GetKPlusOneThNode(k,cur);
                int i=0;
                while (i<k){
                    next=cur.getNext();
                    cur.setNext(temp);
                    temp=cur;
                    cur=next;
                    i++;
                }
            }
          return newHead;
      }
}

