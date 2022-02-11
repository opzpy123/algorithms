package compete.meituan21_8;

/**
 * 小美的数学题
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美最近在课外书上发现一篇文章，文章中描述了一种奇怪的序列，名字叫做"阔浩"序列。
 *
 * "阔浩"序列是这样定义的：空串是合法的"阔浩"序列，且它拥有1的代价。
 *
 * 如果s是合法的"阔浩"序列，那么(s)也是合法的"阔浩"序列，且(s)的代价为s的代价加一
 *
 * 如果s，t都是合法的"阔浩"序列，那么它们拼接起来的st也是合法的"阔浩"序列，且总的代价为s的代价乘以t的代价。
 *
 * 例如，(()())() 是合法的"阔浩"序列，而 )(())(() 不是合法的"阔浩"序列，且前者的代价为(2*2+1)*2=10
 *
 *
 *
 * 输入描述
 * 一行仅包含“ ( ”   和  “ ) ”  的合法"阔浩"序列。（不含引号）
 *
 * 100%的数据保证，"阔浩"序列长度len满足1 <= len <= 200,000。
 *
 * 输出描述
 * 输出一个数，"阔浩"序列的代价。由于答案可能过大，所以输出模意义下的"阔浩"序列的代价。
 *
 * 形式化的，设代价为ans，输出ans%P（P=1,000,000,007）。其中，%为模运算，用于求解余数，例如5%2=1，9%7=2。
 *
 *
 * 样例输入
 * ()()()(())
 * 样例输出
 * 24
 *
 * 提示
 * 前三个()，每个单独代价都是2
 *
 * 它们并列之后代价为乘积8
 *
 * 而最后一组(())单独代价为3
 *
 * 与前面并列的乘起来最终代价为24
 */


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s=s.replace("(()()())", "9");
        s=s.replace("(()())", "5");
        s=s.replace("((()))", "4");
        s=s.replace("()()", "4");
        s=s.replace("(())", "3");
        s=s.replace("()", "2");
        if(s.contains("(")||s.contains(")")){
            s=s.replace("(", "2");
            s=s.replace(")", "1");
        }
        String[] split = s.split("");
        int res=1;
        for (String s1 : split) {
            res*=Integer.parseInt(s1);
        }
        System.out.println(res);

    }
}
