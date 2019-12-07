package com.pan.al.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    private int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(",");
            int[] num = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                num[i] = Integer.parseInt(str[i]);
            }
            int result = smallSum(num);
            System.out.println(result);
        }
        sc.close();
    }

    private static int smallSum(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        return mergeSort(num, 0, num.length - 1);
    }
    private static int mergeSort(int[] num, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        return mergeSort(num, L, mid) + mergeSort(num, mid + 1, R) + merge(num, L, mid, R);
    }

    private static int merge(int[] num, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int  res= 0;
        while (p1 <= mid && p2 <= r) {
            if (num[p1]>num[p2]){
                 //res=res+num[p1]*(r-p2+1);
                res=Math.abs(p1-p2);
                temp[i++] = num[p1++];
            }else {
                res = res+0;
                temp[i++] = num[p2++];
            }
        }
        while (p1 <= mid) {
            temp[i++] = num[p1++];
        }
        while (p2 <= r) {
            res=res+Math.abs(p1-p2);

            temp[i++] = num[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            num[l + j] = temp[j];
        }
        return res;
    }

}
