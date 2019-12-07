package com.pan.al.test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        //List<List<String>> lists=solveNQueens(4);
       // System.out.println(lists);

    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        int[][] mark=new int[n][n];
        char[][] localtion=new char[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                localtion[i][j]='.';
                mark[i][j]=0;
            }
        }
        generate(0,n,localtion,result,mark);

        return result;

    }

    public static void putDownTheQueen(int x,int y,int[][] mark)//更新mark
    {
        int dx[]={-1,1,0,0,-1,-1,1,1};
        int dy[]={0,0,-1,1,-1,1,-1,1};
        mark[x][y]=1;
        for(int i=0;i<mark.length;i++)
        {
            for(int j=0;j<8;j++)
            {
                int new_x=x+i*dx[j];
                int new_y=y+i*dy[j];
                if(new_x>=0 && new_x<mark.length && new_y>=0 && new_y< mark.length)
                {
                    mark[new_x][new_y]=1;
                }
            }
        }
    }

    public static void generate(int k,int n,char[][] localtion, List<List<String>> result,int[][] mark)
    {
        if(k==n)
        {
            List<String> list=new ArrayList<>();
            for(int i=0;i< n;i++)
            {
                String s=String.valueOf(localtion[i]);
                list.add(s);
            }
            result.add(list);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(mark[k][i]==0) {
                int[][] tempMark = mark;
                localtion[k][i] = 'Q';
                putDownTheQueen(k, i, mark);
                generate(k + 1, n, localtion, result, mark);
                mark = tempMark;
                localtion[k][i] = '.';
            }

        }
    }
}
