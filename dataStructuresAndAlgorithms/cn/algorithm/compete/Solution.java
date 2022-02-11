package compete;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findKthBit(3,1);
        solution.findKthBit(4,11);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回Sn的第k位字符
     * @param n int整型 Sn的n
     * @param k int整型 需要返回的字符下标位
     * @return char字符型
     */
    public char findKthBit (int n, int k) {

        String str = "abcdefghijklmnopqrstuvwxyz";
        String[] s = new String[26];
        s[0] = "a";
        for (int i = 1; i <= n; i++) {
            s[i]=s[i-1]+str.charAt(i)+reverse(invert(s[i-1]));
        }
        System.out.println(s[n].charAt(k-1));
        return s[n].charAt(k-1);
    }
    private String invert(String s){
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i]=str.charAt(25-(chars[i]-'a'));
        }
        return new String(chars);
    }
    private static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}