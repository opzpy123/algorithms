package competeTest.week.week6_20;



public class LargestOddNumber {
	public static void main(String[] args) {
		System.out.println("------------");

		LargestOddNumber largestOddNumber = new LargestOddNumber();
		System.out.println(largestOddNumber.largestOddNumber("52"));
		System.out.println(largestOddNumber.largestOddNumber("4206"));
		System.out.println(largestOddNumber.largestOddNumber("35427"));
		System.out.println(largestOddNumber.largestOddNumber("7542351161"));
	}

	public String largestOddNumber(String num) {
		int index =-1;
		for (int i =0; i<num.length(); i++) {
			if((num.charAt(i)-'0')%2==1){
				index=i;
			}
		}
		return num.substring(0,index+1);
	}
}
