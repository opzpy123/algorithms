package normal;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {
	public static void main(String[] args) {
		FrequencySort frequencySort = new FrequencySort();
		System.out.println(frequencySort.frequencySort("tree"));

	}
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			int frequency = map.getOrDefault(c, 0) + 1;
			map.put(c, frequency);
		}
		List<Character> list = new ArrayList<Character>(map.keySet());
		Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
		StringBuffer sb = new StringBuffer();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			char c = list.get(i);
			int frequency = map.get(c);
			for (int j = 0; j < frequency; j++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
