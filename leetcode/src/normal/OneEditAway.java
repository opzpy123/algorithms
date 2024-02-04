package normal;

public class OneEditAway {
    public static void main(String[] args) {

    }
    public boolean oneEditAway(String first, String second) {
        //相等
        if(first.equals(second)){
            return true;
        }
        //如果相差两位 无法编辑
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        //相同长度 判断有几个字母不一致
        if(first.length()==second.length()){
            //超过一位不一致
            return findDiff(first,second)<=2;
        }
        //长度相差一位 只能保留一位操作新增 剩下的
        return findDiff(first,second)<=1;
    }

    private int findDiff(String first,String second){
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        int[] firstCharCount = new int[26];
        int[] secondCharCount = new int[26];
        for (char firstChar : firstChars) {
            firstCharCount[firstChar-'a']++;
        }
        for (char secondChar : secondChars) {
            secondCharCount[secondChar-'a']++;
        }
        int diff=0;
        for (int i = 0; i < 26; i++) {
            diff+=Math.abs(firstCharCount[i]-secondCharCount[i]);
        }
        return diff;
    }
}
