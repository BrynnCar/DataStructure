package stack;

public class StackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
