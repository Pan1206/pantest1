package com.pan.al.graph;
/**
 * 有向图的拓扑排序：
 * 拓扑排序是可以用图模拟的另一种操作，它可以用于表示一种情况，即某些项目或事件必须按特定的顺序排列或发生。
 * 有向图和无向图的区别是：有向图的边在邻接矩阵中只有一项。
 * 拓扑排序算法的思想虽然不寻常但是很简单，有两个步骤是必须的：
 * 1. 找到一个没有后继的顶点
 * 2. 从图中删除这个顶点，在列表的前面插入顶点的标记
 * 重复这两个步骤，直到所有顶点都从图中删除，这时，列表显示的顶点顺序就是拓扑排序的结果。
 * 删除顶点似乎是一个极端的步骤，但是它是算法的核心，如果第一个顶点不处理，算法就不能计算出要处理的第二个顶点。
 * 如果需要，可以再其他地方存储图的数据(顶点列表或者邻接矩阵)，然后在排序完成后恢复它们。
**/
public class TopoSort {
    private final int maxVertices=20;
    private Vertex vertexList[]; //存储顶点的数组
    private int  adjMatrix[][];//邻接矩阵，0表示没有边界，1表示有边界
    private int  vertexCount;  //顶点个数
    private char sortedArray[];//存储排过序的数据

    public TopoSort(){
        vertexList =new Vertex[maxVertices];
        adjMatrix=new int[maxVertices][maxVertices];
        vertexCount=0;
        for(int i=0;i<maxVertices;i++){
          for (int j=0;j<maxVertices;j++)
              adjMatrix[i][j]=0;
        }

        sortedArray=new char[maxVertices];
    }

    public void addVertex(char lab){
        vertexList[vertexCount++]=new Vertex(lab);
    }

    //有向图中，邻接矩阵中只有一项
    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /**
     * 获得没有前驱的点（入度为0的顶点）
     * @return
     */
    private int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < vertexCount; row++) {
              isEdge=false;
              for(int col=0;col<vertexCount;col++)
              {
                  if(adjMatrix[row][col]>0)
                  {
                      isEdge=true;
                      break;
                  }
              }
              if(!isEdge){
                  return row;
              }
        }

        return -1;
    }

    /**
     * 删除顶点
     * @param delVertex
     */
    private void deleteVertex(int delVertex){
        if(delVertex != vertexCount -1) {
            for(int i = delVertex; i < vertexCount-1; i++) { //delete from vertexArray
                vertexList[i] = vertexList[i+1];
            }
            //删除adjMat中相应的边
            for(int row = delVertex; row < vertexCount-1; row++) {//delete row from adjMat
                moveRowUp(row, vertexCount);
            }

            for(int col = delVertex; col <vertexCount-1; col++) {//delete column from adjMat
                moveColLeft(col, vertexCount-1);
            }
        }
        vertexCount--;
    }
   //删除一个顶点很简单，从vertexArray中删除，后面的顶点向前移动填补空位。
   //同样的，顶点的行列从邻接矩阵中删除，下面的行和右面的列移动来填补空位
    private void moveRowUp(int row,int length){
        for(int col=0;col<length;col++){
            adjMatrix[row][col]=adjMatrix[row+1][col];
        }
    }

    private void moveColLeft(int col,int length){
        for(int row=0;row<length;row++){
            adjMatrix[row][col]=adjMatrix[row][col+1];
        }
    }

    /**
     * 拓扑排序
     */
    public void poto(){
        int orig_nVerts = vertexCount; //记录有多少个顶点
        while(vertexCount > 0) {
            //返回没有后续顶点的顶点，如果不存在这样的顶点，返回-1；
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR:Graph has cycles");
                return;
            }
            //sortedArray中存储排过序的顶点（从尾开始存）
            sortedArray[vertexCount - 1] = vertexList[currentVertex].label;
            deleteVertex(currentVertex);//删除该顶点，便于下一次循环，寻找下一个没有后继顶点的顶点
        }
        System.out.println("Topologically sorted order:");
        for(int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i]);
        }
        System.out.println("");

    }
}
