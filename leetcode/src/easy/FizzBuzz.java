package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }
    public List<String> fizzBuzz(int n) {
        ArrayList<String> arr = new ArrayList<String>();
        for(int i =0;i<=n;i++){
            if(n>5&&n%3==0&&n%5==0){arr.add("FizzBuzz");}
            else if(n>=3&&n%3==0){arr.add("Fizz");}
            else if(n>=5&&n%5==0){arr.add("Buzz");}
            else{arr.add(i+"");}
        }
        return arr;
    }
}
