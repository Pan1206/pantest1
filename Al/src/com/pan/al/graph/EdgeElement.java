package com.pan.al.graph;

/**
 * 定义边集数组中的元素类型
 */
public class EdgeElement {
    public int fromvex;
    public int weight;
    public int endvex;
    //无权图进行初始化
    public EdgeElement(int v1,int v2)
    {
        this.fromvex=v1;
        this.endvex=v2;
        weight=1;
    }
    //对有权图进行初始化
    public EdgeElement(int fromvex,int endvex,int weight)
    {
        this.fromvex=fromvex;
        this.endvex=endvex;
        this.weight=weight;
    }
}
