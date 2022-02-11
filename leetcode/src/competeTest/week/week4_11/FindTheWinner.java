package competeTest.week.week4_11;

import java.util.LinkedList;

public class FindTheWinner {
	public static void main(String[] args) {
		System.out.println(findTheWinner(5, 2));
		System.out.println(findTheWinner(6, 5));
	}

	public static int findTheWinner(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int i =k-1;
		while (list.size()!=1){
			list.remove(i);
			i=(i+k-1)%list.size();
		}
		return list.get(0);
	}

}
