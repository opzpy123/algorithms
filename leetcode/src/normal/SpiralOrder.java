package normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SpiralOrder {
	public static void main(String[] args) {
		SpiralOrder spiralOrder = new SpiralOrder();
		System.out.println(spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
		System.out.println(spiralOrder.spiralOrder(new int[][]{{1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}}, 1));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> order = new ArrayList<Integer>();
		//特判
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return order;
		}
		//总行数 总列数
		int rows = matrix.length, columns = matrix[0].length;
		//记录当前位置是否被访问过
		boolean[][] visited = new boolean[rows][columns];
		//需要记录多少个元素
		int total = rows * columns;
		//初始位置
		int row = 0, column = 0;
		//方向集 左下右上
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		//初始方向
		int directionIndex = 0;
		//total次迭代记录
		for (int i = 0; i < total; i++) {
			//当前元素放入结果集
			order.add(matrix[row][column]);
			//记录当前节点已被访问
			visited[row][column] = true;
			//根据当前方向计算下个应该访问的元素位置
			int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
			//计算下个是否违法，如果违法就右转
			if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
				//根据方向集里四个元素顺序依次寻找
				directionIndex = (directionIndex + 1) % 4;
			}
			//方向修正完毕 开始步进
			row += directions[directionIndex][0];
			column += directions[directionIndex][1];
		}
		return order;
	}

	public List<Integer> spiralOrder(int[][] matrix, int a) {
		List<Integer> order = new ArrayList<Integer>();
		//特判
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return null;
		//总行数 总列数
		int rows = matrix.length;
		int columns = matrix[0].length;
		//记录当前位置是否被访问过
		boolean[][] isVisited = new boolean[rows][columns];
		//需要记录多少个元素
		int total = columns * rows;
		//初始位置
		int col=0,row=0;
		//方向集 左下右上
		int[][] Directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		//初始方向
		int direct = 0;
		//total次迭代记录
		for (int i = 0; i < total; i++) {
			//当前元素放入结果集
			order.add(matrix[row][col]);
			//记录当前节点已被访问
			isVisited[row][col]=true;
			//根据当前方向计算下个应该访问的元素位置
			int nextRow = row+Directions[direct][0];
			int nextColumn = col+Directions[direct][1];
			//计算下个是否违法，如果违法就右转
			if (nextColumn<0||nextRow<0||nextColumn>=columns||nextRow>=rows||isVisited[nextRow][nextColumn]) {
				//根据方向集里四个元素顺序依次寻找
				direct = (direct+1)%4;
			}
			//方向修正完毕 开始步进
			row+=Directions[direct][0];
			col+=Directions[direct][1];

		}
		return order;
	}

}
