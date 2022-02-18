package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare.backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare.backspaceCompare("a#c", "b"));

    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> list_s = new Stack<>();
        Stack<Character> list_t = new Stack<>();
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        for (char chars_ : chars_s) {
            if (chars_ == '#' && list_s.size() >= 1)list_s.pop();
            if (chars_ != '#') list_s.add(chars_);
        }
        for (char c : chars_t) {
            if (c == '#' && list_t.size() >= 1) list_t.pop();
            if (c != '#') list_t.add(c);
        }
        return list_s.equals(list_t);
    }
}
