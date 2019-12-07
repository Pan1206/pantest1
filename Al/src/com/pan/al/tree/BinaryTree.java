package com.pan.al.tree;

import com.pan.al.queue.LLQueue;

import java.util.*;

public class BinaryTree {
    /**
     * 问题1：给出查找二叉树中最大的元素的算法
     *  方法一：
     *  利用递归，分别找打左子树中的最大值和右子树中的
     *  最大元素，然后与根节点的值比较，3者中最大的值
     *  就是问题的解了；
     * @param root
     * @return
     */
    public int findMax(BinaryTreeNode root){
         int root_val,left,right,max=Integer.MIN_VALUE;
         if(root!=null)
         {
             root_val=root.getData();
             left=findMax(root.getLeft());
             right=findMax(root.getRight());
             //在3个值中找出最大值
             if(left>right)
                 max=left;
             else{
                 max=right;
             }
             if(root_val>max)
             {
                 max=root_val;
             }
             return max;
         }

        return 0;
    }

    /**
     * 方法二：非递归的方式
     *    利用层级遍历方法，在删除结点时观察其数据是不是最大值
     */

      public int findMaxUsingLevelOrder(BinaryTreeNode root) {
          BinaryTreeNode temp;
          int max = Integer.MIN_VALUE;
          Queue<BinaryTreeNode> queue = new ArrayDeque<>();
          queue.offer(root);
          while (!queue.isEmpty()) {
              temp = queue.remove();
              if (max < temp.getData()) {
                  max = temp.getData();
              }
              if (temp.getLeft() != null) {
                  queue.offer(temp.getLeft());
              }
              if (temp.getRight() != null) {
                  queue.offer(temp.getRight());
              }
          }
          queue.clear();
          return max;
      }

    /**
     * 问题2：实现删除树的算法
     *      为了删除树，需要遍历树的所结点；
     *      在删除双亲结点之前，应该先删除其孩子结点，所以可以使用
     *      后序遍历的方法，这么一来就不用去存储任何信息，其它方法
     *      也可以实现，但是需要额外的空间复杂度；
     *
     *      时间复杂度O(n),空间复杂度O(n);
     * @param root
     */
      public static  void deleteBinaryTree(BinaryTreeNode root){
          if(root==null) return;
          deleteBinaryTree(root.getLeft());
          deleteBinaryTree(root.getRight());
          //仅当子树删除后再删除当前结点
          root=null;
      }

    /**
     * 问题3：
     *  逆向逐层输出树中的元素
     *  如:4,5,6,7,2,3,1
     *  利用栈后进先出的特点，
     *  时间和空间复杂度为O(n);
     * @param root
     */
      public void levelOrderTravsersalInReverse(BinaryTreeNode root){
         Queue<BinaryTreeNode> queue=new ArrayDeque<>();
          Stack<BinaryTreeNode> stack=new Stack<>();
          BinaryTreeNode temp;
          queue.offer(root);
          if(root==null) return;
          while (!queue.isEmpty()){
              temp=queue.remove();
              if(temp.getRight()!=null)
              {
                  queue.offer(temp.getRight());
              }
              if(temp.getLeft()!=null)
              {
                  queue.offer(temp.getLeft());
              }
               stack.push(temp);
          }
          while (!stack.isEmpty()){
              System.out.println(stack.pop().getData());
          }
      }
    /**
     * 二叉树的深度定义为：从根节点到叶子结点依次经过的结点形成的一条路径
     * ，最长路径的长度是树的深度；
     * 树的高度定义为：从根结点到树中最深结点的路径的长度；
     *
     * （再同一颗树中，其深度和高度是相同的，但是各个结点的深度和高度是不同的）
     * 1）根节点为空，深度为0；
     * 2）如果左右结点都为空，则深度为1；
     * 3）递归思想，二叉树的深度：max(lefthight,righthight)+1
     */
    /**
     * 问题3：计算二叉树的深度的算法
     * 递归方式
     * @param root
     * @return
     */
     public  static int HeightOfBinaryTree(BinaryTreeNode root){
          int leftHeight=0,rihgtHeight=0;
          if(root==null) return 0;
          else{
              //计算每颗子树的深度
              leftHeight=HeightOfBinaryTree(root.getLeft());
              rihgtHeight=HeightOfBinaryTree(root.getRight());
              if(leftHeight>rihgtHeight)
                    return (leftHeight+1);
              else
                     return (rihgtHeight+1);
          }
     }

    /**
     * 问题3：计算二叉树的深度算法
     * 非递归的方式
     *    使用层次遍历算法。空指针为层次遍历结束的标志；
     *    时间和空间复杂度均为O(n);
     * @param root
     * @return
     */
     public static int findHeightOfBinaryTree(BinaryTreeNode root)
     {
         int level=1;
         Queue<BinaryTreeNode> queue=new ArrayDeque<>();
         if(root==null) return 0;
         queue.offer(root);
         queue.offer(null);
         while (!queue.isEmpty())
         {
             root=queue.remove();
             //当前层遍历结束
             if(root==null){
                 //为下一层添加一个标识
                 if(!queue.isEmpty()) {
                     queue.offer(null);
                     level++;
                 }
                 }else{
                     if(root.getLeft()!=null)
                     {
                         queue.add(root.getLeft());
                     }
                     if(root.getRight()!=null)
                     {
                         queue.add(root.getRight());
                     }
                 }

         }
         return level;
     }

    /**
     * 给出在二叉树中搜索某个元素的算法
     * 递归方式
     * @param root
     * @param data
     * @return
     */
     public boolean findInBinaryUsingRecursion(BinaryTreeNode root,int data){
         boolean temp;
         if(root==null) return  false;
         else{
             if(root.getData()==data)
             {
                 return true;
             }else{
                 temp=findInBinaryUsingRecursion(root.getLeft(),data);
                 if(temp!=true) return temp;
                  else {
                      return (findInBinaryUsingRecursion(root.getRight(),data));
                 }
             }
         }
     }
    /**
     * 问题4：也可以用非递归的方式判断，只要改写层次遍历，当获取当前结点后，先判断
     * 是否是要找的元素，在往下面进行遍历判断；
     */
    /**
     * 实现将一个元素插入二叉树中的算法
     *
     * @param root
     * @param data
     */
    public  void insertInBinaryTree(BinaryTreeNode root,int data){
       Queue<BinaryTreeNode> queue=new ArrayDeque<>();
       BinaryTreeNode temp;
       BinaryTreeNode newNode=new BinaryTreeNode(data);

       if(newNode==null)
       {
           System.out.println("Error");
           return;
       }
       if(root==null)
       {
           root=newNode;
           return;
       }
        queue.add(root);
       while (!queue.isEmpty()){
           temp=queue.remove();
           if(temp.getLeft()!=null)
           {
               queue.add(temp.getLeft());
           }else {
               temp.setLeft(newNode);
               queue.clear();
               return;
           }

           if(temp.getRight()!=null){
               queue.add(temp.getLeft());
           }else {
               temp.setLeft(newNode);
               queue.clear();
               return;
           }
       }
       queue.clear();
    }

    /**问题5：
     * 用非递归的方法获取二叉树中叶子结点的个数；
     * 时间和空间复杂度均为O(n);
     * @param root
     * @return
     */
    public int NumberOfLeavesInBTusingLevelOrder(BinaryTreeNode root){
        int count=0;
        Queue<BinaryTreeNode> queue=new ArrayDeque<>();
        BinaryTreeNode temp=null;
        if(root==null)
        {
            return 0;
        }
          queue.add(root);
        while (!queue.isEmpty()){
               temp=queue.remove();
              if(temp.getRight()==null&&temp.getLeft()==null)
              {
                  count++;
              }
              else {
                  if(temp.getLeft()!=null)
                  {
                      queue.add(temp.getLeft());
                  }
                  if(temp.getRight()!=null)
                  {
                      queue.add(temp.getRight());
                  }

              }
        }
        queue.clear();
        return  count;
    }




}
