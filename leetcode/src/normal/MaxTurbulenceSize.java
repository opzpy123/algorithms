package normal;

public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int result =1;//反转次数
        int left =0,right=0;
        while (right<n-1){
            //如果碰到连续两个相同的则跳过，否则right+1(滑动窗口尺寸+1)
            if(left==right){
                if(arr[left]==arr[left+1]){
                    left++;
                }
                right++;
            }else {
                if(arr[right-1]<arr[right] && arr[right]>arr[right+1]){
                    //如果是/\类型的，就继续right++扩大窗口
                    right++;
                }else if(arr[right-1]>arr[right] && arr[right]<arr[right+1]){
                    //如果是\/类型的，就继续right++扩大窗口
                    right++;
                }else {
                    //如果都不是就left=right重新开窗口
                    left = right;
                }
            }
            result = Math.max(result,right-left+1);//记录最大窗口尺寸
        }
        return result;
    }
}
