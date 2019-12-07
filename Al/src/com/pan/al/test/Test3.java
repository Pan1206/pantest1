package com.pan.al.test;

public class Test3 {


    public static void flatten(TreeNode root) {

        rest(root);
    }

    public static TreeNode rest(TreeNode root)
    {    TreeNode  last=null;
        if(root==null) return null;
        if(root.left==null &&root.right==null)
        {
            last=root;
            return last;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        TreeNode left_last=null;
        TreeNode right_last=null;
        if(left!=null)
        {
            left_last=rest(left);
            root.left=null;
            root.right=left;
            last=left_last;
            //System.out.println(left_last.val);
        }
        if(right!=null)
        {
            right_last=rest(right);
            if(left_last!=null)
            {
                left_last.right=right;
            }
            last=right_last;

        }
         return last;
    }


    public static void main(String[] args) {
//        TreeNode a=new TreeNode(1);
//        TreeNode b=new TreeNode(2);
//        TreeNode c=new TreeNode(3);
//        TreeNode d=new TreeNode(4);
//        TreeNode e=new TreeNode(5);
//        TreeNode f=new TreeNode(6);
//        a.left=b;a.right=e;
//        b.left=c;b.right=d;
//        e.right=f;
//
//        flatten(a);
//        while(a!=null)
//        {
//            System.out.println(a.val);
//            a=a.right;
//        }


    }
}
