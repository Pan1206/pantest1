package com.pan.al.line;

/**
 * 循环链表的操作
 */
public class CircularList {
    /**
     * 获取双向链表的长度
     * @param headNode
     * @return
     */
    public int getCircularListLength(CLLNode headNode){
        int length=0;
        CLLNode currentNode=headNode;

        while (currentNode!=null)
        {
            length++;
            currentNode=currentNode.getNext();
            if(currentNode==headNode)
            {
                break;
            }
        }
        return  length;
    }

    /**
     * 打印内容
     * @param headNode
     */
    public void printCircularListData(CLLNode headNode)
    {
       CLLNode cllNode=headNode;
       while (cllNode!=null)
       {
           System.out.print(cllNode.getData()+"->");
           cllNode=cllNode.getNext();
           if(cllNode==headNode) break;
       }

    }

    /**
     * 在链表表尾插入新节点
     * @param headNode
     * @param nodeToInsert
     */
    public  void InsertAtEndCll (CLLNode headNode, CLLNode nodeToInsert){
         CLLNode currentNode=headNode;
         while (currentNode.getNext()!=headNode)
         {
             currentNode.setNext(currentNode.getNext());
         }
         nodeToInsert.setNext(nodeToInsert);//让新结点先指向自己
         if(headNode==null)
         {
             headNode=nodeToInsert;
         }
          else{
             nodeToInsert.setNext(headNode);
             currentNode.setNext(nodeToInsert);
         }
    }

    /**
     * 在表头插入新结点
     * @param headNode
     * @param nodeToInsert
     */
   public void insertAtBeginInCll(CLLNode headNode,CLLNode nodeToInsert)
   {
       CLLNode currentNode=headNode;
       while (currentNode.getNext()!=headNode)
       {
           currentNode.setNext(currentNode.getNext());
       }
       nodeToInsert.setNext(nodeToInsert);
       if(headNode==null)
       {
           headNode=nodeToInsert;
       }
       else{
           nodeToInsert.setNext(headNode);
           currentNode.setNext(nodeToInsert);
           headNode=nodeToInsert;
       }
   }

    /**
     * 移除表尾的结点
     * @param headNode
     */
   public void DeleteLastNodeFromCll(CLLNode headNode){
       CLLNode temp=headNode;
       CLLNode currentNode=headNode;
       if(headNode==null)
       {
           System.out.println("list is empty");
           return;
       }
       while(currentNode.getNext()!=headNode)
       {
           temp=currentNode;
           currentNode=currentNode.getNext();
       }
       temp.setNext(headNode);
       currentNode=null;
       return;

   }

    /**
     * 移除链表第一个结点
     * @param headNode
     */
   public  void DeleteFrontNodeFromCll(CLLNode headNode)
   {
       CLLNode temp=headNode;
       CLLNode currentNode=headNode;
       if(headNode==null)
       {
           System.out.println("list is empty");
       }
       while (currentNode.getNext()!=headNode)
       {
           currentNode.setNext(currentNode.getNext());
       }
        currentNode.setNext(headNode.getNext());
        headNode=headNode.getNext();
        temp=null;
        return;
   }
}

