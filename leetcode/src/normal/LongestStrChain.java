package normal;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStrChain {
    public static void main(String[] args) {
        LongestStrChain longestStrChain = new LongestStrChain();
        System.out.println(longestStrChain.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca", "c"}));
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int [] dp=new int[words.length];
        int ans=0;
        for(int i=1;i<words.length;i++)
            for(int j=0;j<i;j++)
                if(contains(words[i],words[j])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ans=Math.max(ans,dp[i]);
                }
        return 1+ans;

    }
    private boolean contains(String a, String b){
        //返回值b是否为a的前身
        //如果b是a的前身，必然满足b.length()+1=a.length()
        if(a.length()!=b.length()+1)
            return false;
        int i=0,j=0;
        while(i<a.length()&&j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        if(j==b.length())
            return true;
        return false;
    }
}
