
package question.排序;

import java.util.ArrayList;
import java.util.HashSet;

public class duplicate {
    public int duplicate(int[] numbers) {
        if (numbers == null) return -1;
        HashSet<Integer> integers = new HashSet<>();
        for (int number : numbers) {
            if (integers.contains(number)) return number;
            else integers.add(number);
        }
        return -1;
    }

}
