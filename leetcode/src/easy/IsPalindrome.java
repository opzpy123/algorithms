package easy;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x <0) return false;
        int oringinN = x;
        int newN = 0;

        while(x>0){
            newN = newN*10 +x%10;
            x/=10;
        }
        return oringinN == newN;

    }
}
