package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class HashTableTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        HashTableTest hashTableTest = new HashTableTest();
        System.out.println(hashTableTest.getRepeatNum(arr));
    }

    private List<Integer> getRepeatNum(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> hash = new HashSet<>();
        for (int num : arr) {
            if(hash.contains(num)){
                res.add(num);
            }else {
                hash.add(num);
            }
        }
        return res;
    }
}
