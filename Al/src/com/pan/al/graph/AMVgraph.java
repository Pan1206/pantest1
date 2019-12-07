package com.pan.al.graph;

import java.util.ArrayList;

/**
 * 图的遍历，有深度遍历DFS和广(宽)度遍历BFS,
 * 递归版
 */
public class AMVgraph {
    private ArrayList vertexList;//存储点的链表
    private int[][] edges;//邻接矩阵
    private int numOfEdges;//边的数目

    //初始化矩阵，一维数组和边的数目
     public AMVgraph(int n)
     {
         edges=new int[n][n];
         vertexList=new ArrayList(n);
         numOfEdges=0;
     }
     //得到结点的个数
     public int getNumOfVertex(){
         return  vertexList.size();
     }
     //得到边的数目
     public int getNumOfEdges(){
         return numOfEdges;
     }
     //返会结点i的数据
    public Object getValueByIndex(int i)
    {
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }
    //插入结点
    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    //插入结点
    public void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }

    //删除结点
    public void deleteEdge(int v1,int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }


    private void DFS(boolean[] isVisisted,int i){
         //首先访问该结点，并打印出来
         System.out.print(getValueByIndex(i)+" ");
         //置该结点为已访问的结点
        isVisisted[i]=true;
        int w=getFirstNeighbor(i);
        while (w!=-1){
            DFS(isVisisted,w);
        }
        w=getNextNeighbor(i,w);
    }

    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch(boolean[] isVisited) {
        for(int i=0;i<getNumOfVertex();i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                DFS(isVisited,i);
            }
        }
    }
}
