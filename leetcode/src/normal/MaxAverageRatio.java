package normal;

import java.util.*;

public class MaxAverageRatio {
	public static void main(String[] args) {
		MaxAverageRatio maxAverageRatio = new MaxAverageRatio();
		System.out.println(maxAverageRatio.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
		System.out.println(maxAverageRatio.maxAverageRatio_MaxHeap(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
		System.out.println(maxAverageRatio.maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4));
		System.out.println(maxAverageRatio.maxAverageRatio_MaxHeap(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4));
	}
	//大顶堆！
	public double maxAverageRatio_MaxHeap(int[][] classes, int extraStudents) {
		double sum=0;
		int n=classes.length;
		PriorityQueue<double[]> queue=new PriorityQueue<>(new Comparator<double[]>(){
			public int compare(double[] a,double[] b){
				if(b[0]>a[0]){
					return 1;
				}else{
					return -1;
				}
			}
		});
		for(int j=0;j<n;j++){
			sum+=(double)classes[j][0]/classes[j][1];
			double temp=calculate(classes[j][0],classes[j][1]);
			queue.offer(new double[]{temp,j});
		}
		for(int i=0;i<extraStudents;i++){
			double[] cur=queue.poll();
			sum+=cur[0];
			int idx=(int) cur[1];
			++classes[idx][0];
			++classes[idx][1];
			double temp=calculate(classes[idx][0],classes[idx][1]);
			queue.offer(new double[]{temp,idx});
		}
		return sum/n;
	}

	//leetcode不讲武德 这都能超时
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		//每次在最小的
		int n = classes.length;
		while (extraStudents > 0) {
			double max = 0;
			int inc=0;//当前这个1加在第几个数组上
			for (int i = 0; i < n; i++) {
				double curPoint = calculate(classes[i][0],classes[i][1]);
				if (curPoint > max) {
					max = curPoint;
					inc = i;
				}
			}
			classes[inc][0]++;
			classes[inc][1]++;
			extraStudents--;
		}
		double sum=0.0;
		for (int i = 0; i < n; i++) {
			sum+=(double)classes[i][0] / classes[i][1];
		}
		return sum/n;
	}

	private double calculate(int x,int y){
		return (double)(x + 1) / (y + 1) - (double)x / y;
	}
}
