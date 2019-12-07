package com.pan.al.graph;

import java.util.ArrayList;
import java.util.List;

public class minlu {


    /**
     *  从一顶点到其余各顶点的最短路径 o(n2)
     * @param gr
     * @param i
     * @param dist
     * @param path
     */
    public static void Dijkstra(AdjacencyGraph gr,int i,int [] dist,List[] path)
    {
        //利用迪克斯特拉算法求图gr中从顶点i到其余各顶点的最短距离和最短路径
        //它们分别被保存在dist和path数组中
        int n=gr.getVertices();              //取出图gr对象中的顶点个数并赋给n
        if(i<0||i>n-1)
        {
            System.out.println("源点序号i的值不在有效范围内，退出运行！");
            System.exit(1);
        }
        int [][] a=gr.getArray();         //取出gr对象中邻接矩阵的引用
        boolean []s=new boolean[n];       //定义保存顶点集合的数组s
        //分别给s，dist和path数组赋初值
        for(int v=0;v<n;v++)
        {
            if(v==i)
            {
                s[v]=true;
            }
            else
            {
                s[v]=false;
            }
        }
        for(int v=0;v<n;v++)
        {
            dist[v]=a[i][v];
        }
        for(int v=0;v<n;v++)
        {
            path[v]=new ArrayList();
            if(a[i][v]!=gr.getMaxValue() && v!=i)
            {
                path[v].add(i,1);
                path[v].add(v, 2);
            }
        }
        //共进行n-2次循环，每次求出从源点i到终点m的最短路径及长度
        for(int k=1;k<=n-2;k++)
        {
            //求出第k次运算的终点m
            int w=gr.getMaxValue();
            int m=i;
            for(int j=0;j<n;j++)
            {
                if(s[j]==false && dist[j]<w)
                {
                    w=dist[j];
                    m=j;
                }
            }
            //若条件成立，则把顶点m并入集合数组s中，否则退出循环，因为剩余顶点
            //其最短路径长度均为MaxValue，无须再计算下去
            if(m!=i)
            {
                s[m]=true;
            }
            else
            {
                break;
            }
            //对s元素为false的对应dist和path中的元素作必要修改
            for(int j=0;j<n;j++)
            {
                if(s[j]==false && dist[m]+a[m][j]<dist[j])
                {
                    dist[j]=dist[m]+a[m][j];
                    path[j].clear();
                    for(int pos=1;pos<=path[m].size();pos++)
                    {
                        path[j].add((int)path[m].get(pos),pos);
                    }
                    path[j].add(j,path[j].size()+1);
                }
            }
        }

    }
}
