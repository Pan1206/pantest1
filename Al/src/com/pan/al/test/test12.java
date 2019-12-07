package com.pan.al.test;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

public class test12 {
    /**
     * leetcode 655 输出二叉树
     * @param root
     * @return
     */
    public static List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(1);
        }
        int depth = getDepth(root);
        int width = (int)(Math.pow(2, depth) - 1);
        width = width > 0 ? width : 1;
        String[][] result = new String[depth][width];
        List<List<String>> res = new LinkedList<>();
        fill(result, 0, 0, width - 1, root);
        for (int i = 0; i < result.length; i++) {
            LinkedList<String> linkedList = new LinkedList<>();
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == null) {
                    linkedList.add("");
                } else {
                    linkedList.add(result[i][j]);
                }
            }
            res.add(linkedList);
        }
        return res;
    }

    public static void fill(String[][] ints, int depth, int start, int end, TreeNode node) {
        if (node == null) {
            return;
        }
        int mid = (start + end) / 2;
        ints[depth][mid] = String.valueOf(node.val);
        fill(ints, depth + 1, start, mid - 1, node.left);
        fill(ints, depth + 1, mid + 1, end, node.right);
    }

    public static int  getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        return right > left ? right : left;
    }

    /**
     *  leetcode 17 电话号码的数字组合
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        int length=digits.length();
        String[] s=new String[length];
        if(length==0)
            return list;
        for(int i=0;i<length;i++)
        {
            switch(digits.charAt(i)){
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        getStringWith(s,0,list,"");
        return list;

    }

    public static void getStringWith(String[] str,int index,List<String> list,String temp)
    {

        if(index==(str.length-1))
        {
            for(int i=0;i<str[index].length();i++)
            {
                list.add(temp+str[index].charAt(i));
            }
        }
        else{
            for(int i=0;i<str[index].length();i++)
            {
                getStringWith(str,index+1,list,temp+str[index].charAt(i));
            }
        }
    }

    /**
     * 获得最多的奖金
     * @param args
     */
    public static void zuida(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
        String[] strs=sc.nextLine().split(" ");
        long[] nums=new long[len];
        for(int i=0;i<strs.length;i++)
        {
            nums[i]=Long.valueOf(strs[i]);
        }

        if(len!=nums.length)
        {
            System.out.println(0);
            return;

        }


        int left=0;
        int right=len-1;
        long  leftmax=nums[0];
        long rightmax=nums[len-1];
        long max=0;
        while (left<right)
        {

            if(leftmax<rightmax)
            {
                left++;
                leftmax+=nums[left];
            }else if(leftmax>rightmax)
            {
                right--;
                rightmax+=nums[right];
            }else
            {
                max=leftmax;
                leftmax+=nums[++left];
                rightmax+=nums[--right];
            }



        }
        System.out.println(max);
    }
    /**
     * 已知深渊有N层台阶构成（1 <= N <= 1000)，并且每次月神仅可往上爬2的整数次幂个台阶(1、2、4、....)，请你编程告诉月神，月神有多少种方法爬出深渊
     * @param n
     * @return
     */
     final static int MOD = 1000000003;
    public static void shenyuan(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int len=Integer.valueOf(sc.nextLine());
        int[] nums=new int[len];
        int i=0;
        int max=0;
        while(i<len)
        {
            int temp=Integer.valueOf(sc.nextLine());
            if(max<temp) max=temp;
            nums[i++]=temp;
        }

        int[] dp = jump(max);
        for (int j = 0;  j< nums.length; j++) {
            System.out.println(dp[nums[j]]);
        }



    }


    public static int[] jump(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j *= 2) {
                dp[i] += dp[i - j];
                 dp[i] = dp[i] % MOD;
            }
        }
        return dp;
    }

    /**
     *  考虑你从家出发步行去往一处目的地，该目的地恰好离你整数单位步长（大于等于1）。你只能朝向该目的地或者背向该目的地行走，
     *  而你行走的必须为单位步长的整数倍，且要求你第N次行走必须走N步。
     * 请就给出目的地离你距离，判断你是否可以在有限步内到达该目的地。如果可以到达的话，请计算到达目的地的最短总步数(不能到达则输出-1)
     * @param args
     */
    /*
            #思路，假定一直正向走，则每次都是S+=i，若一直正向走到不了目的地，则至少需要一次反向走，
            #假设第j次是反向走的，则总距离减去2*j，必定是个偶数，即不管有多少次反向走，减去的距离都是个偶数，
            #则只需要在一直正向走的基础上，找到第一个偶数能够等于正向走的总距离S减去T，即为最短路径
     */
    public static void bushu(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int target=Integer.valueOf(sc.nextLine());
        int sum=0;
        int step=1;
        int count=0;
        while(true)
        {
            sum+=step;
            if(sum==target)
            {
                count=step;
                break;
            }
            else if(sum>target&&(sum-target)%2==0)
            {
                count=step;
                break;
            }
            ++step;
        }

        System.out.println(count);

    }

    /**
     * 漂流船
     * @param args
     * @throws Exception
     */
    public static void piaoliuc(String[] args) throws Exception{
        Scanner bf =new Scanner(System.in);
        String ss=bf.nextLine();
        int limit =Integer.parseInt(bf.nextLine());
        String sarr[]=ss.split(" ");
        int people[]=new int [sarr.length];
        for(int i=0;i<people.length;i++) {
            people[i]=Integer.parseInt(sarr[i]);
        }
        int head=0;
        int count=0;
        int end=people.length-1;
        Arrays.sort(people);
        while(head<=end) {
            if((people[end]>limit)||(people[end]+people[head])>limit) {
                count++;
                end--;
            }else if((people[end]+people[head])<=limit) {
                count++;
                end--;
                head++;
            }
        }
        System.out.println(count);
    }


//    字符迷阵是一种经典的智力游戏。玩家需要在给定的矩形的字符迷阵中寻找特定的单词。
//    在这题的规则中，单词是如下规定的：
//            1. 在字符迷阵中选取一个字符作为单词的开头；
//            2. 选取右方、下方、或右下45度方向作为单词的延伸方向；
//            3. 以开头的字符，以选定的延伸方向，把连续得到的若干字符拼接在一起，则称为一个单词。
    public static void zimi(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            count = 0;
            String[] str = sc.nextLine().split(" ");
            int row = Integer.parseInt(str[0]), col = Integer.parseInt(str[1]);
            char[][] data = new char[row][col];
            for (int i = 0; i < row; i++) {
                data[i] = sc.nextLine().toCharArray();
            }
            char[] word = sc.nextLine().toCharArray();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    for (int k = 0; k <= 2; k++) {
                        dfs(data,word,i,j,0,k);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static int count = 0;

    public static void dfs(char[][] data, char[] word, int row, int col, int wordPos, int dir) {
        if (wordPos == word.length) {
            count++;
            return;
        }
        if (row == data.length || col == data[0].length) {
            return;
        }
        if (data[row][col] != word[wordPos]) {
            return;
        }
        if (dir == 0) { //向右
            dfs(data, word, row, col + 1, wordPos + 1, dir);
        } else if (dir == 1) { //向下
            dfs(data, word, row + 1, col, wordPos + 1, dir);
        } else if (dir == 2) { //向右下
            dfs(data, word, row + 1, col + 1, wordPos + 1, dir);
        }
    }

    public static void main1(String[] args) {
         Scanner sc=new Scanner(System.in);
         List<Integer> list=new ArrayList<>();
         while (sc.hasNext())
         {
             list.add(sc.nextInt());
         }
        System.out.println(lack(list));
    }

    private static Integer lack(List<Integer> source)
    {
       // Collections.sort(source);
        int n=source.size();
        int sum1=n*(n+1)/2;
        int sum2=0;
        for(Integer i:source)
        {
            sum2+=i;
        }
        return sum1-sum2;
    }

    /***
     * 查找字符串中最长的回文字符串
     * @param s
     * @return
     */
    private static String getResultString(String s)
    {
        char[] ch=s.toCharArray();
        String post="";
        String result="";
        for(int i=0;i<ch.length;i++)
        {
            post=getSubString(ch,i,i);
            if(post.length()>result.length())
                result=post;
        }

        for (int i=0;i<ch.length;i++)
        {
            post=getSubString(ch,i,i+1);
            if(post.length()>result.length())
                result=post;
        }
        return result;
    }

    private static  String getSubString(char[] ch,int i,int j)
    {

        while (i>=0&&j<=ch.length-1&&ch[i]==ch[j])
        {
            i--;j++;
        }
        return String.valueOf(ch).substring(i+1,j);

    }



       public static void  main2(String[] args)
     {
        Scanner sc=new Scanner(System.in);
        int num=Integer.valueOf(sc.nextLine());
        String[] strs=sc.nextLine().split(" ");
        int[] nums=new int[num];
        for(int i=0;i<num;i++)
        {
            nums[i]=Integer.valueOf(strs[i]);
        }
        int sum=0;
        for(int i=0;i<num;i++)
        {
            for(int j=i+1;j<num;j++)
            {
                if(nums[i]>nums[j]) sum=sum+Math.abs(i-j);
            }
        }
        System.out.println(sum);

    }

     public static void main3(String[] args) {
        Integer a=12344;
        String b="124";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        HashMap<String,Integer> map=new HashMap<>();
        map.put("ter",12);
        map.put("tert",123);
        HashMap<Integer,Integer> map1=new HashMap<>();
        TreeSet<String> s=new TreeSet<>();

        int h;
        String  key="tert";
        int hash=(14-1)&(h=key.hashCode())^(h>>>16);
        int hash1=key.hashCode()^Objects.hashCode(Integer.valueOf(123));

        System.out.println(hash);
        System.out.println(hash1);
        String str="good";

    }

     public static void main4(String[] args)
     {
        Scanner sc=new Scanner(System.in);

        List<Integer> list=new ArrayList<>();
        String strs=sc.nextLine().replace(',',' ');
        String[] arrs=strs.split("\\s+");
        arrs[0]=arrs[0].substring(1,arrs[0].length());
        arrs[arrs.length-1]=arrs[arrs.length-1].substring(0,arrs[arrs.length-1].length()-1);
        for(int i=0;i<arrs.length;i++)
        {
            list.add(Integer.valueOf(arrs[i].trim()));
        }

        List<Integer> list1=new ArrayList<>();
        for(int i=0;i<=list.size()-1;i++)
        {

            for(int j=i;j<=list.size()-1;j++)
            {

                if(list.get(i)<list.get(j))
                {
                    list1.add(j-i);
                    break;
                }
                if(list1.size()<i) list1.add(0);
            }

        }
        list1.add(0);
        System.out.println(list1);
    }
}
