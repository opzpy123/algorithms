package normal;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    private static List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        if(n<=0){
            return null;
        }

        for(int i=1;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(n);
            rs.add(list);
        }


        combine(--n,k);

        return rs;
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4,2);
        System.out.println("==================");
        for (List<Integer> r : rs) {
            System.out.println(r);
        }
    }

}
