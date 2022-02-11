package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//有效的字母异位词
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(t.length()!=s.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        Arrays.sort(counter);
        return counter[0] == 0;
    }
}
