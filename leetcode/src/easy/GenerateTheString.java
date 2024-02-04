package easy;

public class GenerateTheString {
    public static void main(String[] args) {
        GenerateTheString generateTheString = new GenerateTheString();
        System.out.println(generateTheString.generateTheString(4));
        System.out.println(generateTheString.generateTheString(2));
        System.out.println(generateTheString.generateTheString(7));
    }

    public String generateTheString(int n) {
        return n % 2 != 0 ? "a".repeat(n) : "a".repeat(n - 1) + "b";
    }
}
