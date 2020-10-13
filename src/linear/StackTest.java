package linear;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (String item : stack){
            System.out.println(item);
        }

        System.out.println("---------------");

        String result = stack.pop();

        System.out.println("弹出元素"+result);

        for (String item : stack){
            System.out.println(item);
        }

    }
}
