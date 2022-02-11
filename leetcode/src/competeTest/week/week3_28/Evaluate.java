package competeTest.week.week3_28;

import java.util.ArrayList;
import java.util.List;

public class Evaluate {
	public static void main(String[] args) {
		Evaluate evaluate = new Evaluate();
		ArrayList<String> string1 = new ArrayList<>();
		string1.add("name");
		string1.add("bob");
		ArrayList<String> string2 = new ArrayList<>();
		string2.add("age");
		string2.add("two");
		List<List<String>> arrayLists = new ArrayList<>();
		arrayLists.add(string1);
		arrayLists.add(string2);
		System.out.println("结果:"+evaluate.evaluate("(name1)(age)(name)(asd)sold", arrayLists));
	}
	public String evaluate(String s, List<List<String>> knowledge) {
		int n =knowledge.size();

		String[] key =new String[n];
		String[] value =new String[n];

		for (int i = 0; i < n; i++) {
			key[i]=knowledge.get(i).get(0);
			value[i]=knowledge.get(i).get(1);
		}

		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='('){
				for (int j = i; j < s.length(); j++) {
					if(s.charAt(j)==')'){
						String substring = s.substring(i+1, j);
						for (int k=0;k<key.length;k++){
							if(substring.equals(key[k])){
								s= s.substring(0, i) + value[k] + s.substring(j+1);
								i+=2;
							}
						}
						if(s.charAt(i)=='(') s= s.substring(0, i) + "?" + s.substring(j+1);
						j=s.length();
					}
				}
			}
		}
		return s;
	}
}
