package com.pan.al.search;

import java.util.Arrays;

/**
 * 查找定义：根据给定的某个值，在查找表中确定一个其关键字等于给定值的数据元素（或记录）
 *
 *                   静态查找表
 *
 */
public class search {
    /**
     * ①顺序查找 (Sequential Search) 又叫线性查找，
     * 是最基本的查找技术， 它的查找过程是:从表中第一个(或最后一个)记录开始，
     * 逐个进行记录的关键字和给定值比较，若某个记录的关键字和给定值相等，则查找成功，
     * 找到所查的记录;如果直到最后一个(或第一个)记录，其关键字和给定值比较都不等时，
     * 则表中没有所查的记录，查找不成功。
     *
     * @param a   数组
     * @param key 待查找关键字
     * @return 关键字下标
     */
    public static int sequentialSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }
    //改进，设置哨兵

    /**
     * 有哨兵顺序查找
     *
     * @param a   数组(下标为0存放哨兵元素)
     * @param key 待查询关键字
     * @return 关键字下标 返回0 则未找到
     */
    public static int sequentialSearch2(int[] a, int key) {
        int index = a.length - 1;
        a[0] = key;// 将下标为0的数组元素设置为哨兵
        while (a[index] != key) {
            index--;
        }
        return index;
    }

    /**
     ②折半查找(Binary Search)技术，又称为二分查找。
     它的前提是线性表中的记录必须是关键码有序(通常从小到大有序) ，
     线性表必须采用顺序存储。折半查找的基本思想是:在有序表中，取中间记录作为比较对象，
     若给定值与中间记录的关键字相等，则查找成功;若给定值小于中间记录的关键字，
     则在中间记录的左半区继续查找;若给定值大于中间记录的关键字，则在中间记录的右半区继续查找。
     不断重复上 述过程，直到查找成功，或所有查找区域无记录，查找失败为止。

     */
    /**
     * 迭代的二分查找算法
     * T(n)=T(n/2)+😀(1)  T(n)=O(logn)
     *
     * @param A
     * @param n
     * @param data
     * @return
     */
    public int BinarySearchIterative(int A[], int n, int data) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == data) {
                return mid;
            } else if (A[mid] > data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //递归版二分查找

    public int BinarySearchRecursive(int A[], int low, int high, int data) {
        int mid = low + (high + low) / 2;
        if (A[mid] == data) return mid;
        else if (A[mid] < data)
            return BinarySearchRecursive(A, mid + 1, high, data);
        else return BinarySearchRecursive(A, low, mid - 1, data);
    }

    /**
     * ③插值查找
     *   插值查找(Interpolation Search)是根据要查找的关键字 key
     *   与查找表中最大最小记录的关键字比较后的查找方法，其核心就在于插值的计算公式
     *   (key - a[low])/(a[high] - a[low])。
     *   应该说，从时间复杂度来看，它也是O(logn)，但对于表长较大，
     *   而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好得多
     *   反之， 数组中如果分布类似{0，1，2，2000，2001，.......,999998, 999999}
     *   这种极端不均匀的数据，用插值查找未必是很合适的选择
     *
     *   mid = low + ((key - a[low])/(a[high] - a[low]))(high - low);
     */

    /**
     * 插值查找
     *
     * @param a   数组
     * @param key 待查找关键字
     * @return 返回折半下标， -1表示不存在该关键字
     */
    public static int interpolationSearch(int[] a, int key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = a.length - 1;// 最大小标
        while (low < high) {
            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
            // mid = (high + low) / 2;// 折半下标
            if (key > a[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (key < a[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }

    /**
     * ④ 斐波那契查找
     * 利用最近查找长度的斐波那契数值来确定拆分点
     * 一个有序表的元素为n，且n正好是F(K)-1,才能用这个方法；
     * 生成指定长度的斐波数列
     *
     * @param length
     * @return
     */
    public static int[] makeFbArray(int length) {
        int[] array = null;
        if (length > 2) {
            array = new int[length];
            array[0] = 1;
            array[1] = 1;
            for (int i = 2; i < length; i++) {
                array[i] = array[i - 1] + array[i - 2];//后面的关键
            }
        }
        return array;
    }

    /**
     * 斐波那契查找(黄金分割原理)
     *       平均性能比折半查找好，但最坏情况的性能比折半查找差；
     * 这里得注意，如果n刚好等于F[k]-1,待查找数组刚好拆成F[k-1]和F[k-2]两部分，
     * 那万事大吉你好我好；然而大多数情况并不能尽人意，n会小于F[k]-1,
     * 这时候可以拆成完整F[k-1]和残疾的F[k-2]两部分，那怎么办呢？
     *
     * 聪明的前辈们早已想好了解决办法，对了，
     * 就是补齐，用最大的数来填充F[k-2]的残缺部分，
     * 如果查找的位置落到补齐的部分，那就可以确定要找的那个数就是最后一个最大的了。
     *、
     * @param a
     * @param key
     * @param fblength
     * @return
     */
    public static int fibonaciSearch(int[] a, int key, int fblength) {
        int low, mid, high, k;
        low = 0;
        high = a.length - 1;
        int f[] = makeFbArray(fblength);//构建斐波那契数列
        // 斐波那契数列下标
        k = 0;
        // 获取斐波那契分割值下标
        while (high > f[k] - 1)
            k++;
        // 利用Java工具类Arrays构造长度为f[k]的新数组并指向引用a
        a = Arrays.copyOf(a, f[k] - 1);
        // 对新数组后面多余的元素赋值最大的元素
        for (int i = a.length; i < f[k] - 1; i++) {
            a[i] = a[high];//当key是最大值时候，防止角标越界异常
        }
        while (low <= high) {
            int middle = low + f[k - 1] - 1;
            if (a[middle] > key) {
                high = middle - 1;
                k = k - 1;
            } else if (a[middle] < key) {
                low = middle + 1;
                k = k - 2;
            } else {
                if (middle <= high) {
                    return middle;// 若相等则说明mid即为查找到的位置 }
                } else {
                    return high;// middle的值已经大于hight,进入扩展数组的填充部分,即最后一个数就是要查找的数。
                }
            }
        }
        return -1;
    }

    /**
     * ⑤索引顺序表的查找（分块查找）
     *     在此方法中，除了表本身以外，还需要建立一个索引表
     *     对于每个子表建立一个索引项，其中包括俩项：
     *       1）关键字项（子表中最大的关键字）
     *       2）指针项（指向该子表中第一个记录在表中的位置）
     *    索引表按关键字有序，则表或者有序或者分块有序；
     *    所谓分块有序值得是第二个表中所有的记录的关键字均大于第一个子表中所有的关键字，以此类推；
     *
     *    所有分块查找过程需要俩步，先确定待查记录所在子表，然后在块中顺序查找
     *
     */
}
