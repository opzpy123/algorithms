package easy;

import java.util.ArrayList;
import java.util.List;

public class IsUgly {
	public static void main(String[] args) {
		IsUgly isUgly = new IsUgly();
		System.out.println(isUgly.isUgly(6));
		System.out.println();
		System.out.println(isUgly.isUgly(8));
		System.out.println();
		System.out.println(isUgly.isUgly(14));
	}
	public boolean isUgly(int n) {
		if (n<1) return false;
		while (n%5==0){
			n/=5;
		}
		while (n%3==0){
			n/=3;
		}
		while (n%2==0){
			n>>=1;
		}
		return n == 1;
	}
}
