package easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestWord {
    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.longestWord(Arrays
                .asList("a", "banana", "app", "appl", "ap", "apply", "apple").toArray(new String[]{})));

        System.out.println(longestWord.longestWord(Arrays
                .asList("yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y").toArray(new String[]{})));
    }

    public String longestWord(String[] words) {

        //1.排序 根据长度 同样长度的根据字典序
        List<String> sortedWords = Arrays.stream(words).sorted((o1, o2) -> {
            int length = o2.length() - o1.length();
            if (length != 0) return length;
            for (int i = 0; i < o1.length(); i++) {
                int charDef = o1.charAt(i) - o2.charAt(i);
                if (charDef != 0) return charDef;
            }
            return 0;
        }).collect(Collectors.toList());
        System.out.println(sortedWords);
        //查找是否有存在的
        for (int i = 0; i < sortedWords.size(); i++) {
            String str = sortedWords.get(i);
            for (int j = str.length() - 1; j > 0; j--) {
                if (sortedWords.contains(str.substring(0, j))) return sortedWords.get(i);
            }
        }

        return "";
    }
}
