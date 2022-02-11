package normal;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesisPruning {
    List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            //filter  out the invalid parentheses
            result.add(s);
            return;
        }
        //process

        //drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left < n && right < left) {
            generate(left, right + 1, n, s + ")");
        }

        //restore
    }


}
