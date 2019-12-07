package com.pan.al.tree;

import com.pan.al.queue.LLQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree1 {



    /**问题6：
     * 对于给定的俩棵树，判断它们的结构是否相同，如同相同返回true
     * @param root1
     * @param root2
     * @return
     */
    public boolean AreStructurullySame(BinaryTreeNode root1,BinaryTreeNode root2){
         //若俩棵树都为空
         if(root1==null&&root2==null){
             return  true;
         }
         if(root1==null||root2==null)
         {
             return  false;
         }
         //若都不为空，进行比较
         return ( root1.getData()==root2.getData()&&
                   AreStructurullySame(root1.getLeft(),root2.getLeft())&&
                 AreStructurullySame(root1.getRight(),root2.getRight())
                 );
    }

    /**
     * 问题7：求树的深度
     *
     * @param root
     * @return
     */
    public int maxDepthOfBinaryTree(BinaryTreeNode root)
        {
           int leftHight=0,rightHight=0;
            if(root==null) return 0;

           if(root.getRight()==null&&root.getLeft()==null){
               return 1;
           }
           leftHight=maxDepthOfBinaryTree(root.getLeft());
           rightHight=maxDepthOfBinaryTree(root.getRight());
           return  Math.max(leftHight,rightHight)+1;
        }

    /**问题8：
     * 二叉树的最大距离（二叉树的直径）
     * 二叉树中任意俩个节点都有且仅有一条路径，这个路径的长度叫做这个节点的距离
     * 其中最大的长度值称为二叉树的直径；
     * 解法一：把这个距离划分成3种情况；
     * 1）这俩个节点分别在根节点的左右子树上，他们的路径肯定经过根结点，他们肯定是根节点中最
     * 远的结点，距离=左子树的深度+右子树的深度
     * 2）这俩个结点都在左子树上；
     * 3）这俩个结点都在右子树上；
     * @param root
     * @return
     */
    public int maxDistanceOfTree(BinaryTreeNode root){
             if(root==null) return 0;
             int distance=maxDepthOfBinaryTree(root.getRight())+maxDepthOfBinaryTree(root.getLeft());
             int disLeft=maxDistanceOfTree(root.getLeft());
             int disRight=maxDistanceOfTree(root.getRight());

             return Math.max(Math.max(disLeft,disRight),distance);
        }

    /**
     * 方案二：把计算结点的深度和最大距离放到一次递归中，方案一是分别单独递归计算深度和最远距离
     *
     * @param root
     * @return
     *
     * 计算树结点的最大深度和最大距离
     *
     */
    public  int propertyNode(BinaryTreeNode root){
        if(root==null) return 0;
        int left=propertyNode(root.getLeft());
        int right=propertyNode(root.getRight());
        //节点的深度depth=左右子树的最大值+1；
        int distacnce=Math.max(left,right)+1;
        return Math.max(Math.max(left,right),left+right);
    }

    /**
     * 问题9;找出二叉树中同一层结点数据之和最大的层
     * @param root
     * @return
     */
    public int findLevelwithMaxSum(BinaryTreeNode root){
        BinaryTreeNode temp;
        int level=0,maxLevel=0;
        Queue<BinaryTreeNode> queue=new ArrayDeque<>();
        int currentSum=0,maxSum=0;
        if(root==null) return 0;
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()){
            temp=queue.remove();
            if (temp==null)
            {
                if(currentSum>maxSum)
                {
                    maxSum=currentSum;
                    maxLevel=level;
                }
                if(!queue.isEmpty())
                {
                    queue.offer(null);
                }
                level++;
            }else{
                currentSum+=temp.getData();
                if(temp.getLeft()!=null)
                {
                    queue.offer(temp.getLeft());
                }
                if(temp.getRight()!=null){
                    queue.offer(temp.getRight());
                }
            }
        }
        return maxLevel;
    }

    /**
     * 问题10：给出一个算法，判断是否存在路径的数据和等于给定值
     *  策略
     *  递归实现。
     *  在调用其孩子结点之前，先把sum值减去该结点的值，然后在运行中检查sun值是否为0;
     * @param node
     * @param sum
     * @return
     */
    public boolean hasPathSum(BinaryTreeNode node,int sum)
    {
        if(node==null)
        {
            return (sum==0);
        }
        else{
            int subSum=sum-node.getData();
            return (hasPathSum(node.getLeft(),subSum)||hasPathSum(node.getRight(),subSum));
        }
    }

    /**
     * 问题11：实现树的镜像；
     * @param root
     * @return
     */
    public BinaryTreeNode MirrorOfBinaryNode(BinaryTreeNode root){

        BinaryTreeNode temp;
        if(root!=null)
        {
            MirrorOfBinaryNode(root.getLeft());
            MirrorOfBinaryNode(root.getRight());
            temp=root.getLeft();
            root.setRight(root.getLeft());
            root.setLeft(temp);
        }
        return  root;

    }

    /**
     * 问题12：根据给定的中序遍历和前序遍历序列来构建二叉树
     *   考虑以下遍历序列
     *      中序：D B E A F C（左中右）
     *      前序：A B D E C F （中左右）
     *
     *    在前序序列中，最左边的元素是树的根节点，所以A是给定序列的根。通过在中序序列中找到‘A’，能够找到A左边的
     *    所有的元素，它们来自左子树，也能A右边的所有元素，它们来自右子树；
     *
     *    算法：BuildTree()
     *    1)从前序序列中取一个元素，将前序索引变量（preIndex）+1,用于选取下一次递归调用时的元素；
     *    2）根据选择元素的数据值，创建一个新的树结点（newNode）
     *    3）查找所选结点在中序序列中的索引，用变量inIndex标记
     *    4）调用BuildBinaryTree为inIndex之前的所有结点构建一颗子树，将其作为newNode结点的左子树；
     *    5）调用BuildBinaryTree为inIndex之后的所有结点构建一颗子树，将其作为newNode结点的右子树；
     *    6）返回newNode.
     */

    public BinaryTreeNode buildTree(int preOrder[],int inOrder[],int pre_start,int pre_end,int in_start,int in_end){

       if(pre_start>pre_end||in_start>in_end) return null;
       //获取前序遍历的第一个根结点
        BinaryTreeNode newNode=new BinaryTreeNode(preOrder[pre_start]);
        int flag=0;
        //在中序遍历中扎到根结点
        for(int i=in_start;i<in_end;i++)
        {
            if(preOrder[pre_start]==inOrder[i])
            {
                flag=i;
                break;
            }
        }
        //构建左子树
        newNode.setLeft(buildTree(preOrder,inOrder,pre_start+1,pre_start+flag-in_start,in_start,flag-1));

        //构建右子树
        newNode.setRight(buildTree(preOrder,inOrder,pre_start+flag-in_start+1,pre_end,flag+1,in_end));

        return newNode;
    }


    /**
     * 问题13：
     * 只要给定的序列中有中序序列，就可以唯一构建;
     */

     public  BinaryTreeNode bulidTree(int preOrder[],int inOrder[],int pre_end,int pre_start,int in_end,int in_start){

         int root_value=preOrder[pre_start];
         BinaryTreeNode root=new BinaryTreeNode(root_value);
         if(pre_start>pre_end||in_start>in_end) return null;
         //在中序遍历中找到根节点
         int flag=0;//根节点标志；
         boolean is_find_root=false;
         for(int i=in_start;i<=in_end;i++)
         {
             if(preOrder[pre_start]==inOrder[i])
             {
                 flag=i;
                 is_find_root=true;
                 break;
             }
         }
         //没有找到根节点，无法构建
         if(!is_find_root)
         {
             return null;
         }
         int left_length=flag-in_start;
         int left_preorder_end=pre_start+left_length;
         if(left_length>0)
         {
             root.setLeft(buildTree(preOrder,inOrder,pre_start+1,left_preorder_end,in_start,flag-1));
         }
         int right_preorder_start=left_preorder_end+1;
         int right_length=pre_end-right_preorder_start+1;
         if(right_length>0)
         {
             root.setRight(bulidTree(preOrder,inOrder,right_preorder_start,pre_end,flag+1,in_end));
         }
         return root;
     }

    /**
     * 问题14：找出二叉树中俩个结点最近的公共祖先
     * @param root
     * @param a
     * @param b
     * @return
     */
     public BinaryTreeNode LCA(BinaryTreeNode root,BinaryTreeNode a,BinaryTreeNode b){
         BinaryTreeNode left,right;
         if(root==null) return  root;
         if(root==a||root==b){
             return  root;
         }
         left=LCA(root.getLeft(),a,b);
         right=LCA(root.getRight(),a,b);
         if(left!=null&&right!=null)
         {
             return root;
         }
         else{
             return (left!=null?left:right);
         }
     }

    /**
     * 问题15：给定一个二叉树和其中的一个结点，如何找出中序遍历序列的下一个节点？树中的节点除了有左右节点还有指向父亲的节点
     *
     * 策略：中序遍历：左中右；
     *     1）如果一个节点有右子树，那么它的下一个节点就是它的右子树中最左子节点；
     *     2）如果一个节点没有右子树，如果节点是它父节点的左子树，那么它的下个节点就是它的父节点；
     *     3）如果一个节点没有右子树，如果节点是它父节点的右子树，那么就要沿着指向父节点的指针一直向上遍历，直到
     *        找到一个是它父节点的左子节点的节点。这个节点的父节点就是我们要找的节点；
     *
     * @param pNode
     * @return
     */
      public BinaryTreeNode getNext(BinaryTreeNode pNode)
      {
          if(pNode==null) return  null;
          BinaryTreeNode pNext=new BinaryTreeNode();
          if(pNode.getRight()!=null)
          {
              BinaryTreeNode pRight=pNode.getRight();
              while (pRight.getLeft()!=null)
                  pRight=pRight.getLeft();
              pNext=pRight;
          }
          else if(pNode.getParent()!=null) {
              BinaryTreeNode pCurrent = pNode;
              BinaryTreeNode pParent = pNode.getParent();
              while (pParent != null && pCurrent == pParent.getRight())
              {
                  pCurrent=pParent;
                  pParent=pParent.getParent();
              }
              pNext=pParent;
          }
          return pNext;
      }


}
