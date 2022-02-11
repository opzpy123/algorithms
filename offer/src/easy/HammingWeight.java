package easy;

public class HammingWeight {
	public int hammingWeight(int n) {
		int  i=0;
		while (n!=0){
			if(n<<1%1==1)i++;
		}
		return i;



	}
}
