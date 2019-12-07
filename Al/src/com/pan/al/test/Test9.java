package com.pan.al.test;

import java.util.*;



public class Test9 {

    /**
     * 新浪：比较版本号大小
     *
     * @param list
     * @return
     */
    public static String getMinVersion1(String[] list) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split("\\.");
                String[] s2 = o2.split("\\.");
                int i = 0, j = 0;
                for (; i < s1.length && j < s2.length; i++, j++) {
                    Integer c1 = Integer.valueOf(s1[i]);
                    Integer c2 = Integer.valueOf(s2[j]);
                    if (c1 > c2) return 1;
                    else if (c1 == c2) {
                        continue;
                    } else {
                        return -1;
                    }
                }
                if (i < s1.length) return 1;
                if (j < s2.length) return -1;
                return 0;
            }
        };
        Arrays.sort(list, comparator);


        return list[0];
    }

    public String getMinVersion(String[] list) {


        List list1 = Arrays.asList(list);
        Collections.min(list1);
        return (String) list1.get(0);
    }

    /**
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
     * 一个长整数。
     * 举例：一个ip地址为10.0.3.193
     * 每段数字             相对应的二进制数
     * 10                   00001010
     * 0                    00000000
     * 3                    00000011
     * 193                  11000001
     * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
     * <p>
     * <p>
     * <p>
     * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
     *
     * @param args
     */
    public static void iphu(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.nextLine();
            String p = in.nextLine();
            System.out.println(IptoTen(ip));

            TentoIp(p);

        }
    }

    private static void TentoIp(String p) {
        long temp = Long.parseLong(p);
        String ip = Long.toBinaryString(temp);
        StringBuilder sb = new StringBuilder();
        if (ip.length() < 32) {
            for (int i = 0; i < (32 - ip.length()); i++) {
                sb.append(0);
            }
            sb.append(ip);
        } else if (ip.length() == 32) {
            sb.append(ip);
        }

        for (int i = 0; i < sb.length() - 8; i = i + 8) {

            System.out.print(Integer.parseInt(sb.substring(i, i + 8), 2) + ".");
        }

        System.out.println(Integer.parseInt(sb.substring(sb.length() - 8, sb.length()), 2));

    }


    private static long IptoTen(String ip) {
        String[] arr = ip.split("\\.");
        long n = Long.parseLong(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            n = n << 8;
            n = n + Long.parseLong(arr[i]);
        }

        return n;
    }

    /**
     * 检查俩个子网是否属于同一个网络
     *
     * @param str
     * @return
     */
    private static long Ipsh(String str) {

        String[] arr = str.split("\\.");
        long[] ip = new long[arr.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            ip[i] = Long.parseLong(arr[i]);
            if (ip[i] > 255) return -1;
            String a = Long.toBinaryString(ip[i]);
            //转成8位二进制 利用String.format()控制格式
            String temp = String.format("%08d", Long.parseLong(a));
            sb.append(temp);
        }
        //System.out.println(sb.toString());
        //System.out.println(sb.length());
        long output = Long.parseLong(sb.toString(), 2);
        //System.out.println(output);
        return output;

    }

    public static boolean isLegalMask(int m) {
        String tmp = Integer.toBinaryString(~m + 1);
        boolean find = false;
        for (int i = 0, len = tmp.length(); i < len; i++) {
            if (tmp.charAt(i) == '1') {
                if (find == true)
                    return false;
                else find = true;
            }
        }
        return true;
    }

    public static void hushu(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int i = 1;

        long ziwang = Ipsh(s[0]);
        long a1 = Ipsh(s[1]);
        long a2 = Ipsh(s[2]);
//        System.out.println(ziwang);
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(ziwang&a1);
//        System.out.println(ziwang&a2);
        if (a1 == -1 | a1 == -1 | ziwang == -1) {
            System.out.println(1);
            return;
        }

        int flag = (ziwang & a1) == (ziwang & a2) ? 0 : 1;
        System.out.println(flag);
    }


    /**
     * 最小的k个数
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0) {
            return list;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.add(input[i]);
        }

        for (int j = k; j < input.length; j++) {
            if (queue.peek() > input[j]) {
                queue.poll();
                queue.add(input[j]);
            }
        }
        for (int m = 0; m < k; m++) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     * 定一个大小为n≤106的数组。
     * <p>
     * 有一个大小为k的滑动窗口，它从数组的最左边移动到最右边。
     * <p>
     * 您只能在窗口中看到k个数字。
     * 每次滑动窗口向右移动一个位置。
     * 以下是一个例子：
     * 该数组为[1 3 -1 -3 5 3 6 7]，k为3。
     * 窗口位置 	            最小值    最大值
     * [1 3 -1] -3 5 3 6 7 	 -1 	   3
     * 1 [3 -1 -3] 5 3 6 7 	 -3 	   3
     * 1 3 [-1 -3 5] 3 6 7 	 -3 	   5
     * 1 3 -1 [-3 5 3] 6 7 	 -3 	   5
     * 1 3 -1 -3 [5 3 6] 7 	 3 	       6
     * 1 3 -1 -3 5 [3 6 7] 	 3 	       7
     * <p>
     * 您的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
     *
     * @param args
     */

    public static void huadong1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[num];
        String[] strings = sc.nextLine().split(" ");
        int i = 0;
        while (i < num) {
            nums[i++] = sc.nextInt();
        }

        int min = nums[0];
        int max = nums[0];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);
        for (int j = 1; j < k; j++) {
            queue.add(nums[j]);
            if (nums[j] >= max) {
                max = nums[j];
            }
            if (nums[j] < min) {

                min = nums[j];
            }
        }

        ArrayList<Integer> minList = new ArrayList<>();
        minList.add(min);
        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(max);


        for (int n = k; n < num; n++) {
            queue.poll();
            queue.add(nums[n]);
            PriorityQueue<Integer> queue1 = new PriorityQueue<>();
            PriorityQueue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            queue1.addAll(queue);
            queue2.addAll(queue);
            minList.add(queue1.peek());
            maxList.add(queue2.peek());

        }

        System.out.println(minList);
        System.out.println(maxList);

    }

    //单调队列
    public static void huadong2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[num];
        int[] q = new int[num];
        String[] strings = sc.nextLine().split(" ");
        int j = 0;
        while (j < num) {
            nums[j++] = sc.nextInt();
        }


        int hh = 0, tt = -1;
        for (int i = 0; i < num; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] >= nums[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(nums[q[hh]] + " ");

        }
        System.out.println();

        hh = 0;
        tt = -1;
        for (int i = 0; i < num; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) hh++;
            while (hh <= tt && nums[q[tt]] <= nums[i]) tt--;
            q[++tt] = i;
            if (i >= k - 1) System.out.print(nums[q[hh]] + " ");
        }

    }

    /**
     *
     根据输入，输出查找到的兄弟单词的个数m
     然后输出查找到的兄弟单词的第k个单词。

     * @param args
     */
    public static void selcetBrother(String[] args) {
        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(null==o1||null==o2) return 0;
                char[] s1 = o1.toCharArray();
                char[] s2 = o2.toCharArray();
                int i = 0, j = 0;
                for (; i < s1.length && j < s2.length; i++, j++) {
                    int c1 = s1[i] - 'a';
                    int c2 = s2[i] - 'a';
                    if (c1 > c2) return 1;
                    else if (c1 == c2) {
                        continue;
                    } else {
                        return -1;
                    }
                }
                if (i < s1.length) return 1;
                if (j < s2.length) return -1;
                return 0;
            }
        };
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int num = Integer.valueOf(strings[0]);
        String[] strs = new String[num];
        int i = 0;
        int a = 1;
        while (i < num) {
            strs[i++] = strings[a++];
        }
        String brother = strings[strings.length - 2];
        int index = Integer.valueOf(strings[strings.length - 1]);

        int count = 0;//兄弟个数
        String[] brothers = new String[num];//存放兄弟单词
        for (int j = 0; i < num; i++) {
            brothers[j] = null;
        }

        if (num >= 0 && num <= 1000) {
            for (int n = 0; n < num; n++) {
                String curStr = strs[n];
                if (curStr.length() >= 1 && curStr.length() <= 50) {
                    if (isBrother1(brother, curStr)) {
                        brothers[count] = curStr;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

        if (index <= count && index > 0) {

            Arrays.sort(brothers, comparator1);
            System.out.println(brothers[index - 1]);
        } else {
            System.out.println(0);
        }
    }
    private static boolean isBrother1(String bother, String curStr) {
        if (bother.length() == curStr.length() && !curStr.equals(bother)) {
            char[] bro = bother.toCharArray();
            char[] cur = curStr.toCharArray();
            Arrays.sort(cur);
            return Arrays.equals(bro, cur);
        }
        return false;
    }
    private static boolean isBrother(String bother, String curStr) {
        if (bother.length() == curStr.length() && !curStr.equals(bother)) {
            int[] arr = new int[26];
            int n = 0;
            while (n < bother.length()) {
                arr[bother.charAt(n) - 'a']++;
                n++;
            }
            n = 0;
            while (n < curStr.length()) {
                arr[curStr.charAt(n) - 'a']--;
                n++;
            }
            for (n = 0; n < 26; n++) {
                if (arr[n] != 0)
                    return false;
            }
            return true;
        }

        return false;
    }
    public static void selcetBrother1(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            String[] s = new String[num];
            int count = 0;
            for(int i = 0;i<num;i++){
                s[i] = in.next();
            }
            String key = in.next();
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);
            int no = in.nextInt();//第几个
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0;i<num;i++){
                int c = check(key,s[i],keyChar);
                count += c;
                if(c==1)
                    list.add(s[i]);
            }
            System.out.println(count);
            Collections.sort(list);
            if(count>=no)
                System.out.println(list.get(no-1));
        }
    }
    private static int check(String key,String word,char[] keyChar){
        if(key.equals(word)||key.length()!=word.length())
            return 0;
        char[] wordChar = word.toCharArray();
        Arrays.sort(wordChar);
        return Arrays.equals(keyChar, wordChar)?1:0;
    }

    /**
     * 连续子数组的最大和
     * f[i]表示以i坐标为结尾的字符串数组的最大值
     * @param nums
     * @return
     */
    public static int  FindGreatestSumOfSubArray(int[] nums){
        int len=nums.length;
        int[] f=new int[len+1];
        f[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<len;i++)
        {
            f[i]=Math.max(f[i-1]+nums[i],nums[i]);
            if(max<f[i])
                max=f[i];
        }

        return max;
    }


    /**
     * 密码验证合格
     * 密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度超2的子串重复
     * 说明:长度超过2的子串
     * @param args
     */
    public static void mima(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            int i=0;
            int []cla={0,0,0,0};
            if(str.length()<9||str==null)
                System.out.println("NG");
            else{
                for(i=0;i<str.length();i++){
                    char ch=str.charAt(i);
                    if(ch>='0'&&ch<='9'){
                        cla[0]=1;
                    }else if(ch>='a'&&ch<='z'){
                        cla[1]=1;
                    }else if(ch>='A'&&ch<='Z'){
                        cla[2]=1;
                    }else{
                        cla[3]=1;
                    }
                }
                if(cla[0]+cla[1]+cla[2]+cla[3]<3){
                    System.out.println("NG");
                }else{
                    System.out.println(isHasSubString(str));
                }
            }
        }
    }
    private static String isHasSubString(String str) {
        for (int i = 0; i < str.length() -3; i++) {
            String str1=str.substring(i,i+3);
            String str2=str.substring(i+3, str.length());
            if(str2.contains(str1))
                return "NG";
        }
        return "OK";
    }

    public static void main1(String[] args)
    {
        System.out.println(Permutation("abc"));
    }
    /**
     * 字符串的排列
     * @param
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str != null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,res);
            //对字母进行排序
            Collections.sort(res);
        }
        return res;
    }
    public static void PermutationHelper(char[] cs ,int i,ArrayList list){
        if(i == cs.length-1){
            String val = String.valueOf(cs);
            if(!list.contains(val)){
                list.add(val);
                System.out.print(cs[0]+" "+cs[1]+" "+cs[2]+" "+i);
                System.out.println();
            }
        }else{
            for(int j=i;j<cs.length;++j){
                //交换
                swap(cs,i,j);
                //将指标向前移动一格，让下一格与后面的交换
                PermutationHelper(cs,i+1,list);
                //复位
                swap(cs,i,j);
            }
        }
    }
    public static void swap(char[] cs,int i,int j){
        char tmp = cs[i];
        cs[i]=cs[j];
        cs[j]=tmp;
    }






}