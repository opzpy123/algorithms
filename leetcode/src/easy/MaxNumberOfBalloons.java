package easy;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
//        System.out.println(maxNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));
//        System.out.println(maxNumberOfBalloons.maxNumberOfBalloons("loonbalxballpoon"));
//        System.out.println(maxNumberOfBalloons.maxNumberOfBalloons("leetcode"));
        System.out.println(maxNumberOfBalloons.maxNumberOfBalloons("balon"));

    }
    public int maxNumberOfBalloons(String text) {
        //a b ll oo n
        int[]  arr =  new int[5];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            switch (ch){
                case 'a':arr[0]+=2;break;
                case 'b':arr[1]+=2;break;
                case 'l':arr[2]+=1;break;
                case 'o':arr[3]+=1;break;
                case 'n':arr[4]+=2;break;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : arr) {
            res=Math.min(res,i);
        }
        return res%2==0?res/2:(res-1)/2;
    }
}
