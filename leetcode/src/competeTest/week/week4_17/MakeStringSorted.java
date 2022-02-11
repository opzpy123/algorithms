package competeTest.week.week4_17;

public class MakeStringSorted {
	public static void main(String[] args) {

	}
	public int makeStringSorted(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int mod = 1000000000+7;
		int res=0;
		while (isOrderly(chars)){
			res++;
			//找到i
			int i =0;
			for (int k = 0; k < n; k++) { }
			//找到j
			int j =0;
			for (int k = 0; k < n; k++) { }
			//交换i  , j
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			//翻转i-n;
			int l =i,r = n-1;
			while (l<r){
				char tmp = chars[l];
				chars[l] = chars[r];
				chars[r] =tmp;
				l++;r--;
			}
		}
		return res%mod;
	}
	private static boolean isOrderly(char[] chars){
		for (int i = 1; i < chars.length; i++) {
			if(chars[i]>chars[i-1]){
				return false;
			}
		}
		return true;
	}
}
