package com.pan.al.test;

    //二叉树节点结构
    public class BinTreeNode {
        private char data;
        private BinTreeNode leftChild;
        private BinTreeNode rightChild;

        public BinTreeNode(char data) {
            this.data = data;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public BinTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BinTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public BinTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BinTreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }








