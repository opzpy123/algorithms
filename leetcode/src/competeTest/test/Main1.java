package competeTest.test;

import java.util.Scanner;
public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		s=s.replace(";","");
		String[] split = s.split(" ");
		String type = split[0];
		String[] a = split[1].split(",");
		int res=0;
		int typeLen =0;
		if(type.equals("int")){
			typeLen=4;
		}else if(type.equals("long")){
			typeLen=8;
		}else {
			typeLen=1;
		}
		for (int i = 0; i < a.length; i++) {
			if(a[i].contains("[")){
				String s1 = a[i];
				StringBuilder sb = new StringBuilder();
				int t=1;
				for (int j = 0; j < s1.length(); j++) {
					if(Character.isDigit(s1.charAt(j))){
						sb.append(s1.charAt(j));
					}else {
						if(sb.length()!=0) {
							int i1 = Integer.parseInt(sb.toString());
							t *= i1;
							sb = new StringBuilder();
						}
					}
				}
				res+=t;
			}else {
				res+=1;
			}
		}
		System.out.println(res*typeLen);
	}
}