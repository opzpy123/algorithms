package normal;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
//		System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1,1,24,34263632,51,52,35,126,2,13,2,6,5342,6,2344,643,5734,5,52315,2343}, 6)));
//		System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
//        System.out.println(topKFrequent.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
//        System.out.println(topKFrequent.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
        System.out.println(topKFrequent.topKFrequent(new String[]{"a", "aa", "aaa"}, 1));
    }

    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .parallel()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed().thenComparing(Map.Entry::getKey))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
