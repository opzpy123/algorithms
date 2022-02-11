package easy;

import java.util.Arrays;

public class FindContentChildren {
    //Greed
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1,1};
        FindContentChildren findContentChildren = new FindContentChildren();
        System.out.println(findContentChildren.findContentChildren(g, s));
    }

}
