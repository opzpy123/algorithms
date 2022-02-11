package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOcurrences {
    public static void main(String[] args) {
        FindOcurrences findOcurrences = new FindOcurrences();
        System.out.println(Arrays.toString(findOcurrences.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(findOcurrences.findOcurrences("we will we will rock you", "we", "will")));

    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] s = text.split(" ");
        for (int i = 0; i < s.length; i++) {
            if(s[i].equals(first)&&i+1<s.length&&s[i+1].equals(second)&&i+2<s.length)res.add(s[i+2]);
        }
        return res.toArray(new String[0]);
    }
}
