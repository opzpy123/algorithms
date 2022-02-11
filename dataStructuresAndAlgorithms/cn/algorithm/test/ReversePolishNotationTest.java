package test;

import linear.Stack;

/**
 * 逆波兰表达式
 */
public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式 3*(17-15)+18/6的逆波兰表达式如下
        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        int  result = caculate(notation);
        System.out.println("逆波兰表达式的结果为:"+result);
    }

    /**
     * 逆波兰表达式的数组表示方式
     * @param nataion
     * @return
     */
    public static int caculate(String[] nataion){
        //1.定义一个栈，用来存储操作数
        Stack<Integer> oprands = new Stack<>();
        //2.从左往右遍历表达式，得到每一个元素
        for (int i = 0; i < nataion.length; i++) {
            String curr = nataion[i];
            //3，判断当前元素是运算符还是操作数
            Integer o1;
            Integer o2;
            //4.运算符，从栈中弹出两个操作数，完成运算，运算完的结果压入栈中
            switch (curr){
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2+o1);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2-o1);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2*o1);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2/o1);
                    break;
                default:
                    //5，操作数，把该操作数放入栈中
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        //6.得到栈中最后一个元素，就是逆波兰表达式的结果
        int result =oprands.pop();
        return result;
    }
}
