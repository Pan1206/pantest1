package com.pan.al.tree;

import com.pan.al.queue.LLQueue;

import java.util.*;

/**
 * 二叉树遍历
 * 1)先，中，后序遍历的时间复杂度为O(n),空间复杂度为O(n);
 * 2）层级遍历时间复杂度为O(n),空间复杂度为O(n);
 *
 */

public class Order {

    /**
     * 先序遍历（主左右）
     * 递归和非递归的方式
     */
    /**
     * 先序访问的结果：1，2，4，5，3，6，7；
     * 递归方式
     * 递归过程中结点访问的顺序：1,2,4,4,4,2,5,5,5,2,1,3,6,6,6,3,7,7,7,3,1
     *
     * @param head（复用了头结点）
     */
    public static void preOrder(BinaryTreeNode head) {
        if (head == null) return;
        System.out.print(head.getData());
        preOrder(head.getLeft());
        preOrder(head.getRight());
    }

    /**
     * 非递归方式
     * 利用栈先进后出的特点来解决递归中的主结点后返回的性质
     * 算法分析
     * 1）先压入主结点；
     * 2)当栈不为空时，先弹出并打印，在判断当前弹出结点是否有右孩子，有压入，在判断有无左孩子，左压入;
     * 3)重复步骤2；
     *
     * @param head
     */
    public static void preOrderNoRecursive(BinaryTreeNode head) {
        if (head == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.getData() + " ");
            if (head.getRight() != null) {
                stack.push(head.getRight());
            }
            if (head.getLeft() != null) {
                stack.push(head.getLeft());
            }
        }
    }

    /**
     * 中序遍历（左主右）
     * 递归和非递归的方式
     **/
    /**
     * 中序遍历结果：4，2，5，1，6，3，7
     * 递归方式
     *
     * @param head
     */
    public void inOrder(BinaryTreeNode head) {
        if (head == null) return;
        inOrder(head.getLeft());
        System.out.print(head.getData());
        inOrder(head.getRight());

    }

    /**
     * 非递归的方法（左主右）
     * 算法分析
     * 1)从当前结点开始，一直压入当前的左孩子，一直为空；
     * 2）判断
     * a)当前结点为空，从栈中拿出一个结点来，并打印，当前（head此时为拿出来的结点）向右走；
     * b)当前结点不为空，压入栈，当前结点向左走；
     *
     * @param head（复用当前结点)
     */
    public void inOrderNoRecursive(BinaryTreeNode head) {
        if (head == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.getLeft();//当前向左走~
            } else {
                head = stack.pop();  //当前拿出~
                System.out.println(head.getData() + " ");
                head = head.getRight();//当前向右走~
            }
        }
    }

    /**
     * 后序遍历（左右中）
     * 遍历结果：4，5，2，6，7，3，1；
     * 递归和非递归方式
     */
    /**
     * 递归方式
     * @param head
     */
    public static void postOrder(BinaryTreeNode head) {
        if (head == null) return;
        postOrder(head.getLeft());
        postOrder(head.getRight());
        System.out.print(head.getData());
    }
    /**
     * 非递归方式
     * 后序遍历是左右中的顺序，而前序遍历是中左右的顺序，
     * 中左右--中右左--左右中；(用到了俩个栈来完成任务)
     *
     */
      public static  void postOrderNoRecursive(BinaryTreeNode head)
      {
          Stack<BinaryTreeNode> stack1=new Stack<>();
          Stack<BinaryTreeNode> stack2=new Stack<>();

          stack1.push(head);
          while (!stack1.isEmpty()){
              head=stack1.pop();
              stack2.push(head);
              if(head.getLeft()!=null)
              {
                  stack1.push(head.getLeft());
              }
              if(head.getRight()!=null){
                  stack1.push(head.getRight());
              }

              while (!stack2.isEmpty()){
                  System.out.println(stack2.pop().getData()+" ");
              }
          }
      }

    /**
     * 用一个栈来解决问题；
     * @param head
     */
    public static void postOrderNoRecursive1(BinaryTreeNode head){
          System.out.println("pos-order:");
          if(head!=null){
              Stack<BinaryTreeNode> stack=new Stack<>();
              stack.push(head);
              BinaryTreeNode c=null;
              while (!stack.isEmpty())
              {
                  c=stack.peek();
                  if(c.getLeft()!=null&&head!=c.getLeft()&&head!=c.getRight())
                  {
                      stack.push(c.getLeft());
                  } else if(c.getRight()!=null&&head!=null)
                  {
                      stack.push(c.getRight());
                  }else {
                      System.out.print(stack.pop().getData()+" ");
                      head=c;
                  }

              }
          }
          System.out.println();
      }

    /**
     * 层级遍历
     * 层级遍历的结果：1，2，3，4，5，6，7
     * 1）访问根节点
     * 2）在访问第l层时，将l+1层的结点按顺序保存在队列中
     * 3）进入下一层并访问该层的所有的结点；
     * 4）重复上述操作知道所有层都访问完；
     */

    public  void levelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue=new ArrayDeque<>();

        if(root==null)
        {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty())
        {
            temp=queue.remove();
            //处理当前结点
            System.out.println(temp.getData());
            if(temp.getLeft()!=null)
            {
                queue.add(temp.getLeft());
            }
            if(temp.getRight()!=null){
                queue.add(temp.getRight());
            }
            queue.clear();
        }
    }
}
