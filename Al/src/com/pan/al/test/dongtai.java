package com.pan.al.test;

import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class dongtai {
    /**
     * 牛家村的货币是一种很神奇的连续货币。
     *
     * 他们货币的最大面额是n，并且一共有面额为1，面额为2.....面额为n，n种面额的货币。
     *
     * 牛牛每次购买商品都会带上所有面额的货币，支付时会选择给出硬币数量最小的方案。
     *
     * 现在告诉你牛牛将要购买的商品的价格，你能算出牛牛支付的硬币数量吗？
     *
     * 6  7-->2
     * 4 10-->3
     * @param args
     */
    public static void yingbi2(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        //贪心，去面额最大的去凑
        int res = (m + n - 1) / n;
        System.out.println(res);

    }
    public static void yingbi1(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] f=new int[m+1];

        if(n>=m)
        {
            System.out.println(1);
            return;
        }else{
            int k=1;
            f[0]=0;
           while (k<=n)
           {
               f[k++]=1;
           }
        }


        for(int i=n+1;i<=m;i++)
        {
            f[i]=Integer.MAX_VALUE;
            for(int j=0;j<=n;j++)
            {
                if(i>=j&&f[i-j]!=Integer.MAX_VALUE)
                {
                    f[i]=Math.min(f[i-j]+1,f[i]);
                }
            }
        }
        System.out.println(f[m]);
    }
/**
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
*/
    public int rob(int[] nums) {

    //f[i]=min{f[i-1],f[i-2]+nums[i]}
     int len=nums.length;
     if(len==0) return 0;
     if(len==1) return nums[0];
     int[] f=new int[len+1];
     f[0]=nums[0];
     f[1]=Math.max(nums[0],nums[1]);
     for(int i=2;i<nums.length;i++)
     {
          f[i]=Math.max(f[i-2]+nums[i],f[i-1]);
     }

     return f[len-1];
  }
/**
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

   public int maxSubArray(int[] nums) {
     int len=nums.length;
     int[] f=new int[len+1];
     f[0]=nums[0];
     int max=nums[0];
     for(int i=1;i<len;i++)
     {
         f[i]=Math.max(f[i]+nums[i],nums[i]);
         if(max<f[i])
             max=f[i];
     }

     return max;
   }


    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点
     */

    public int minimumTotal(List<List<Integer>> triangle) {

        int lenX=triangle.size();
        int lenY=triangle.get(triangle.size()-1).size();
        int[][] dp=new int[lenX][lenY];
        for(int k=0;k<lenX;k++)
        {
            dp[k][lenY-1]=triangle.get(triangle.size()-1).get(k);
        }

        for (int i=lenX-2;i>=0;i--)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }

         return dp[0][0];
    }

    /**
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     */

    public int countDigitOne(int n) {
        if (n < 1)
            return 0;
        int len = getLenOfNum(n);
        if (len == 1)
            return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp; // 获取n的最高位数字
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp; // 获取n的最高位为1时有多少个数字
        int otherOneNUm = first * (len - 1) * (tmp / 10); // 在介于n % tmp到n之间的数字中，除了最高位为1，其余各个数字分别为1 的总数和
        return firstOneNum + otherOneNUm + countDigitOne(n % tmp);
    }
    private int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */

    public int lengthOfLIS1(int[] nums) {
        int len=nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp=new int[len];
        int max=0;
        boolean flag=true;
        Arrays.fill(dp,1);
        //将 dp 数组定义为：以0-i 中的最长上升子序列的长度
        //dp[i]=max(dp[i]+1,dp[i])
        for(int i=1;i<len;i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
           //错误，因为一旦出现不满足的条件，则会跳过这个点，max是之前最大的那个，但是接下去会重新创建新得字符串
//            if(nums[i]>nums[i-1])
//                dp[i]=dp[i-1]+1;
//            else
//                dp[i]=dp[i-1];
//            max=Math.max(dp[i],dp[i-1]);
        max=dp[0];
        for(int i=0;i<len;i++)
        {
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     * 贪心求解
     *   只有越前面的数最小，后面的元素约有可能形成更长的子序列
     *
     * @param nums
     * @return
     */

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return len;
        }

        int[] tail = new int[len];

        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]) {
                end++;
                tail[end] = nums[i];
            } else {
                int left = 0;
                int right = end;
                while (left < right) {

                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }

        }
        end++;
        return end;
    }




}
