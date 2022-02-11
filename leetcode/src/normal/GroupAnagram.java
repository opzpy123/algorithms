package normal;

import java.util.*;

public class GroupAnagram {
	public static void main(String[] args) {
		new GroupAnagram().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++){
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String s = new String(arr);
			if(!map.containsKey(s)){
				List<String> temp = new ArrayList<>();
				temp.add(strs[i]);
				map.put(s,temp);
			}else{
				map.get(s).add(strs[i]);
			}
		}

		for(String key: map.keySet()){
			res.add(map.get(key));
		}


		return res;
	}
}
