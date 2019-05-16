package Chapter3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("+")) stack.push(s);  //如果是运算符，压入栈中
            else if (s.equals("*")) stack.push(s);
            else if (s.equals("-")) stack.push(s);
            else if (s.equals("(")) StdOut.print(""); //如果是左括号，直接忽略
            else if (s.equals(")")) StdOut.print(stack.pop()+ " "); //如果是右括号，取出运算符
            else StdOut.print(s+" ");
        }
        StdOut.println();
    }
}
