package normal;

public class Compress {
    public int compress(char[] chars) {
        char t = chars[0];
        int res=0;
        for (int i = 1; i < chars.length; i++) {
            res++;
            while (t==chars[i]){
                i++;
                t=chars[i];
            }
        }
        return res;
    }
}
