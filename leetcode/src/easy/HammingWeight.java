package easy;

public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000010000000));
    }

    public  static int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;

    }
}
