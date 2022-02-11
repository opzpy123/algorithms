package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderedStream {
    int ptr;
    String[] strs;
    public OrderedStream(int n) {
        ptr = 0;
        strs = new String[n+1];

    }

    public List<String> insert(int id, String value) {
        List<String> rs = new ArrayList<>();
        strs[id-1]=value;
        while (null!=strs[ptr]){
            rs.add(strs[ptr]);
            ptr++;
        }
        return rs;
    }

    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }


}
