package com.pan.al.tree;

import com.pan.al.line.ListNode;
import jdk.nashorn.internal.ir.BinaryNode;

public class BinarySearchTree1 {
    /**
     * 问题23：将bst树状转化为双向链表
     */
    //方法一：利用二叉搜索树的中序遍历是有序排列的，所有可以在遍历的过程中修改指针变化
    private BinarySearchTreeNode prev=null;
    private BinarySearchTreeNode head=null;
    public BinarySearchTreeNode Convert(BinarySearchTreeNode root)
    {
        inVisit(root);
        return head;
    }
    public void inVisit(BinarySearchTreeNode root)
    {
        if(root==null) return;
        inVisit(root.getLeft());
        create(root);
        inVisit(root.getRight());
    }

    public void create(BinarySearchTreeNode treeNode)
    {
        treeNode.setLeft(prev);
        if(prev==null)
        {
            head=treeNode;
        }else{
            prev.setRight(treeNode);
        }
        prev=treeNode;
    }

    /**
     * 问题24：将有序的双向链表转化为BST
     *    寻找中间点，不断调节指针；
     *    时间复杂度2T(n/2)+O(n)=O(nlogn);
     * @return
     */
    class DLLNode{
        private DLLNode prev;
        private DLLNode next;
        private int data;

        public DLLNode getPrev() {
            return prev;
        }

        public void setPrev(DLLNode prev) {
            this.prev = prev;
        }

        public DLLNode getNext() {
            return next;
        }

        public void setNext(DLLNode next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
    public DLLNode DllToBalancedBST(DLLNode root)
    {
       DLLNode temp,p,q;
       if(root==null|| root.getNext()==null)
       {
           return root;
       }
       temp=getMiddle(root);
       p=root;
       while (p.getNext()!=temp)
       {
         p=p.getNext();
       }
       p.setNext(null);
       q=temp.getNext();
       temp.setNext(null);
       temp.setPrev(DllToBalancedBST(root));
       temp.setNext(DllToBalancedBST(q));
       return temp;
    }
    public  DLLNode getMiddle(DLLNode head)
    {
        DLLNode p1,p2;
        p1=p2=head;
        int i=0;
        while(p1.getNext()!=null) {
            if (i == 0)
            {
                p1=p1.getNext();
                i=1;
            }else if(i==1)
            {
                p1=p1.getNext();
                p2=p2.getNext();
                i=0;
            }
        }
        return  p2;
    }

    /**
     * 问题25：将有序数组转为BST;
     *   分析：
     *   Bst的根节点应该是数组中间元素，在每次迭代中，现在数组的中间元素作为子树的根节点；
     *   时间复杂度O(n),空间复杂度O(n),用于递归栈；
     * @param A
     * @param left
     * @param right
     * @return
     */
    public BinarySearchTreeNode buildBST(int[] A,int left,int right){
        BinarySearchTreeNode newNode=new BinarySearchTreeNode();
        if(left>right) return null;
        if(left==right)
        {
           newNode.setData(A[left]);
           newNode.setLeft(null);
           newNode.setRight(null);
        }
        else {
            int mid=left+(right-left)/2;
             newNode.setData(A[mid]);
             newNode.setLeft(buildBST(A,left,mid-1));
             newNode.setRight(buildBST(A,mid+1,right));
        }
        return newNode;

    }

    /**
     * 问题26：将单向有序链表转化为BST(自底而上)
     * @param list
     * @param start
     * @param end
     * @return
     */
    public BinarySearchTreeNode SortedListToBST(ListNode list,int start,int end){
       if(start>end)
       {
           return null;
       }
       int mid=start+(end-start)/2;
       BinarySearchTreeNode leftChild=SortedListToBST(list,start,mid-1);
       BinarySearchTreeNode parent=new BinarySearchTreeNode();
       parent.setData((Integer) list.getData());
       parent.setLeft(leftChild);
       list=list.getNext();
       parent.setRight(SortedListToBST(list,mid+1,end));
       return parent;
    }

    BinarySearchTreeNode SortedListToBst(ListNode list,int n){
        return SortedListToBST(list,0,n-1);
    }

    /**
     * 问题27：寻找bst中第k个小的元素；
     * @param root
     * @param k
     * @param count
     * @return
     */
    public BinarySearchTreeNode kthSmallestInBST(BinarySearchTreeNode root,int k,int count)
    {
        if(root==null) return null;
        kthSmallestInBST(root.getLeft(),k,count);
        if(++count==k)
        {
            return root;
        }
       return kthSmallestInBST(root.getRight(),k,count);
    }
}
