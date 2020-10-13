package linear;

public class BracketMatch {

    public static void main(String[] args) {
        String str = "(上海(长安)())";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配"+match);
    }

    public static boolean isMatch(String str){
        //创建栈对象，用来存储左括号
        Stack<String> chars = new Stack<>();
        //从左往右遍历字符串
        for (int i =0;i<str.length();i++){
            String currChar = str.charAt(i) + "";
            //判断当前字符是否为左括号，如果是，放入栈中
            if (currChar.equals("(")){
                chars.push(currChar);
            }else if (currChar.equals(")")){
                //继续判断当前字符是否为右括号，如果是，则弹出一个左括号，并判断弹出结果是否为null
                String pop = chars.pop();
                if (pop==null){
                    return false;
                }
            }
        }
        //判断栈中是否还有剩余的左括号
        if (chars.size()==0){
            return true;
        }else {
            return false;
        }

    }
}
