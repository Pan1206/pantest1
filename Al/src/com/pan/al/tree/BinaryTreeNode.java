package com.pan.al.tree;

public class BinaryTreeNode {

    private  int data;
    private  BinaryTreeNode left;
    private  BinaryTreeNode right;
    private  BinaryTreeNode parent;

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public BinaryTreeNode() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
    public BinaryTreeNode(int data){
        this.data=data;
    }
}
