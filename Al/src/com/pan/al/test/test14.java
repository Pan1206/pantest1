package com.pan.al.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class test14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] strs=sc.nextLine().split(",");
        int N=Integer.valueOf(strs[0]);
        int M=Integer.valueOf(strs[1]);
        String strs1=sc.nextLine().replace("[","");
        strs1=strs1.replace("]","");
        strs1=strs1.replace(","," ");
        String[] strs2=strs1.split(" ");
        System.out.println(strs1);
        ArrayList<ArrayList<String>> list=new ArrayList<>();
        ArrayList<String> list1=new ArrayList<>();
        list1.add(strs2[0]);
        list1.add(strs2[1]);
        list.add(list1);
        int j=2;
        while (M-->0) {
            int arr=list.size();
            for (int i = 0; i < arr; i++) {
                ArrayList<String> temp = list.get(i);
                if(j+1>strs2.length-1)
                    continue;
                if (temp.contains(strs2[j]) || temp.contains(strs2[j + 1])) {
                    if (!temp.contains(strs2[j]))
                        list.get(i).add(strs2[j]);
                    if (!temp.contains(strs2[j + 1]))
                        list.get(i).add(strs2[j + 1]);
                } else {
                    ArrayList<String> temp1 = new ArrayList<>();
                    temp1.add(strs2[j]);
                    temp1.add(strs2[j + 1]);
                    list.add(temp1);
                }
                j += 2;
            }
        }
        System.out.print(list);
        // String[] strs1=sc.nextLine().split();
        //String string2=sc.nextLine();


    }
}
