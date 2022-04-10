package easy;

import java.util.HashSet;

public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        System.out.println(uniqueMorseRepresentations.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(uniqueMorseRepresentations.uniqueMorseRepresentations(new String[]{"a"}));
    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder str = new StringBuilder();
            for (char aChar : chars) {
                str.append(table[aChar - 'a']);
            }
            set.add(str.toString());
        }
        return set.size();
    }
}
