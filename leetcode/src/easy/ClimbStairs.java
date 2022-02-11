package easy;

public class ClimbStairs {
    public int climbStairs(int n) {
        //0:1 1:1 2:2 3:3 4:5 5:8
        //1 1 2 3 5 8 斐波那契
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        int rs = 0;
        if(n==0||n==1){
            return 1;
        }else{
            rs = climbStairs(n-1)+climbStairs(n-2);
            return rs;
        }
    }

    public int climbStair3(int n){
        //当步伐可选1,2,3
        int rs = 0;
        int[] dp = new int[n+1];
        /** x=1 y=1
         *  x=2 y=2
         *  x=3 y=4
         *  x=4 y=7
         *  x=5 y=13
         *
         *  n>3:
         *  y[n]=y[n-1]+y[n-2]+y[n-3]
         */
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp["+i+"]="+dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStair3(20);
    }
}
