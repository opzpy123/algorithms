package normal;

import java.util.Deque;
import java.util.LinkedList;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLength = 0;
        int lIndex =0 ;
        int rIndex = 1;
        //使用队列保存当前的最长不重复子串
        Deque<Character> characters = new LinkedList<>();

        characters.add(s.charAt(lIndex));
        while (lIndex <= rIndex && rIndex < s.length()) {
            if (characters.contains(s.charAt(rIndex))) {
                lIndex++;
                characters.poll();
                continue;
            }
            characters.offer(s.charAt(rIndex));
            maxLength = Math.max(maxLength, characters.size());
            rIndex++;
        }
        return maxLength;
    }
}
