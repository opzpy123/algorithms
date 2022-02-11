package normal;

//盛水最多的容器
public class MaxArea {
    public  static int maxArea(int[] height) {
        int rs=0;
        int i=0;
        int j=height.length-1;
        while (i<j){
            rs=Math.max((j-i)*Math.min(height[i],height[j]),rs);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
