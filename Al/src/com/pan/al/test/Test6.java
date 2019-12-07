package com.pan.al.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Test6 {

    public static void main(String[] args){

        //Scanner scanner=new Scanner(System.in);
        //Integer n=Integer.valueOf(scanner.nextLine());
        //String expression=scanner.nextLine();
        //String[] chars=expression.split(" ");
        Integer n=6;
        String[] chars={"3","+","2","+","1","+","-4","*","-5","+","1"};
        int[] shu=new int[n];
        String[] fu=new String[n-1];
        int j=0;
        int k=0;
        for(int i=0;i<2*n-1;i++)
        {

            if(chars[i]=="/" || chars[i]=="-"||chars[i]=="+"||chars[i]=="*")
            {
                fu[j++]=chars[i];

            }else {
                shu[k++]=Integer.valueOf(chars[i]);
            }
        }

        String temp=fu[0];
        int count=1;
        int index=0;
        for (int i=1;i<fu.length;i++)
        {
            if(fu[i]==temp)
            {
                //index++;
                count++;
            }else{
                if(fu[i]!="/"&& fu[i]!="-")
                {
                    int[] arr=new int[count];
                    arr=Arrays.copyOfRange(shu,index,index+count);

                    Arrays.sort(arr);
                    int b=0;
                    for(k=index;(k<index+count)&&(index+count<=shu.length);k++)
                    {
                        System.out.print(arr[b]+" ");
                        shu[k]=arr[b++];

                    }
                    System.out.println("++++");
                }else{
                    int[] arr=new int[count-1];
                    arr=Arrays.copyOfRange(shu,index+1,index+count);
                    Arrays.sort(arr);

                    index=index-1;
                    int b=0;
                    for(k=index;(k<index+count)&&(index+count<=shu.length);k++)
                    {
                        System.out.print(arr[b]+" ");
                        shu[k]=arr[b++];
                    }
                    System.out.println("-----");
                }
                index=index+count;
                count=2;
                temp=fu[i];
              }
        }
        int a=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (a<fu.length)
        {
            stringBuilder.append(shu[a]);
            stringBuilder.append(fu[a]);
            a++;
        }
        stringBuilder.append(fu[n-1-1]);
        System.out.println(stringBuilder);
    }


}
