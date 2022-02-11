package compete.meituan21_8;

import java.util.Scanner;

/**
 * 小美写作文
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美最近学到很多新的汉字，想要展示一下自己的汉字功底，于是她开始写作文了。
 * <p>
 * 她写着写着会担心一下她有没有好好展示出自己丰富的汉字词汇量，于是她想知道对于某个位置(pos1)的汉字x，最近的另外一个与其相同汉字的位置(pos2)的距离是多少，即|pos1-pos2|。
 * <p>
 * 为了简化，我们认为小美只学了26个汉字，将它们用a ~ z代表。小美默认有一个仅包含a ~ z的字符串s，每次操作小美要么往字符串s末尾增加一个指定字母。要么给出一个位置pos1（1 <= pos1 <= 现在字符串s的长度），询问min{ |pos2-pos1| }，其中pos2满足s[pos2] = s[pos1]，pos2≠pos1，即不同于pos1的最近的另外一个pos2，使得这两个位置的字母相等。
 * <p>
 * s[pos]表示的意思是s字符串中第pos个位置的字符。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行一个字符串仅包含小写字母的字符串s。
 * <p>
 * 第二行一个整数n，表示接下来有n次操作。
 * <p>
 * 接下来n行，每行第一个整数opt，表示这一次是什么操作。如果opt=1，接下来有一个小写字母，表示小美将要往s末尾添加该小写字母。如果opt=2，表示一次问题描述中的询问。
 * <p>
 * 操作次数n满足1 <= n <= 500。
 * <p>
 * 其中，对于60%数据，保证字符串长度len满足1 <= len <= 1,000。
 * <p>
 * 对于100%数据，保证操作次数n满足1 <= n <= 100,000。
 * <p>
 * 对于操作2，可能没有答案，此时输出-1。
 * <p>
 * 输出描述
 * 对于每一个opt=2的操作，输出答案。
 * <p>
 * <p>
 * 样例输入
 * asdgfas
 * 5
 * 2 6
 * 1 a
 * 1 b
 * 2 6
 * 2 4
 * 样例输出
 * 5
 * 2
 * -1
 * <p>
 * 提示
 * 第一次2号询问，离第6位的a最近的a是第1位的a，距离为 |6 -1| = 5
 * <p>
 * 第二次2号询问，中间插入了一些字母，字符串已经变成了asdgfasab
 * <p>
 * 那么距离第6位的a最近的a变成了第8位的a，距离位|6-8| = 2
 * <p>
 * 第三次2号询问，没有第4位的g最近的g，因此输出-1.
 */

public class Main2 {
    public static void main(String[] args) {

        //百AC

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            String next = sc.next();
            if (a == 1) {
                //接下来有一个小写字母，表示小美将要往s末尾添加该小写字母。
                sb.append(next);
            } else {
                //表示一次问题描述中的询问。
                int nex = Integer.parseInt(next);
                char c = sb.charAt(nex-1);
                int l = nex-1, r = nex+1;
                int res = Integer.MAX_VALUE;
                while (l > 0 || r < sb.length()) {
                    int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
                    if (l > 0) {
                        if (sb.charAt(l-1) == c) {
                            x = Math.abs(nex - l);
                        }
                        l--;
                    }
                    if (r < sb.length()) {
                        if (sb.charAt(r-1) == c) {
                            y = Math.abs(nex - r);
                        }
                        r++;
                    }
                    res = Math.min(res,Math.min(x, y));
                }
                if (res != Integer.MAX_VALUE) {
                    System.out.println(res);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
