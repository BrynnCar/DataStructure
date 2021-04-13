package stack;

import array.Array;

/**
 * 使用动态泛型数组实现自定义栈
 * 栈：后进先出（LIFO）
 * @param <E>
 */
public class ArrayStack<E> implements IStack<E> {
    private Array<E> stack;

    public ArrayStack(int capacity) {
        stack = new Array<>(capacity);
    }

    public ArrayStack() {
        stack = new Array<>();
    }

    public int getCapacity() {
        return stack.getCapacity();
    }

    /**
     * 压栈
     * @param e
     */
    @Override
    public void push(E e) {
        stack.add(e);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public E pop() {
        return stack.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek() {
        return stack.getLast();
    }

    @Override
    public boolean isEmpty() {
        return stack.getSize() == 0;
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Stack{ capacity=");
        sBuilder.append(stack.getCapacity());
        sBuilder.append(", size=");
        sBuilder.append(stack.getSize());
        sBuilder.append(", data=[");
        for (int i = 0; i < stack.getSize(); i++) {
            sBuilder.append(stack.get(i));
            if (i != stack.getSize() - 1) {
                sBuilder.append(",");
            }
        }
        sBuilder.append("]}");
        return sBuilder.toString();
    }
}
