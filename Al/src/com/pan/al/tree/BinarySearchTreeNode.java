package com.pan.al.tree;

/**
 * 二叉搜索树(BST)
 * 最坏情况下平均搜索的时间复杂度降低至O(logN);
 *
 * 1.性质：
 *    所有的左子树结点的元素小于根节点的数据；
 *    所有的右子树结点的元素大于根节点的数据；
 *    左右子树都必须是二叉搜索树；
 * 2.注意问题
 * 1）中序遍历二叉搜索树时，将得到一个有序表；
 * 2）当处理二叉搜索树中的问题时。首先处理左子树，然后根节点，最后是右子树，所以处理不同问题时仅取决于中间步骤；
 * 3）搜索一个元素中，如果左子树根结点的数据小于要搜索的元素值，则跳过它,所以二叉搜索树在搜索元素的时候，要么在左子树，要么在右子树；
 */
public class BinarySearchTreeNode {
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
}
