package competeTest.test;

public class Subsequence {
	public static void main(String[] args) {
		String s = "asda";
		getSubSequence(s.toCharArray(),0,"");
	}

	private static void getSubSequence(char[] chars, int i, String res) {
		if(i==chars.length){
			System.out.println(res);
			return;
		}else {
			getSubSequence(chars,i+1,res);
			getSubSequence(chars,i+1,res+chars[i]);
		}
	}
}
