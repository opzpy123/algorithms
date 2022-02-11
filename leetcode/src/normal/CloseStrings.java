package normal;

import sun.font.CreatedFontTracker;

import java.util.*;

public class CloseStrings {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length()){
            return false;
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[] help1 = new int[26];
        for (Character c : chars1) {
            help1[c-'a']++;
        }
        int[] help2 = new int[26];
        for (Character c : chars2) {
            help2[c-'a']++;
        }
//排序前判断两个数组字符分布位置是否一致表示元素种类一致
        for (int i = 0; i < help1.length ; i++) {
            if (help1[i] > 0 && help2[i] == 0) {
                return false;
            }
            if (help1[i] == 0 && help2[i] > 0) {
                return false;
            }
        }
        //排序后，如果数组每个位置元素数量相等，代表可用题目解法二交换
        Arrays.sort(help1);
        Arrays.sort(help2);
        for (int i = 0; i < help1.length ; i++) {
            if (help1[i] != help2[i]) {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        CloseStrings closeStrings = new CloseStrings();
        System.out.println(closeStrings.closeStrings("abc", "bca"));
        System.out.println(closeStrings.closeStrings("a", "aa"));
        System.out.println(closeStrings.closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings.closeStrings("cabbba", "aabbss"));
    }
}
