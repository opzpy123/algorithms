package easy;

public class IsAlienSorted {
    public static void main(String[] args) {
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (String word : words) {
            if (!check(word, order)) return false;
        }
        return true;
    }

    private boolean check(String word, String order) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (order.indexOf(word.charAt(i)) > order.indexOf(word.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
