package easy;

import java.util.Stack;

public class Reformat {
    public static void main(String[] args) {
        Reformat reformat = new Reformat();
        System.out.println(reformat.reformat("covid2019"));
    }
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                numStack.push(aChar);
            } else {
                charStack.push(aChar);
            }
        }
        // 1a2   1a2b
        if (Math.abs(numStack.size() - charStack.size()) > 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            if (numStack.size() > charStack.size()) {
                while (!numStack.empty() || !charStack.empty()) {
                    if (!numStack.empty()) {
                        sb.append(numStack.pop());
                    }
                    if (!charStack.empty()) {
                        sb.append(charStack.pop());
                    }
                }
            } else {
                while (!numStack.empty() || !charStack.empty()) {
                    if (!charStack.empty()) {
                        sb.append(charStack.pop());
                    }
                    if (!numStack.empty()) {
                        sb.append(numStack.pop());
                    }
                }
            }
            return sb.toString();
        }
    }
}
