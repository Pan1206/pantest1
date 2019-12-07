package com.pan.al.tree;

import java.util.concurrent.TimeoutException;

/**
 * 高度是指当前结点到叶子结点的最长路径；
 * 深度是指根结点到当前结点的最大路径；
 * 规定叶子结点的高度为0，空树的高度为-1；
 * 根结点的深度为-1；
 *
 * @param <T>
 */
public class AVLNode<T extends Comparable> {

    public AVLNode<T> left;
    public AVLNode<T> right;

    public T data;

    public int hight;

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int hight) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.hight = hight;
    }

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public AVLNode(T data) {
        this.data = data;
    }

    public AVLNode() {

    }
    /**
     * 计算高度
     * @param root
     * @return
     */
    public  int hight(AVLNode<T> root){
        if(root==null)
        {
            return -1;
        }
        else {
            return  root.getHight();
        }
    }
    /**
     * ①在结点X的左孩子结点的左子树中插入元素
     * 左左单旋转（LL） W变成x的根结点，x变成w的右子树；（需要右旋转）
     * @param X（为失衡点）
     * @return
     */
    private AVLNode<T> singleRotateLeft(AVLNode<T> X){
        //把w结点旋转为根节点；
        AVLNode<T> W=X.left;
        //同时w的右子树变成x的左子树；
        X.left=W.right;
        //x变成w的右子树；
        W.right=X;
        //重新计算x,w的高度
        X.hight=Math.max(hight(X.left),hight(X.right))+1;
        W.hight=Math.max(hight(W.left),X.hight)+1;

        return W;
    }

    /**
     * ②在结点x的右孩子结点的右子树中插入元素
     * 右右单旋转（RR）（需要左旋转）(x变成w的根节点，w变成x的左子树)
     * @param w（为失衡点）
     * @return
     */
    private AVLNode<T> singleRotateRight(AVLNode<T> w)
    {
         AVLNode<T> x=w.right;
         w.right=x.left;
         x.left=w;
        //重新计算x,w的高度
        w.hight=Math.max(hight(w.left),hight(w.right))+1;
        x.hight=Math.max(hight(x.left),w.hight)+1;
        return x;
    }

    /**
     * ③在结点X的左孩子结点的右子树中插入元素  (LR旋转）
     *    先对失衡点的左孩子进行左旋转
     *    再对失衡点进行右旋转
     * @param x
     * @return
     */
    private AVLNode<T> doubleRetateWithleft(AVLNode<T> x)
    {
      //w先进行rr旋转（左旋转）
        x.left=singleRotateRight(x.left);
        //在进行x的ll旋转（右旋转）
        return singleRotateLeft(x);
    }

    /**
     * ④在结点X的右孩子结点的左子树中插入元素
     * 右左旋转(RL旋转)
     *     先对失衡点的右孩子进行右旋转
     *     再对失衡点进行左旋转
     * @param x
     * @return
     */
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> x)
    {
        //先进行LL旋转
         x.right=singleRotateLeft(x.right);
        // 再进行RR旋转
        return singleRotateRight(x); }

    /**
     * 插入方法
     *    算法原理
     *    使用递归算法，根据值的大小查找到插入位置，然后进行插入，插入完成后，进行平衡判断，评估子树
     *    是否需要进行平衡修复，需要则利用上面的四种情况，最后重新计算插入结点路径上的高度；
     *
     */
    public AVLNode<T> insert(T data,AVLNode<T> p) {
        if (p == null) {
            p = new AVLNode<T>(data);
        } else if (data.compareTo(p.data) < 0) {//data<p，向左子树寻找插入位置；
            p.left = insert(data, p.left);
            //插入后计算子树的高度，等于2则需要重新恢复平衡，由于是左边插入，左子树的高度肯定大于等于右子树的高度
            if ((hight(p.left) - hight(p.right) == 2)) {
                //判断是插入点是左孩子还是右孩子，
                if (data.compareTo(p.left.data) > 0) {
                    p = singleRotateLeft(p);//进行ll旋转；
                } else {
                    p = doubleRetateWithleft(p);//进行lr旋转
                }

            }
        } else if (data.compareTo(p.data) > 0) {
            p.right = insert(data, p.right);
           if((hight(p.right)-hight(p.left)==2))
           {
               if(data.compareTo(p.right.data)<0)
               {
                   p=doubleRotateWithRight(p);//rl旋转
               }
               else {
                   p=singleRotateRight(p); //rr旋转
               }
           }
        }
        else{
            ;
        }
        //重新计算各个结点的高度
        p.hight=Math.max(hight(p.left),hight(p.right))+1;
       return p;
    }

    /**
     * 平衡二叉树的判定
     *    ①它是一个二叉搜索树
     *    ②对于任意的结点，其左子树的高度与其右子树的高度差最多不超多1
     * @param head
     * @return
     */
   public  boolean boolBalance(AVLNode<T> head){
        boolean[] res=new boolean[1];
       res[0]=true;
        getHight(head,1,res);
        return res[0];
   }

   public int getHight(AVLNode<T> head,int level,boolean[] res)
   {
       if(head==null) return level;

       int lH=getHight(head.left,level+1,res);
       if(!res[0])
           return level;
       int rH=getHight(head.right,level+1,res);
       if(!res[0])
           return level;
       if(Math.abs(lH-rH)>1)
       {
           res[0]=false;
       }
       return Math.max(lH,rH);
   }


    //判断是否是平衡二叉树

    public class ReturnData{
       public boolean isB;
       public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public ReturnData process(AVLNode<T> head){
       if(head==null)
       {
           return new ReturnData(true,0);
       }
       ReturnData leftData=process(head.left);

       if(!leftData.isB) return new ReturnData(false,0);

        ReturnData rightData=process(head.right);

        if(!rightData.isB) return new ReturnData(false,0);

        if(Math.abs(leftData.h-rightData.h)>1)
        {
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(leftData.h,rightData.h)+1);
    }




}
