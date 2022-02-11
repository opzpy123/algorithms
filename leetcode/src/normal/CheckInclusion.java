package normal;

import java.util.Arrays;

public class CheckInclusion {
    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("add", "aasdasda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        //对字符串1进行字符计数
        //对字符串2进行滑动窗口 判断
        char[] chars_1 = s1.toCharArray();
        int n = chars_1.length;
        int[] counter = new int[26];
        for (int i = 0; i < n; i++) {
            counter[chars_1[i] - 'a']++;
        }
        //滑动窗口大小固定为s1的长度
        int left = 0, right = left + s1.length();
        if (s2.length() < right) {
            return false;
        }
        while (right <= s2.length()) {
            String substring = s2.substring(left, right);
            char[] chars_sub = substring.toCharArray();
            int[] counter_sub = new int[26];
            for (int i = 0; i < chars_sub.length; i++) {
                counter_sub[chars_sub[i] - 'a']++;
            }
            if (Arrays.equals(counter, counter_sub)) {
                //两个数组相同则返回true
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
