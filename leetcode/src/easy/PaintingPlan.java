package easy;

public class PaintingPlan {
	public static void main(String[] args) {
		PaintingPlan paintingPlan = new PaintingPlan();
		paintingPlan.paintingPlan(2,2);
	}
	public int paintingPlan(int n, int k) {
		if(k==0||k==n*n)return 1;
		int ans=0;
		for(int a=0;a<=n;a++){
			for(int b=0;b<=n;b++){
				if((a+b)*n-a*b==k){
					ans=ans+C(n,a)*C(n,b);
				}
			}
		}
		return ans;
	}
	int C(int n, int m){
		return f(n)/(f(m)*f(n-m));  //组合数
	}
	int f(int num)                      //阶乘
	{
		if (num == 0)
			return 1;
		else
			return num * f(num - 1);
	}
}
