package com.pan.al.tree;

/**
 * 无需栈和队列就能遍历的算法；
 * 在空指针中存储前驱或后继节点信息的二叉树叫做线索二叉树；
 * 左空前驱，右空后继；
 * 哑结点；
 * 下面以中序为例
 */
public class ThreadBinaryTree {

    public ThreadBinaryTree left;
    public int lTag; //0:指向中序序列的左结点；//1：指向左孩子；
    public int data;
    public int rTag; //0:指向中序序列的右结点；//1：指向右孩子；
    public ThreadBinaryTree right;

    public ThreadBinaryTree getLeft() {
        return left;
    }

    public void setLeft(ThreadBinaryTree left) {
        this.left = left;
    }

    public int getlTag() {
        return lTag;
    }

    public void setlTag(int lTag) {
        this.lTag = lTag;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getrTag() {
        return rTag;
    }

    public void setrTag(int rTag) {
        this.rTag = rTag;
    }

    public ThreadBinaryTree getRight() {
        return right;
    }

    public void setRight(ThreadBinaryTree right) {
        this.right = right;
    }
}

