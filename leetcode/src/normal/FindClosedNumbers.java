package normal;

public class FindClosedNumbers {
    public static void main(String[] args) {
        FindClosedNumbers findClosedNumbers = new FindClosedNumbers();
        findClosedNumbers.findClosedNumbers(2);
    }
    public int[] findClosedNumbers(int num) {
        System.out.println(num<<1);
        System.out.println(num>>1);
        return new int[]{num<<1,num>>1};
    }
}