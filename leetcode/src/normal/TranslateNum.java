package normal;

public class TranslateNum {
	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}
	public  static int translateNum(int num) {
		if(num<=9){
			return 1;
		}
		int temp = num%100;
		if(temp<=9||temp>=26){
			return translateNum(num/10);
		}else {
			return translateNum(num/10)+translateNum(num/100);
		}
	}
}
