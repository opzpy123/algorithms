package hard;

import java.util.HashMap;

public class MinDays {
	public static void main(String[] args) {
		MinDays minDays = new MinDays();
//		System.out.println(minDays.minDays(1));
//		System.out.println(minDays.minDays(2));
//		System.out.println(minDays.minDays(6));
		System.out.println(minDays.minDays(10));
		System.out.println(minDays.minDays(56));
	}
	HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
	public int minDays(int n) {
		if(n<=1){
			return n;
		}
		if(map.containsKey(n)){
			return map.get(n);
		}
		map.put(n,Math.min(n%2+1+minDays(n/2),n % 3 + 1 + minDays(n / 3)));
		return map.get(n);
	}
}
