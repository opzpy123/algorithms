package easy;

import java.util.Stack;

public class BrackMaxDepth {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("1+(2*3)/(2-1)"));
    }
    public static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.add(aChar);
                res = Math.max(res, stack.size());
            }
            if (aChar == ')'&&!stack.isEmpty()) {
                stack.pop();
            }
        }
        return res;
    }
}
