package com.pan.al.string;

public class StringAl {
    /**
     * 请实现一个函数，把字符串里的空格都替换成"%20",
     *           解析
     * 如果从头开始判断，那么每次都要向后平移一定的字符串，时间复杂度O(n^2)
     * 从后向前平移，时间复杂度O(n)（但是输入的字符串后面要保证有足够多的空余内存）
     *
     * @param strs
     * @param length
     */
    public void replaceBlank(char strs[],int length){
        if(strs==null||strs.length<=0)
        {
            return;
        }
        int originaLength=0;
        int numberOfBlack=0;
        int i=0;
        while (strs[i]!='0')
        {
            ++originaLength;
            if(strs[i]==' ')
            {
                ++numberOfBlack;
            }
            i++;
        }

        int newLength=originaLength+numberOfBlack*2;
        if(newLength> strs.length)
        {
            return;
        }
        int indexOfOriginal=originaLength;
        int indexOfNew=newLength;

        while (indexOfOriginal>=0&&indexOfNew>indexOfOriginal)
        {
            if(strs[indexOfOriginal]==' ')
            {
                strs[indexOfNew--]='0';
                strs[indexOfNew--]='2';
                strs[indexOfNew--]='0';
            }
            else{
                strs[indexOfNew--]=strs[indexOfOriginal];
            }
            --indexOfOriginal;

        }
    }







}
