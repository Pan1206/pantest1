package com.pan.al.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 最小生成树
 */
public class MinTree {
    /**
     * 普里姆算法，适用于边稠密的网
     * 时间复杂度 O(n2)
     * @param gr
     * @param ed
     */
    public static void Prim(AdjacencyGraph gr,EdgeElement[] ed){
        if(gr.getGraphType()!=1){
            System.out.println("gr不是一个连通网。不能求生成树，退出运行");
            System.exit(1);
        }
        int n=gr.getVertices();//取出图gr对象中的顶点个数的值赋给n
        int[][] a=gr.getArray();//取出gr对象中的邻接矩阵的引用
        for(int i=0;i<n-1;i++)
        {
            ed[i]=new EdgeElement(0,i+1,a[0][i+1]);
        }

        for(int k=1;k<n;k++)
        {
            //进行n-1次循环，每次求出最小生成树中的第k条边
            //从ed[k-1]~ed[k-2]中查找最短边ed[m];
            int min=gr.getMaxValue();
            int j,m=k-1;
            for(j=k-1;j<n-1;j++)
            {
                if(ed[j].weight<min){
                    min=ed[j].weight;
                    m=j;
                }
            }
            //把最短边对调到下标为k-1的元素位置
             EdgeElement temp=ed[k-1];
             ed[k-1]=ed[m];
             ed[m]=temp;
             //把新的并入最小生成树T的顶点序号付给j
             j=ed[k-1].endvex;

            //修改LW中的有关边，使T外的每个顶点各保持一条目前最短的边
            for(int i=k;i<n-1;i++)
            {
                  int t=ed[i].endvex;
                  int w=a[j][t];
                  if(w<ed[i].weight)
                {
                    ed[i].weight=w;
                    ed[i].fromvex=j;
                }
            }
        }
    }

    //克鲁斯卡尔算法
    public static void Kruskal(EdgeElement [] eg,EdgeElement [] ed,int n)
    {
        //利用克鲁斯卡尔算法求边集数组eg所表示图的最下生成树，结果存入ed中
        Set[]s=new HashSet[n];              //定义集合数组s，每个元素是一个集合对象
        for(int i=0;i<n;i++)                     //初始化s中的每个集合，并依次加入元素i
        {
            s[i]=new HashSet();
            s[i].add(i);                         //每个顶点分属于不同集合
        }
        int k=1;                                 //k表示将得到的最小生成树中的边数，初值为1
        int d=0;                                 //d表示eg中待扫描边元素的下标位置，初值为0
        while(k<n)                               //进行n-1次循环，每次得到的最小生成树中的第k条边
        {
            int m1=0,m2=0;                       //m1和m2记录一条边的两个顶点所在的集合元素
            for(int i=0;i<n;i++)                 //求边eg[d]的两个顶点所在集合
            {
                if(s[i].contains(eg[d].fromvex))
                {
                    m1=i;
                }
                if(s[i].contains(eg[d].endvex))
                {
                    m2=i;
                }
            }
            if(m1!=m2)                           //若两顶点属于不同集合，则eg[d]是生成树的一条边
            {
                ed[k-1]=eg[d];                   //将边eg[d]加入到边集数组ed中
                k++;
                s[m1].addAll(s[m2]);        //合并s[m1]和s[m2]集合到s[m1]中
                s[m2].clear();                   //将s[m2]置为一个空集
            }
            d++;                                 //d后移一个位置，以便扫描eg中的下一条边
        }
    }


}
