package normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {


    public List<List<Integer>> subsets1(int[] nums) {
        //待返回的幂集
        List<List<Integer>> list = new ArrayList<>();
        //先加入空集
        list.add(new ArrayList());

        int n = nums.length;
        for (int i =0;i<n;i++){
            int size =list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }
        //返回最终完整的幂集
        return list;

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        if(nums==null) return ans;
        dfs(ans,nums,new ArrayList<Integer>(),0);
        return ans;
    }

    //类比树状结构 每种情况可以选择加入或者不加入
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        //terminator
        if(index == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        dfs(ans,nums,list,index+1);//not pick the number at this index
        list.add(nums[index]);
        dfs(ans,nums,list,index+1);//pick this number at this index

        //reverse the current state
        list.remove(list.size()-1);

    }

    public static void main(String[] args) {
        //[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
        //[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets1(new int[]{1, 2, 3}));
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }

}
