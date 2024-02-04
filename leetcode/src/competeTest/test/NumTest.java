package competeTest.test;

import java.util.HashMap;

public class NumTest {

    public static void main(String[] args) {
        NumTest numTest = new NumTest();
        HashMap<String, Integer> res = new HashMap<>();
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                Integer counter=0;
                numTest.test(i,j,1,counter);
                res.put(i+"-"+j,counter);
            }
        }
        res.forEach((k,v)->{
            System.out.println(k+" := "+v);
        });
    }
    private  void test(int level,int numOfLevel,int currLevel,int count){
        if (currLevel >level) return;
        for (int i = 0; i < numOfLevel; i++) {
            count++;
            if (currLevel < level) {
                test(level, numOfLevel,currLevel+1,count);
            }
        }
    }
}
