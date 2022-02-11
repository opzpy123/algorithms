package competeTest.week.week2_28;

import java.util.List;

public class CountMatches {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int key;
        if (ruleKey .equals( "type")) {
            key=0;
        } else if (ruleKey .equals( "color")) {
            key=1;
        } else {
            key=2;
        }
        int count=0;
        for (List<String> item : items) {
            if(item.get(key).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}
