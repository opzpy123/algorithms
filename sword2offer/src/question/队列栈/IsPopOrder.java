package question.队列栈;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 0;
        while (i < pushA.length) {
            if (pushA[i] != popA[j]) {
                st.push(pushA[i++]);
            }
            else {
                i++;j++;
                while (!st.empty() && st.peek() == popA[j]) {
                    st.pop();
                    ++j;
                }
            }
        } // end outer while

        return st.empty();
    }
}
