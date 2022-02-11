package normal;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits==null){
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        LinkedList<String> res = new LinkedList<>();
        rec("", digits,0, res,map);
        return res;
    }

    private void rec(String s, String digits, int i, LinkedList<String> res, Map<Character, String> map) {
        //terminator
        if(i==digits.length()){
            //到达最下层
            res.add(s);
            return;
        }
        //process
        String  letters = map.get(digits.charAt(i));
        for(int j=0;j<letters.length();j++){
            //drill down
            rec(s+letters.charAt(j),digits,i+1,res,map);
        }


        //reverse
    }


    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();

        System.out.println(letterCombinations.letterCombinations("23"));
    }


}
