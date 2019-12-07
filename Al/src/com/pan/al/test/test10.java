package com.pan.al.test;

import java.util.*;

public class test10 {

    /**
     * 反转匹配括号内的字符串
     * @param expr
     * @return
     */
    public static String resolve1(String expr) {
        Stack<Character> stack=new Stack<>();
        int i=0;
        int count=0;
        StringBuilder temp=new StringBuilder();
        while (i<expr.length()){

            if(expr.charAt(i)!=')')
            {

                stack.add(expr.charAt(i));
            }
            else if (expr.charAt(i) == ')') {
                StringBuilder stringBuilder = new StringBuilder();
                if (stack.peek() != ')' && !stack.isEmpty()) {
                    while (stack.peek() != '(') {
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();
                    if (count == 0) {
                        stringBuilder.reverse();
                        stringBuilder = stringBuilder.append(temp);
                        count = 1;
                    } else {
                        stringBuilder = stringBuilder.append(temp);
                        stringBuilder.reverse();
                        count = 0;
                    }
                    temp = stringBuilder;
                }
            }
            i++;
        }
        if(!stack.isEmpty()) return "";
        return temp.reverse().toString();
    }

    public static String resolve(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int lenth = str.length();
        for(int i=0; i<lenth; i++) {
            if(str.charAt(i)==')') {
                for(int j=i; j>=0; j--) {
                    if(str.charAt(j)=='(') {
                        str = str.substring(0,j)+
                                stringBuffer.append(str.substring(j+1,i)).reverse()+
                                str.substring(i+1,str.length());
                        stringBuffer = stringBuffer.delete(0, i-j);
                        i = -1;
                        lenth=str.length();
                        break;
                    } else if(j==0 && str.charAt(j)!='(') {
                        return "";
                    }
                }
            }
        }
        for(int k=0; k<str.length(); k++) {
            if(str.charAt(k)=='(') {
                str = "";
            }
        }
        return str;
    }



    /**
     * 将中缀表达式转为后缀表达式，输入 a+b*c/d-a+f/b 输出 abc*d/+a-fb/+
     * 要求：语言不限；输入输出均为单个字符串；操作数用单个小写字母表示，操作符只需支持 +-*/
     //*按照四则运算顺序确定优先级，不包含括号
    public static void houzui(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String strs=sc.nextLine();

        if(strs.length()==0)
        {
            System.out.println("");
            return;
        }
        Stack<Character> st=new Stack<>();
        StringBuilder s=new StringBuilder();
        int i=0;
        while(i<strs.length())
        {
            if(strs.charAt(i)>='a'&&strs.charAt(i)<='z')
                s.append(strs.charAt(i++));
            else if(strs.charAt(i)=='+'||strs.charAt(i)=='-')
            {
                if(!st.empty())
                {
                    s.append(st.peek());
                    st.pop();
                }
                st.push(strs.charAt(i++));
            }
            else if(strs.charAt(i)=='*'||strs.charAt(i)=='/')
            {
                s.append(strs.charAt(++i));
                s.append(strs.charAt(i-1));
                i++;
            }
        }
        if(!st.empty())
        {
            s.append(st.peek());
            st.pop();
        }
        System.out.println(s);
    }

    /**
     * 把数组排成最小的数
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

    /**
     * 把数字翻译成字符串
     * @param s
     * @return
     */
    public static int getTranslationCount(String s) {
        int count=0;
        if(s==null||s.length()<1)
        {
            return 0;
        }
        int length=s.length();
        int[] nums=new int[length];
        for(int i=length-1;i>0;i--)
        {
            count=0;
            if(i<length-1)
                count=nums[i+1];
            else{
                count=1;
            }
            if(i<length-1)
            {
                int digit1=s.charAt(i)-'0';
                int digit2=s.charAt(i+1)-'0';
                int converted=digit1%10+digit2;
                if(converted>=10&&converted<=25)
                {
                    if(i<length-2)
                        count+=nums[i+2];
                    else
                        count+=1;
                }
            }
            nums[i]=count;
        }
        count=nums[0];
        return count;
    }

    /**
     * 以dp[i]表示从字符串i位开始到末尾，最大的翻译次数
     * @param s
     * @return
     */
    public static int getTranslationCount1(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        if(n==0)return 0;
        if(n==1)return 1;

        int[] dp = new int[n+1];
        dp[n-1] = 1;
        dp[n]=1;
        for(int i =n -2; i>=0;i--){
            dp[i]=dp[i+1];
            if(ch[i]=='1'||(ch[i]=='2'&&ch[i+1]<'6'))
                dp[i]+=dp[i+2];
        }
        return dp[0];
    }


}


