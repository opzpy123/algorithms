package hard;

public class TrappingRain {


    public static int trap(int[] height) {
        if(height.length<=2) return 0;
        //一层一层接雨水 从第一层开始 每两个大于等于1之间的方块可以接他们之间距离的水

        int max=0;
        for (int i = 0; i < height.length; i++) {
            max= Math.max(height[i],max);
        }

        int sum = 0;
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
