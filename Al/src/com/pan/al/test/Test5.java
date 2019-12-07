package com.pan.al.test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigInteger;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class Test5 {
    /**  题目描述  反转数组
     给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。
     其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为

     a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，

     将片段[l,r]反序后的数组是

     a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]
     */
    public static void shengxu(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int len = scanner.nextInt();
            int[] array = new int[len];
            int[] copy = new int[len];
            for(int i=0;i<len;i++)
            {
                array[i] = scanner.nextInt();
                copy[i] = array[i];
            }
            Arrays.sort(copy);
            int left = 0,right = len-1;
            while(left<len && copy[left]==array[left]) left++;
            while(right>=0 && copy[right]==array[right]) right--;


            int i;
            for(i=0;i<=right-left;i++)
            {
                if(copy[left+i]!=array[right-i])
                    break;
            }
            if(i>right-left)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    /**
     * 题目描述  字符判断
     * 判断字符串b的所有字符是否都在字符串a中出现过，a、b都是可能包含汉字的字符串。b中重复出现的汉字，那么a中也要至少重复相同的次数。
     * 汉字使用gbk编码（简单的说，用两个字节表示一个汉字，高字节最高位为1的代表汉字，低字节最高位可以不为1）。
     *
     *         int is_include(char *a, char *b);
     *
     *   返回0表示没有都出现过，返回1表示都出现过。
     * @param args
     */
    public static void acontainb (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        HashMap<Character,Integer> aa=new HashMap<>();
        HashMap<Character,Integer> bb=new HashMap<>();
        String a=sc.nextLine();
        String b=sc.nextLine();
        sc.close();
        for(int i=0;i<a.length();i++)
        {
            if(aa.containsKey(a.charAt(i)))
            {
                aa.put(a.charAt(i),aa.get(a.charAt(i))+1);
            }else{
                aa.put(a.charAt(i),1);
            }
        }
        for(int i=0;i<b.length();i++)
        {
            if(bb.containsKey(b.charAt(i)))
            {
                bb.put(b.charAt(i),bb.get(b.charAt(i))+1);
            }else{
                bb.put(b.charAt(i),1);
            }
        }
        for(char s : bb.keySet())
            if( !aa.containsKey(s)||aa.get(s) < bb.get(s))
            {
                System.out.println(0);
                return;
            }
        System.out.println(1);
    }


    /**
     * 有股神吗？
     *
     * 有，小赛就是！
     *
     * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
     *
     * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
     * @param n
     * @return
     */
    public static int gusheng(int n)
    {

        int i = 0;// i统计遇到了多少次下跌
        int j = 2;// 每次下跌之后上涨的天数，包含已经下跌的那天
        int k = n;
        while (k > j) {
            i += 2;
            k -= j;
            ++j;
        }
        return n - i;
    }


}
