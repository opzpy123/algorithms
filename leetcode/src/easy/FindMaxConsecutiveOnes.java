package easy;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
        System.out.println(findMaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 1,0}));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret=0,count=0;
        for (int num : nums) {
            if (num == 1) count++;
            else count = 0;
            ret = Math.max(ret, count);
        }
        return ret;
    }
}
