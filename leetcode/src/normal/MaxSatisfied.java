package normal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSatisfied {
    public static void main(String[] args) {
//        int[] coutomers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
//        int[] groumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
//        int X = 3;

        int[] coutomers = new int[]{4,10,10};
        int[] groumpy = new int[]{1,1,0};
        int X =2;
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        System.out.println(maxSatisfied.maxSatisfied(coutomers, groumpy, X));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        //记录在不使用秘密技巧的情况下有多少顾客
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        //使用滑动窗口 记录每个窗口内使用秘密技巧所产生的效益
        //并记录最大值  total+使用秘密技巧后增加的人数 即为答案；
        int increase = 0;
        //记录第一个窗口的客人数
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        //窗口向右滑动，记录每次窗口可以新增的最大值
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }




    public int maxSatisfied_1(int[] customers, int[] grumpy, int X) {
        int res = 0;//返回值
        int max = 0;//不生气产生的最大值
        int N = customers.length;
        int l = 0, r = X;
        //找到连续不生气的最大值 max
        while (r <= N) {
            l = r - X;
            int layerMax = 0;
            for (int i = l; i < r; i++) {
                layerMax += customers[i];
            }
            max = Math.max(layerMax, max);
            r++;
        }
        r=X;
        //查找不生气最大值产生的索引开始及结尾
        int maxIndexL=0,maxIndexR=0;
        while (r <= N) {
            l = r - X;
            int layerMax = 0;
            for (int i = l; i < r; i++) {
                layerMax += customers[i];
            }
            if(layerMax==max){
                maxIndexL=l;
                maxIndexR=l+X;
            }
            r++;
        }
        //加上最大连续不生气
        for (int i=maxIndexL;i<maxIndexR;i++) {
            res += customers[i];
        }
        //左边
        for(int i=0;i<maxIndexL;i++){
            if(grumpy[i]==1){
                customers[i]=0;
            }
            res+=customers[i];
        }
        //右边
        for(int i=maxIndexR;i<N;i++){
            if(grumpy[i]==1){
                customers[i]=0;
            }
            res+=customers[i];
        }
        return res;
    }

}
