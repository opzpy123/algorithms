package normal;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public static void main(String[] args) {
        SimplifiedFractions simplifiedFractions = new SimplifiedFractions();
        System.out.println(simplifiedFractions.simplifiedFractions(2));
        System.out.println(simplifiedFractions.simplifiedFractions(3));
        System.out.println(simplifiedFractions.simplifiedFractions(4));
        System.out.println(simplifiedFractions.simplifiedFractions(1));
    }

    public List<String> simplifiedFractions(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n <= 1) return res;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i)==1) res.add(j + "/" + i);
            }
        }
        return res;
    }

    //判断是否为 最简分数  a为分子 b为分母
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
