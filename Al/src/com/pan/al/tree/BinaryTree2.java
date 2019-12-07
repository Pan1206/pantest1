package com.pan.al.tree;

import com.sun.xml.internal.bind.v2.model.impl.BuiltinLeafInfoImpl;

import java.util.Stack;

public class BinaryTree2 {

    public void sawpStack(Stack stack1,Stack stack2)
    {
        Stack stack=new Stack();
        stack=stack1;
        stack1=stack2;
        stack2=stack1;
    }

    /**
     * 问题14：
     * z型打印二叉树；
     * @param root
     */
    public  void ZigTraversal(BinaryTreeNode root){
        Stack<BinaryTreeNode> currentStack=new Stack<>();
        Stack<BinaryTreeNode> nextStack=new Stack<>();
        BinaryTreeNode temp;
        int leftToRight=1;
        if(root==null) return;
        currentStack.push(root);
        while (!currentStack.isEmpty()){
            temp=currentStack.pop();
            if(temp!=null)
            {
                if(leftToRight==1)
                {
                    if(temp.getLeft()!=null)
                    {
                        nextStack.push(temp.getLeft());
                    }
                    if(temp.getRight()!=null)
                    {
                       nextStack.push(temp.getRight());
                    }
                }else{
                    if(temp.getRight()!=null)
                    {
                        nextStack.push(temp.getRight());
                    }
                    if(temp.getLeft()!=null)
                    {
                        nextStack.push(temp.getLeft());
                    }

                }
            }

            if(currentStack.isEmpty())
            {
                leftToRight=1-leftToRight;
                sawpStack(currentStack,nextStack);
            }

        }

    }


    /**
     * 问题15：假设一棵树，叶子节点用L表示，内部结点用I表示，同时假定每个结点只能有0或2个孩子结点，
     * 根据这颗树的前序序列，构建这颗树；
     *   策略：
     *   不论何时在输入序列中遇到L，都表明这是一个叶子结点，且在该结点可以结束某个特定的子树，在L结点（双亲结点的左孩子结点）后，
     *   接下来就是其兄弟结点。如果L是其双亲结点的有孩子结点，那么需要返回到上一层计算下一颗子树，
     * @param A
     * @param i
     * @return
     */
    public BinaryTreeNode BulidTreeFromPreOrder(char[] A,int i)
    {
        if(A==null)
        {
            return  null;
        }
        BinaryTreeNode newNode=new BinaryTreeNode();
        newNode.setData(A[i]);
        newNode.setLeft(null);
        newNode.setRight(null);
        if(A[i]=='L')
        {
            return newNode;  //到达一个叶子结点，返回；
        }
        i=i+1;
        newNode.setLeft(BulidTreeFromPreOrder(A,i)); //构建左子树
        i=i+1;
        newNode.setRight(BulidTreeFromPreOrder(A,i)); //构建右子树；

        return newNode;
    }
}
