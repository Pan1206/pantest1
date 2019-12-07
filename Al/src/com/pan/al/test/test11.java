package com.pan.al.test;

import java.util.*;

public class test11 {
    /**
     * 移动数组中任意一个元素，使得数组的元素按升序排列，求移动的最小次数
     *  【4，1，2，5，3】---2次
     * @param nums
     * @return
     */
   public static int find(int[] nums)
   {
       HashMap<Integer,Integer> hashMap=new HashMap<>();

       int max=0;
       for(int i:nums)
       {
           if(hashMap.containsKey(i-1))
           {
               hashMap.put(i,hashMap.get(i-1)+1);
           }else
           {
               hashMap.put(i,1);
           }
       }

       for (int i:hashMap.keySet())
       {
           if(max<hashMap.get(i))
           {
               max=hashMap.get(i);
           }
       }
       return nums.length-max;

   }


    /**
     *  平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
     *
     * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
     *
     * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
     */
    public class edge implements Comparable{
        Integer left;
        Integer right;
        Integer height;
        Integer value;
        edge(int left,int right,int height,int value){
            this.left=left;
            this.right=right;
            this.height=height;
            this.value=value;
        }
        @Override
        public int compareTo(Object o) {
            return Integer.compare(height,((edge)o).height);
        }
    }

    public  void chongdie(String[] args){
            ArrayList<Integer> xAxial=new ArrayList<Integer>();
            ArrayList<edge> allEdges=new ArrayList<>();
            Scanner in=new Scanner(System.in);

            int n=in.nextInt();
            int[] x1=new int[n];
            int[] x2=new int[n];
            int[] y1=new int[n];
            int[] y2=new int[n];
            for(int i=0;i<n;++i){
                x1[i]=in.nextInt();
                xAxial.add(x1[i]);
            }
            for(int i=0;i<n;++i){
                y1[i]=in.nextInt();
            }
            for(int i=0;i<n;++i){
                x2[i]=in.nextInt();
                xAxial.add(x2[i]);
            }
            for(int i=0;i<n;++i){
                y2[i]=in.nextInt();
            }
            for(int i=0;i<n;++i){
                allEdges.add(new edge(x1[i],x2[i],y1[i],1));
                allEdges.add(new edge(x1[i],x2[i],y2[i],-1));
            }
            Collections.sort(xAxial);
            Collections.sort(allEdges);
            ArrayList<Integer> count=new ArrayList<Integer>();
            for(int i=0;i!=xAxial.size()-1;++i)
                count.add(0);
            int result=1;
            for(edge tmp : allEdges){
                Integer index=xAxial.indexOf(tmp.left);
                while(xAxial.get(index)<tmp.right){
                    count.set(index,count.get(index)+tmp.value);
                    if(count.get(index)>result){
                        result=count.get(index);
                    }
                    ++index;
                }
            }

            System.out.println(result);
        }

    /**
     * leetcode290 单词匹配
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {

       if(pattern.length()<=0||pattern==null||str.length()<=0||str==null)
       {
           return false;
       }
       String[] strs=str.split(" ");
       if(pattern.length()!=strs.length)
       {
           return false;
       }
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char temp=pattern.charAt(i);
            if(map.containsKey(temp))
            {
                if(!map.get(temp).equals(strs[i]))
                {
                    return false;
                }
            }else {
                if(map.containsValue(strs[i])) return false;
                map.put(temp,strs[i]);
            }
        }
      return true;
    }

    public static void huwei(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strs=scanner.nextLine().split(",V");
        String strs1=strs[0];
        String strs2=strs1.replace("="," ");
        String[] strs3= strs2.split(" ");
        String strs4=strs[1].replace("=","");
        String strs5=(strs4.replace("[","").replace("]"," ")).trim();

        System.out.println(strs3[strs3.length-1]);
        String[] strs6=strs5.split(",");
        for(int i=0;i<strs6.length;i++)
        {
            System.out.println(strs6[i]);
        }

    }

    /**
     * 小易的字典(子问题排列比较)
     * @param args
     */
    public static void zidian(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        long k=scanner.nextLong();

        if(m<=0||n<=0)
        {
            System.out.println(-1);
            return;
        }
        ArrayList<String> strs=new ArrayList<>();
        Set<String> strings=new HashSet<>();
        while (n>0&&m>0)
        {
           long count=countNum(n-1,m,k);
           if(count>k)//若首字母为'a',可能的排列数为count
           {
               strs.add("a");
               n--;
           }
           else if(count<k)
           {
               strs.add("z");
               m--;
               k-=count;
           }

        }
        if(k!=1)
        {
            System.out.println(-1);
            return;
        }else
        {
            while(n>0) {//如果z的个数为0，则将a追加到最后即可
                strs.add("a");
                n--;
            }
            while(n>0) {//如果a的个数为0，则将z追加到最后即可
                strs.add("z");
                m--;
            }
        }

        for (int i = 0; i < strs.size(); i++) {
            System.out.print(strs.get(i));
        }
    }

    public static long countNum(int m,int n,long target) {//计算假设a确定之后，a之后的部分排列组合数
        if(m==0||n==0)
            return 1;
        long sum = m+n;
        long k = 1;
        n = Math.min(m, n);//A(m+n) n=A(m+n) m  取最小即可
        for (int i = 0; i < n ; i++) {
            k *= sum-i;
            k /= (i+1);
            if(k>target)//防止大数。如果k>target 则只进行list.add("a")和m--//a的个数减1。
                //没有target -= k;因此不影响
                break;
        }
        return k;
    }


    public static void jiaohu(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strs=scanner.nextLine().split(" ");
        char[] chars=strs[0].toCharArray();
        int m=Integer.valueOf(strs[1]);
        if(chars.length<=0) {
            System.out.println(0);
            return;
        }
        char[] dp=new char[]{'a', 'b','c','d','e','f','g','h',
                'i','j','k','n','m','o','p','q','r','s','t','u','v','w','x','y','z'};
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<chars.length;i++)
        {
            if(map.containsKey(chars[i]))
            {
                map.put(chars[i],map.get(chars[i])+1);
                if(map.get(chars[i])>=m)
                {
                    System.out.println(m);
                    return;
                }
            }else
            {
                map.put(chars[i],1);
            }
        }
        int num=0;
        for(int j=0;j<26;j++)
        {
            int max=Integer.MIN_VALUE;

            num=map.get(dp[j]);
            if(num>max) max=num;
            if(num>=m)
            {
                System.out.println(m);
                return;
            }

        }
        System.out.println(num);
    }

    public static void jiaohu1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        char[] chars = strs[0].toCharArray();
        int m = Integer.valueOf(strs[1]);
        if (chars.length <= 0) {
            System.out.println(0);
            return;
        }
        List<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            ArrayList<Integer> list1=new ArrayList<>();
            for(int j=0;j<chars.length;j++)
            {
                if(i==chars[j]-'a')
                {
                    list1.add(j);
                }
            }
            if(!list1.isEmpty())
            {
                list.add(list1);
            }

        }
        int len=0;
        for(int i=0;i<list.size();i++)

        {
            int temp=0;
            ArrayList<Integer> list2= list.get(0);
            int count=list2.size();
            int[][] dp=new int[count][count];
            for(int k=0;k<count;k++) {
                int sum = 0;
                int min=Integer.MAX_VALUE;
                for (int n = 0; n < count; n++) {
                    sum=Math.abs(list2.get(n)-list2.get(k))+sum;
                    if(sum<min) min=sum;
                }
                 if(sum<=m) len=count;
                 if(temp>len)
                 {
                     len=temp;
                 }
                 temp=len;
            }
        }
        System.out.println(len);
    }

    /**
     * 对于每个字母，将其出现的位置存储在一维数组position[]中。递归遍历这些位置的所有组合（可通过两个for循环嵌套实现，这样就不会重复）。
     * 递归函数dfsSwichCharacter(i,j,position)返回的是实现position[i]到position[j]之间的相同字母连续排列需要移动的次数。
     * 这里注意状态转移方程，当j==i+1时说明字符串s中position[i]和position[j]之间不可能再有该字母，所以移动次数就是坐标之差减一；
     * 当j>i+1时移动次数相当于是把position[j]的字母移到position[i]隔壁的次数减去这两个位置之间该字母的个数。
     * 如果此时交换次数没有超出限制，则检查此时交换后相同连续出现的字母是不是最长并更新answer = Math.max(answer, q-p+1)。
     * 最后，每个字母在限制内移动次数得到的最大长度保存在length[]数组中。
     */


    public static void jiaohu3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        String s = strs[0];
        int count = Integer.parseInt(strs[1]);
        int len = s.length();
        int[][] record = new int[len][26]; //记录字符串s的每个位置和26个字母的关系
        int[] length = new int[26]; //记录每个字母在规定交换次数内最长的相同字母数量
        for(int i = 0; i < len; i++){
            record[i][s.charAt(i)-'a'] = 1;
        }
        for(int i = 0; i < 26; i++){
            int[] position = new int[len]; //对于每个字母，记录字符串s中出现该字母的位置
            int k = 0; //字符串s中出现该字母k次
            for(int j = 0; j < len; j++){
                if(record[j][i] == 1){
                    position[k] = j;
                    k += 1;
                }
            }
            if(k == 0){
                length[i] = 0;
            }else if(k == 1){
                length[i] = 1;
            }else{
                int answer = Integer.MIN_VALUE;
                for (int p = 0; p < k; p++){
                    for (int q = p+1; q < k; q++){
                        int res = dfsSwichCharacter(p, q, position);
                        if(res <= count){ //在规定交换次数内，更新连续的某个相同字母数量
                            answer = Math.max(answer, q-p+1);
                        }
                    }
                }
                length[i] = answer;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i : length){
            result = Math.max(result, i);
        }
        System.out.println(result);
    }

    public static int dfsSwichCharacter(int i, int j, int[] position){
        if(i == j){
            return 0;
        }else if(i+1 == j){ //说明字符串s中position[i]和position[j]之间不可能再有该字母，所以移动次数就是坐标之差减一
            return position[j] - position[i] - 1;
        }else{ //移动次数相当于是把position[j]的字母移到position[i]隔壁的次数减去这两个位置之间该字母的个数
            return dfsSwichCharacter(i+1, j-1, position) + position[j]-position[i]-1 - (j-i-1);
        }
    }

    /**
     * 我们有很多区域，每个区域都是从a到b的闭区间，现在我们要从每个区间中挑选至少2个数，那么最少挑选多少个？
     */

    public static class Node{
        int left;
        int right;

        public Node(int left,int right)
        {
            this.left=left;
            this.right=right;
        }
    }

    private static class compara implements Comparator<Node> {
        @Override
        public int compare(Node o, Node k) {
            int t=o.right-k.right;
            if (t==0){
                t=k.left-o.left ;
            }
            return t;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int nums=Integer.valueOf(sc.nextLine());
        Node[] node=new Node[nums];
        for (int i = 0; i < nums; i++) {
            String[]s=sc.nextLine().split(" ");
            node[i]=new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }

        Arrays.sort(node,0,nums,new compara());
        int count=2;
        int l1=node[0].right;
        int l2=node[0].right-1;
        for (int i = 1; i < nums ; i++) {
            if (l1<node[i].left){
                count+=2;
                l1=node[i].right;
                l2=node[i].right-1;
            }
            else if (l1>=node[i].left&&l1<node[i].right&&l2<node[i].left){
                count+=1;
                l2=l1;l1=node[i].right;
            }else if (l1<=node[i].right&&l2>=node[i].left){
                continue;
            }

        }


        System.out.println(count);

    }

    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
     * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你
     * 能不能也很快的找出所有和为S的连续正数序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> nums=new ArrayList<>();
        int left = 1,right = 1,sumx = 1;
        while(left <= right){
            right ++;
            sumx += right;
            while(sumx > sum){
                sumx -= left;
                left ++;
            }
            if(sumx == sum && left != right){
                ArrayList<Integer> temp=new ArrayList<>();
                for(int i = left;i <= right;i ++)  temp.add(i);
                nums.add(temp);
            }
        }
        return nums;
    }
}
