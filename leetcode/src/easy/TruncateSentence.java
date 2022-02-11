package easy;

import java.util.Arrays;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        s=s.trim();
        String[] s1 = s.split(" ");
        StringBuilder res= new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(s1[i]);
            res.append(" ");
        }
        return res.toString().trim();
    }
}
