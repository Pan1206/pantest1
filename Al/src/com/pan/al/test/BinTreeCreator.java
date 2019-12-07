package com.pan.al.test;

public class BinTreeCreator {
    //根据广义表创建二叉树
    public static BinTreeNode createBinTreeByGLists(String gLists, int nodeQuantity) {
        BinTreeNode rootNode = null;
        BinTreeNode currNode = null;

        BinTreeNode[] stack = new BinTreeNode[nodeQuantity];
        int top = -1;

        int flag = 0;
        final int START_LEFT_CHILD = 1, START_RIGHT_CHILD = 2;

        int index = 0;

        while (index < gLists.length()) {
            char c = gLists.charAt(index++);

            switch (c) {
                case '(':
                    flag = START_LEFT_CHILD;
                    stack[++top] = currNode;
                    break;
                case ',':
                    flag = START_RIGHT_CHILD;
                    break;
                case ')':
                    top--;
                    break;
                case ' ':
                    break;
                default:
                    currNode = new BinTreeNode(c);

                    if (rootNode == null) {
                        rootNode = currNode;
                    } else {
                        switch (flag) {
                            case START_LEFT_CHILD:
                                stack[top].setLeftChild(currNode);
                                break;
                            case START_RIGHT_CHILD:
                                stack[top].setRightChild(currNode);
                                break;
                        }
                    }
            }
        }

        return rootNode;
    }

    //前序遍历
    public static void preOrderTraverse(BinTreeNode node) {
        if (node != null) {
            System.out.print(node.getData());
            preOrderTraverse(node.getLeftChild());
            preOrderTraverse(node.getRightChild());
        }
    }

    //中序遍历
    public static void inOrderTraverse(BinTreeNode node) {
        if (node != null) {
            inOrderTraverse(node.getLeftChild());
            System.out.print(node.getData());
            inOrderTraverse(node.getRightChild());
        }
    }

    //后序遍历
    public static void postOrderTraverse(BinTreeNode node) {
        if (node != null) {
            postOrderTraverse(node.getLeftChild());
            postOrderTraverse(node.getRightChild());
            System.out.print(node.getData());
        }
    }

    public static void main(String[] args) {
        String gLists = "(A (B (C, D), E ( , F)) )";
        BinTreeNode rootNode = BinTreeCreator.createBinTreeByGLists(gLists, 6);

        System.out.print("pre order: ");
        BinTreeCreator.preOrderTraverse(rootNode);

        System.out.print(System.lineSeparator() + "in order: ");
        BinTreeCreator.inOrderTraverse(rootNode);

        System.out.print(System.lineSeparator() + "post order: ");
        BinTreeCreator.postOrderTraverse(rootNode);
    }
}

