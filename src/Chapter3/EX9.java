package Chapter3;

public class EX9 {
    public static String reconnect(String[] args)
    {
        //思路，操作栈+数据栈 双栈法。每当遇到右括号，就把左边两个数据弹出栈
        //外加一个操作符合并成新字符串压入栈中
        Stack<String> ops = new Stack<>();
        Stack<String> vars = new Stack<>();
        for (String s : args)
        {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                ops.push(s);
            else if (s.equals(")"))
            {
                String firststring = vars.pop();
                String secondstring = vars.pop();
                String newstring = "(" + secondstring + ops.pop() + firststring + ")";
                vars.push(newstring);
            }
            else
                vars.push(s);
        }
        return vars.pop();
    }

    public static void main(String[] args) {
        reconnect(args);
    }
}
