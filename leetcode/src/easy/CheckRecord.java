package easy;

public class CheckRecord {
	public static void main(String[] args) {
		CheckRecord checkRecord = new CheckRecord();
		System.out.println(checkRecord.checkRecord("PPALLP"));
		System.out.println(checkRecord.checkRecord("PPALLL"));
	}
	public boolean checkRecord(String s) {
		int absent=0,late=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='A')absent++;
			late=s.charAt(i)=='L'?late+1:0;
			if(absent>1||late>2)return false;
		}
		return true;
	}
}
