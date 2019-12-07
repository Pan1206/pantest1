package com.pan.al.test;


import java.util.*;

public class test13 {
    /**
     * 最长无重复字符的最长子串
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int a=lengthOfMehtod(s);
        System.out.println(a);
    }

    public static int lengthOfMehtod(String str)
    {

        int max=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int start=0,end=0;end<str.length();end++)
        {
            char c=str.charAt(end);
            if(map.containsKey(c))
            {

                start=Math.max(map.get(c),start);
            }
            max=Math.max(max,end-start+1);
            map.put(c,end+1);
        }
        return max;
    }

    /**
     *  学校里有一个水房，水房里一共装有 m 个龙头可供同学们打开水，每个龙头每秒钟的供水量相等，均为 1。
     *  现在有 n 名同学准备接水，他们的初始接水顺序已经确定。将这些同学按接水顺序从 1到 n 编号，
     *  i 号同学的接水量为 wi。接水开始时，1 到 m 号同学各占一个水龙头，并同时打开水龙头接水。
     *  当其中某名同学 j 完成其接水量要求 wj后，下一名排队等候接水的同学 k马上接替 j 同学的位置开始接水。
     *  这个换人的过程是瞬间完成的，且没有任何水的浪费。即j 同学第 x 秒结束时完成接水，
     *  则 k 同学第 x+1 秒立刻开始接水。若当前接水人数 n’不足 m，则只有 n’个龙头供水，
     *  其它 m−n’个龙头关闭。
     *
     * 现在给出 n 名同学的接水量，按照上述接水规则，问所有同学都接完水需要多少秒。
     *
     *
     */
    static int[] demo=new int[120];
    static int ANSWER=0;
    public static void main2(String[] args) {
        int i=0;
        int j=0;
        int k=0;
        int x=0;
        long start=System.currentTimeMillis();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int T=scanner.nextInt();
            for (int t=0;t<T;t++)
            {
                int n=scanner.nextInt();
                int m=scanner.nextInt();
                for(i=1;i<=n;i++)
                {
                    x=scanner.nextInt();
                    for(k=1,j=2;j<=m;j++)

                        if(demo[j]<demo[k]) k=j;
                        demo[k]+=x;

                }
                for(k=demo[1],i=2;i<m;i++)
                    k=Math.max(k,demo[i]);
                ANSWER=k;

            }

        }
        long end=System.currentTimeMillis();
        System.out.println((end-start));

    }

    /**
     * 模拟接水的过程
     * @param args
     */
    public static void main5(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int now=m+1;
        int[] w=new int[10001];
        int time=0;
        w[0]=0;//存水的总量
        for(int i=1;i<=n;i++)
        {
            w[i]=scanner.nextInt();
            w[0]+=w[i];
        }
        while(w[0]!=0)
        {
            for(int i=1;i<=m;i++)
            {
                if(w[i]>0)//如果水还没接完，接水，同时水的总量减少
                {
                    w[i]--;
                    w[0]--;
                }
                if(w[i]==0)//如果这个人水接完了，下一个人排进来，同时清空
                {
                    w[i]=w[now];
                    w[now]=0;
                    if(now!=n)now++;//前面的if一定要写,不然接水的人就无穷无尽了
                }
            }
            time++;//时间+1
        }
        System.out.println(time);
    }
    /**
     *  根据分数给名字，前三名为金、银、铜，相同分数在前的为先
     * @param args
     */

    public static void main3(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] strs=s.split(" ");
        Map<Integer,ArrayList<Integer>> map2=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<String> listlast=new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            list.add(Integer.valueOf(strs[i]));
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2-o1;
            }
        });

        for(int i=0;i<list.size();i++)
        {   int temp=list.get(i);
            if(!map2.containsKey(temp))
            {
                ArrayList<Integer> list1=new ArrayList<>();
                list1.add(i+1);
                map2.put(temp,list1);
            }
            else
            {
              ArrayList<Integer> list1=map2.get(temp);
              list1.add(i+1);
              map2.put(temp,list1);
            }
        }
        String str="";

        for(int i=0;i<list.size();i++)
        {
           Integer temp=Integer.valueOf(strs[i]);
           ArrayList<Integer> list2=map2.get(temp);
           int j=0;
           while (j<list2.size())
           {
               if(list2.get(j)==1)
               {
                   str="金";

               }else if(list2.get(j)==2)
               {
                   str="银";
               }else if(list2.get(j)==3)
               {
                   str="铜";
               }else
               {
                   str=""+list2.get(j);
               }
               list2.remove(j);
               j++;
               listlast.add(str);
           }
        }

        System.out.println(listlast);
    }



    /**
     *  301 删除无效的括号
     */

    public static Set<String> set;

    static String input;

    static int maxLen=0;

    public static List<String> remove(String s)
    {
        set =new HashSet<>();
        input =s;
        remove(0,"",0,0);
        return new ArrayList<>(set);
    }

    private static void remove(int index,String val,int left,int right)
    {

        if(left<right)
            return;

        if(index==input.length())
        {
            if(left==right)
            {
                if(maxLen<val.length())
                {
                    maxLen=val.length();
                    set.clear();
                    set.add(val);
                }else if(maxLen==val.length())
                {
                    set.add(val);
                }
            }
            return;
        }
        char c=input.charAt(index);
        if(c=='(') {
            remove(index + 1, val, left, right);
            remove(index + 1, val + c, left + 1, right);
        }
        else if(c==')')
        {
            remove(index + 1, val, left, right);
            remove(index + 1, val + c, left, right+1);
        }else
        {
            remove(index + 1, val + c, left, right);
        }
    }

    public static void main4(String[] args){
        Scanner scanner=new Scanner(System.in);
        List<String> list=remove(scanner.nextLine());
        System.out.print("[");
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1)
            System.out.print("\""+list.get(i)+"\"");
            else{
                System.out.print("\""+list.get(i)+"\""+',');
            }
        }

        System.out.println("]");
    }



}
