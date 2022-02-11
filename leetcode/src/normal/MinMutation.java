package normal;

import java.util.HashSet;

public class MinMutation {

    int minStepCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void dfs(HashSet<String> step, int stepCount,
                     String current, String end, String[] bank) {
        if (current.equals(end))
            minStepCount = Math.min(stepCount, minStepCount);
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++)
                if (current.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;//字符匹配当前字符串与库中字符串 差异记录超过1则此例不可行
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }


    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        MinMutation minMutation = new MinMutation();
        System.out.println(minMutation.minMutation(start, end, bank));




        System.out.println("OpZpy123");
    }
}
