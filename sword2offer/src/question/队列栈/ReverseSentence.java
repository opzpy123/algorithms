package question.队列栈;

public class ReverseSentence {
    public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[s.length - i - 1]).append(" ");
        }
        return sb.toString().trim();
    }
}
