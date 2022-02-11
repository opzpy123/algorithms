package hard;

public class SuperpalindromesInRange {
    public static void main(String[] args) {
        SuperpalindromesInRange s = new SuperpalindromesInRange();
        System.out.println(s.superpalindromesInRange("4", "1000"));
    }
    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int res =0;
        for (long i = l; i <=r ; i++) {
            if(valid(i+"")){
                if(isInt(Math.sqrt(i))&&valid((int)Math.sqrt(i)+""))
                res++;
            }
        }
        return res;
    }
    private boolean valid(String s){
        if(s.length()==1) return true;
        int l =0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean isInt(double a)
    {
        double b = a;
        int b1 = (int)a;
        if(b % b1 == 0)
            return true;
        else
            return false;
    }
}
