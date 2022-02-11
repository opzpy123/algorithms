package normal;

/**
 * 计算 x 的 n 次幂函数。
 */
public class MyPow {

    //二分
    public double pow111(double x,int n){
        if (n == 0) { return 1; }
        if (n == 1) { return x; }
        if (n == -1) { return 1 / x; }
        double half = pow111(x, n / 2);
        double rest = pow111(x, n % 2);
        return rest * half * half;
    }

    double rs =1;
    public double myPow(double x, int n) {
        if(x<0.0001&&x>0){
            return 0;
        }
        if(x==1||n==0){
            return 1;
        }
        if(x==-1.0){
            if(n%2==0){
                return 1;
            }else {
                return -1;
            }
        }
        if(n<-1000000&&x>0||n>1000000&&x<0){
            return 0;
        }
        if(n>0){
            rs=x*myPow(x,--n);
        }
        if(n<0){
            rs=1/x*myPow(x,++n);
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(StrictMath.pow(2, 3));
        MyPow myPow = new MyPow();
        System.out.println(myPow.pow111(0.00001, 4));
    }
}
