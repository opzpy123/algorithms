package normal;

public class GetHint {
    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        System.out.println(getHint.getHint("1123", "0111"));
        System.out.println(getHint.getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        char[] charsSecret = secret.toCharArray();
        char[] charsGuess = guess.toCharArray();
        int a = 0, b = 0;
        for (int i = 0; i < charsGuess.length; i++) {
            if (charsSecret[i] == charsGuess[i]) {
                a++;
            } else {
                for (int j = 0; j < charsGuess.length; j++) {
                    if (j != i && charsSecret[j] == charsGuess[i]) {
                        b++;
                        break;
                    }
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
        return a + "A" + b + "B";
    }

}
