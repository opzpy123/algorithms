package compete;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            double t =a;
            double res=a;
            for (int i = 1; i < b; i++) {
               res+=Math.sqrt(t);
                t=Math.sqrt(t);
            }
            System.out.printf("%.2f%n", res);
        }

    }
}
