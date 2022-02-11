package easy;

public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculate("AB"));
    }

    private static int calculate(String s) {
        int x = 1;
        int y = 0;
        String[] strings = s.split("");
        for (String string : strings) {
            if (string.equals("A")) {
                x = 2 * x + y;
            } else if (string.equals("B")){
                y = 2 * y + x;
            }else {
                continue;
            }
        }
        return x + y;
    }
}
