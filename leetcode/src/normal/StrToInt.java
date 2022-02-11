package normal;

public class StrToInt {
	public static void main(String[] args) {
		System.out.println(strToInt("42"));
		System.out.println(strToInt("-42"));
		System.out.println(strToInt("4193 with words"));
		System.out.println(strToInt("words and 987"));
		System.out.println(strToInt("-91283472332"));
		System.out.println(strToInt("3.14159"));
		System.out.println(strToInt("-3.14159"));
		System.out.println(strToInt(""));
		System.out.println(strToInt(" "));

	}

	public static int strToInt(String str) {
		if(str.length()==0)return 0;
		if(str.length()==1&&str.charAt(0)=='-')return 0;
		if(str.length()==1&&str.charAt(0)=='+')return 0;
		if(str.contains("+-"))return 0;
		if(str.contains("-+"))return 0;
		str = str.replace("+"," ");
		char[] chars = str.toCharArray();
		int n=chars.length;
		int l=0,r=n-1;
		for (int i =0;i<n;i++){
			if(chars[i]=='-'||Character.isDigit(chars[i])){
				l=i;
				break;
			}
			if(chars[i]!=' '){
				return 0;
			}
			if(i==n-1&&!Character.isDigit(chars[i])){
				return 0;
			}
		}
		for (int i =n-1;i>=0;i--){
			if(Character.isDigit(chars[i])){
				r=i;
				break;
			}
		}
		String substring = str.substring(l, r+1);
		if(substring.contains(".")){
			substring=substring.substring(0,substring.indexOf("."));
		}
		long res = Long.parseLong(substring);
		if(res>Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(res<Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return Integer.parseInt(substring);
	}
}
