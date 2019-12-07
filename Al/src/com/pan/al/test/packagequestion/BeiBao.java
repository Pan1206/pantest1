package com.pan.al.test.packagequestion;

import java.util.Scanner;

public class BeiBao {
    /**
     有 N 件物品和一个容量是 V的背包。每件物品只能使用一次。
     第 i件物品的体积是 vi，价值是 wi。求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     输出最大价值。
     *
     *
     *  方案一：动态规划
     *  f[i][j]表示只看前i个物品，总体积是j的情况下，总价值最大是多少
     *  result=max{f[0-n][0-V]}
     *
     *  不选i物品，f[i][j]=f[i-1][j];
     *  选i物品，f[i][j]=f[i-1][j-w[i]]+v[i];
     */
    public static void beibao011(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int N=1010;
        int[] values=new int[N];
        int[] weights=new int[N];

        int[][] dp=new int[N][N];
        int i=0;

        while (scanner.hasNext())
        {
            String[] a=scanner.nextLine().split(" ");
            weights[i]=Integer.valueOf(a[0]);
            values[i]=Integer.valueOf(a[1]);
            i++;
        }
        int num=Integer.valueOf(weights[0]);
        int weight=Integer.valueOf(values[0]);
        if(num<=0||weight<=0)
        {
            System.out.println(0);
            return;
        }
        dp[0][0]=0;

        for(int k=1;k<=num;k++)
        {
            for(int j=1;j<=weight;j++)
            {
                dp[k][j]=dp[k-1][j];
                if(j>=weights[k])
                    dp[k][j]=Math.max(dp[k][j],dp[k-1][j-weights[k]]+values[k]);
            }
        }
        int result=0;
        for(int n=0;n<=weight;n++) result=Math.max(result,dp[num][n]);
        System.out.println(result);
    }
    /**
       一维数组
     */


    public static void beibao012(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int N=1010;
        int[] values=new int[N];
        int[] weights=new int[N];


        int i=0;

        while (sc.hasNext())
        {
            String[] a=sc.nextLine().split(" ");
            weights[i]=Integer.valueOf(a[0]);
            values[i]=Integer.valueOf(a[1]);
            i++;
        }
        int[] f=new int[N];
        int num=Integer.valueOf(weights[0]);
        int weight=Integer.valueOf(values[0]);
        f[0]=0;
        for(i=0;i<=num;i++)
        {
            for(int j=0;j>weights[j];j++)
            {
                f[j]=Math.max(f[j],f[j-weights[i]]+values[i]);
            }
        }
        System.out.println(f[weight]);
    }


}
