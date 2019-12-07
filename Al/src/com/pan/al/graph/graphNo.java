package com.pan.al.graph;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 非递归版
 */

public class graphNo {
     private final int maxVertices=20;
     private Vertex vertexList[];
     private int adjMatrix[][];//邻接矩阵
     private int vertexCount;
     private Stack theStack;//用于bfs
    private Queue theQueue=new ArrayDeque();
   public graphNo(){
       this.vertexList=new Vertex[maxVertices];
       this.adjMatrix=new int[maxVertices][maxVertices];
       vertexCount=0;
       for(int y=0;y<maxVertices;y++)
       {
           for (int x=0;x<maxVertices;x++)
           {
               adjMatrix[x][y]=0;
           }

       }
       theStack=new Stack();
   }

   public void addVertex(char lab){
       vertexList[vertexCount++]=new Vertex(lab);
   }

   public void addEdge(int start,int end){
       adjMatrix[start][end]=1;
       adjMatrix[end][start]=1;
   }

   public void displayVertex(int v)
   {
       System.out.print(vertexList[v].label);
   }

   public int getAdjUnvisitedVertex(int v){
       for(int j=0;j<vertexCount;j++){
           if(adjMatrix[v][j]==1&&vertexList[j].visited==false)
               return j;
       }
       return -1;
   }
   //深度优先搜索
   public void dfs(){
       vertexList[0].visited=true;
       displayVertex(0);
       theStack.push(0);
       while (!theStack.isEmpty()){
           int v=getAdjUnvisitedVertex((int)theStack.peek());//下一个邻接点
           if(v==-1)
                theStack.pop();
           else
               vertexList[v].visited=true;
             displayVertex(v);
             theStack.push(v);
       }

       for(int j=0;j<vertexCount;j++){
           vertexList[j].visited=false;
       }
   }

    /**
     * 广度搜索遍历
     */
   public void bfs(){
       vertexList[0].visited=true;
       displayVertex(0);
       theQueue.add(0);
       int v2;
       while (theQueue.isEmpty()){
           int v1=(int)theQueue.remove();
           while ((v2=(int)getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].visited=true;
                displayVertex(v2);
                theQueue.add(v2);
           }
       }

       for(int j=0;j<vertexCount;j++){
           vertexList[j].visited=false;
       }
   }
}
