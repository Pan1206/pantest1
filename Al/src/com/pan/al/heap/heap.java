package com.pan.al.heap;

/**
 * 堆就是完全二叉树
 *   分类：①大根堆
 *          任何一颗子树的最大值都是子树的头部
 *        ②小根堆
 *
 */
public class heap {
    /**
     * 互换元素
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * 大根堆的建立，关键一步，
     * for(i)循环调用这个函数，就能建立大根堆
     *    建立大根堆的时间复杂度为O(N)
     * @param arr
     * @param index
     */
    public static void headInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){  //一旦子大于父就往上换
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    /**
     * 当大根堆中的数突然变小了，从这个变小的位置开始向下沉；
     *  0~heapSize上已经形成堆
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
       int left=index*2+1;
       while (left<heapSize)
       {   //获取左右最大值
           int largest=left+1<heapSize&&arr[left+1]>arr[left]
                   ?left+1
                   :left;
           //与父节点比较
           largest=arr[largest]>arr[index]?largest:index;
           if(largest==index) break;
           swap(arr,largest,index);
           index=largest;
           left=index*2+1;
       }

    }

    /*减堆操作，将大根堆的堆顶弹出，在将原来的变成大根堆
    /   先将堆顶与数组的最后一个数交换，在进行headify操作
    */

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void headSort(int[] arr){
        if(arr==null||arr.length>2)
        {
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            headInsert(arr,i); //创建大根堆
        }
        int heapSize=arr.length;
        swap(arr,0,--heapSize);// 交换堆顶和数组最后一个元素
        while (heapSize>0)
        {
            heapify(arr,0,--heapSize);
            swap(arr,0,--heapSize);
        }
    }
}
