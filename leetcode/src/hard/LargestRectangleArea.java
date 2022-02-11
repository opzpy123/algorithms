package hard;

import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        if(n==0){
            return 0;
        }
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            //取到当前根的最高
            int height = heights[i];
            int l=i,r=i;//定义左右指针
            while (l>0 && heights[l-1]>=height){//越界控制
               l--;
            }
            while (r<n-1 && heights[r+1]>=height){
                r++;
            }
            int width = r - l + 1;
            area=Math.max(width *height,area);
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
