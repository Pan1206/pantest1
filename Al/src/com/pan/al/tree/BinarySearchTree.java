package com.pan.al.tree;

public class BinarySearchTree {

    /**
     * 问题16：在二叉搜索树中寻找元素；
     * @param root
     * @param data
     * @return
     * 递归,时间复杂度0（n）(最坏),空间O（n）
     */
    public BinarySearchTreeNode Find(BinarySearchTreeNode root,int data)
    {
        if(root==null) return null;
        if(data<root.getData())
           return Find(root.getLeft(),data);
        else if(data>root.getData())
            return Find(root.getRight(),data);
        return root;
    }
    //非递归，时间复杂度O(n),空间复杂度O(1)
    public  BinarySearchTreeNode FindNo(BinarySearchTreeNode root,int data)
    {
        if(root==null) return null;
        while (root!=null)
        {
            if(root.getData() == data)
            {
                return root;
            }
            else if (data<root.getData())
            {
                root=root.getRight();
            }
            else root=root.getLeft();
        }
        return null;
    }

    /**
     * 问题17：寻找最小元素
     *      最左边的节点为最小元素，它没有左子节点;
     * @param root
     * @return
     * 递归 时间复杂度0（n）(最坏),空间O（n）
     */
    public BinarySearchTreeNode FindMin(BinarySearchTreeNode root){
        if(root==null)
        {
            return null;
        }
        else if( root.getLeft()==null) return root;
        else{
            return  FindMin(root.getLeft());
        }
    }
    //非递归      时间复杂度O(n),空间复杂度O(1)

    public BinarySearchTreeNode FindMinNo(BinarySearchTreeNode root){
        if(root==null) return null;
        while (root.getLeft()!=null) root=root.getLeft();
        return root;

    }

    /**
     * 问题18：寻找最大元素
     * 最大元素在数的最右端，它没有右子节点；
     * @param root
     * @return
     * 递归 时间复杂度0（n）(最坏),空间O（n）
     */
    public BinarySearchTreeNode FindMax(BinarySearchTreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        else if( root.getRight()==null) return root;
        else{
            return  FindMax(root.getRight());
        }
    }

    //非递归      时间复杂度O(n),空间复杂度O(1)
    public BinarySearchTreeNode FindMaxNo(BinarySearchTreeNode root){
        if(root==null) return null;
        while (root.getRight()!=null) root=root.getRight();
        return root;

    }

    /**问题19
     * 在二叉搜索树中插入元素
     * 先用find函数找到插入该数据的位置
     * @param root
     * @param data
     * @return
     */
    public BinarySearchTreeNode Insert(BinarySearchTreeNode root,int data){
        if(root==null) {
            root=new BinarySearchTreeNode();
            if(root==null)
            {
                System.out.println("Memory Error");
                return null;
            }else{
                root.setData(data);
                root.setLeft(null);
                root.setRight(null);
            }
        }
        else{
            if(data>root.getData())
            {
                root.setLeft(Insert(root.getLeft(),data));
            }
            else if(data>root.getData())
            {
                root.setRight(Insert(root.getRight(),data));
            }
        }
        return  root;
    }

    /**
     * 问题20：在二叉搜索树中删除元素
     *  情况分析
     *   1）待删除元素为叶子结点吗，则返回空指针给其双亲结点；
     *   2）待删除的结点，有一个孩子结点，只需要将待删除的结点的孩子结点，返回给其双亲结点；
     *   3）待删除的结点有俩个孩子结点，通常的做法是从其左子树中找到最大的元素来代替这个结点的主键，然后在删除那个结点(现在为空)；
     *     左子树中最大元素没有右孩子;
     * @param root
     * @param data
     * @return
     */
    public BinarySearchTreeNode Delete(BinarySearchTreeNode root,int data)
    {
       BinarySearchTreeNode temp;
       if(root==null)
       {
           System.out.println("Element not there in tree");
       }
       else if(data<root.getData())
       {
           root.setLeft(Delete(root.getLeft(),data));
       }
       else if(data>root.getData())
       {
           root.setRight(Delete(root.getRight(),data));
       }
       else{ //找到该元素；
        if(root.getLeft()!=null&&root.getRight()!=null)
        {
            /*用左子树中的最大值代替*/
            temp=FindMax(root.getLeft());
            root.setData(temp.getData());
            root.setLeft(Delete(root.getLeft(),root.getData()));
        }
        else {
            //一个结点
            temp=root;
            if(root.getLeft()==null)
                root=root.getRight();
            if(root.getRight()==null)
                root=root.getLeft();
        }
       }
       return root;
    }

    /**
     * 问题21：已知二叉搜索树中指向俩个结点的指针，寻找它们之间最近的公共祖先（LCA）.假定这俩个结点都在这颗树中；
     *   思路：
     *   1）从根节点到底部的遍历，遇到a~b之间的值，就是它们的最近公共祖先结点；
     *    时间复杂度0（n）;
     * @param root
     * @param a
     * @param b
     * @return
     */
   public BinarySearchTreeNode FindCLA(BinarySearchTreeNode root,BinarySearchTreeNode a,BinarySearchTreeNode b)
   {
       while (true){
            if(a.getData()<root.getData()&&b.getData()>root.getData()||
                    a.getData()>root.getData()&&b.getData()<root.getData())
            {
                return root;
            }
            if(a.getData()<root.getData())
            {
                root=root.getLeft();
            }
            else{
                root=root.getRight();
            }
       }

   }

    /**
     * 问题22：给出算法，判断一个给定的二叉树是否为BST树；
     *   分析
     *   1）BST树，必须满足左比主小，右比主大的原则；
     *   2）对于每个结点，需要检查其左子树的最大值是否小于当前结点的值，且右子树中的最小值是否大于该结点的值；
     * @param root
     * @return 0false 1:true
     * 时间复杂度为O（n2）
     */
   public int IsBST(BinarySearchTreeNode root)
   {
       if(root==null)
       {
           return 1;
       }
       if(root.getLeft()!=null&&root.getData()<FindMaxNo(root.getLeft()).getData())
           return 0;
       if(root.getRight()!=null&&root.getData()>FindMinNo(root.getRight()).getData())
           return 0;
       if(IsBST(root.getLeft())==0||IsBST(root.getRight())==0)
           return 0;
       return 1;
   }

    /**
     * 问题22：降低时间复杂度的方法；
     * 关键在于实现一个实用的函数IsBSTUtil(BinarySearchTreeNode root,int min,int max),
     *   在遍历时，跟踪min和max值的变化，这样每个结点只需要计算一次。
     * @param root
     * @return
     */

    public boolean IsBSTUtil(BinarySearchTreeNode root,int min,int max)
    {
        if(root==null) return true;

         if(root.getData()<min||root.getData()>max)
         {
             return false;
         }
         return IsBSTUtil(root.getLeft(),min,root.getData()-1)&&
                 IsBSTUtil(root.getRight(),root.getData()+1,max);
    }
    //结点值的初始值范围；
    private int INT_MIN;
    private int INT_MAX;
   public boolean IsBST1(BinarySearchTreeNode root)
   {
       return IsBSTUtil(root,INT_MIN,INT_MAX);
   }

    /**
     * 二叉搜索树的中序遍历是递增序列，所以在遍历时，对每个结点，判断其值是否都大于其前面所访问结点的值；
     * @param root
     * @param prev
     * @return
     */
   public int IsBST2(BinarySearchTreeNode root,int prev)
   {
       if(root==null) return 1;
       if(IsBST2(root.getLeft(),prev)==0)
       {
           return 0;
       }
       if(root.getData()<prev)
       {
           return 0;
       }
       prev=root.getData();
       return  IsBST2(root.getRight(),prev);
   }



}
