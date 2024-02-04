package competeTest.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrangementTest {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("asd");
        strings.add("asdfsa");
        strings.add("asdfs3a");
        System.out.println(strings);
    }
    
    private void fullArray(String str){
        char[] chars = str.toCharArray();
        Set<String> set = new HashSet<>();
        helper(set,0,chars.length,chars);
        System.out.println(set);
    }
    
    private void helper(Set<String> set, int curLevel, int level,char[] chars){
        if(curLevel==level)return;
        for (int i = 0; i < level; i++) {
            char[] swap = swap(chars, i, curLevel);
            set.add(new String(swap));
            helper(set,curLevel+1,level,chars);
        }
    }

    private char[] swap(char[] chars , int a,int b){
        char temp = chars[a];
        chars[a]=chars[b];
        chars[b]=temp;
        return chars;
    }
}
