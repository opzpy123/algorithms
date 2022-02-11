package test;

import linear.Stack;

/**
 * 括号匹配问题
 */
public class BracketMatchTest {
    public static void main(String[] args) {
        String str = "(上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(str+"  中的括号是否匹配:"+match);
    }

    /**
     * 判断str中的括号是否匹配
     * @param str
     * @return
     */
    public static boolean isMatch(String str){
        //1.创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();
        //2，从左往右遍历字符串
        for (int i = 0; i < str.length(); i++) {
            String currChar = str.charAt(i)+"";
            //3.判断当前字符是否为左括号，如果是，则把字符放入栈中
            if(currChar.equals("(")){
                chars.push(currChar);
            }else if(currChar.equals(")")){
                //4.继续判断当前字符是否有括号，如果是则弹出一个左括号
                //并判断结果为null,null?没有匹配：有匹配的左括号
                String pop = chars.pop();
                if(pop==null){
                    return false;
                }
            }
        }
        //5.判断栈中还有没有剩余的左括号，有？不匹配
        return  chars.isEmpty();

    }
}
