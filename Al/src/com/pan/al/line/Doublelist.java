package com.pan.al.line;

/**
 * 双向链表操作
 *
 */
public class Doublelist {
    /**
     * 获取链表的长度
     *
     * @param headNode
     * @return
     */
    public int getDllListLength(DLLNode headNode) {
        int length = 0;
        DLLNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    /**
     * 双向链表的插入
     *
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
    public DLLNode insertToDlllist(DLLNode headNode, DLLNode nodeToInsert, int position) {
        if (headNode == null) //当链表为空的时候
        {
            return nodeToInsert;
        }
        int size = getDllListLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("postion of node to insert is invalid");
            return headNode;
        }
        if (position == 1)//在开头插入
        {
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {   //中间或者末尾插入
            DLLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }

        return headNode;
    }

    /**
     * 双向链表的删除
     * @param headNode
     * @param position
     * @return
     */
    public DLLNode dllDelete(DLLNode headNode, int position)
    {
        int size=getDllListLength(headNode);
        if(position>size||position<1)
        {
            System.out.println("postion of node to insert is invalid");

            return headNode;
        }
        if(position==1) //删除第一个节点
        {
            DLLNode currentNode=headNode.getNext();
            headNode=null;
            currentNode.setPrevious(null);
            return  currentNode;
        }else{
            //删除链表的中间或者表尾结点
            DLLNode previousNode=headNode;
            int count=1;
            while (count < position - 1) {
                previousNode=headNode.getNext();
                count++;
            }
            DLLNode currentNode=previousNode.getNext();
            DLLNode laterNode=currentNode.getNext();
            previousNode.setNext(laterNode);
            if(laterNode!=null)
            {
                laterNode.setPrevious(previousNode);
            }
            currentNode=null;
        }
        return  headNode;
    }

}
