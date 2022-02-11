package competeTest.week.week3_21;

import java.util.LinkedList;
import java.util.List;

public class GetNumberOfBacklogOrders {
	public static void main(String[] args) {
		GetNumberOfBacklogOrders getNumberOfBacklogOrders = new GetNumberOfBacklogOrders();
		System.out.println(getNumberOfBacklogOrders.getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
	}

	List<Integer> buyBacklog = new LinkedList<>();
	List<Integer> sellBacklog = new LinkedList<>();

	public int getNumberOfBacklogOrders(int[][] orders) {
		int m = orders.length;
		for (int i = 0; i < m; i++) {
			int price = orders[i][0];
			int amount = orders[i][1];
			int orderType = orders[i][2];
			for (int j = 0; j < amount; j++) {
				if (orderType == 0) {
					buyBacklog.add(price);
				}
				if (orderType == 1) {
					sellBacklog.add(price);
				}
			}
		}
		List<Integer> buy = new LinkedList<>();
		List<Integer> sell = new LinkedList<>();
		sell.addAll(sellBacklog);
		buy.addAll(buyBacklog);
		for (int i = sellBacklog.size()-1; i >0 ; i--) {
			for (int j = buyBacklog.size()-1; j >0 ; j--) {
				if(buyBacklog.get(j)>sellBacklog.get(i)){
					buy.remove(i);
					sell.remove(j);
					i--;
					continue;
				}
			}
		}
		return buy.size() + sell.size();
	}
}
