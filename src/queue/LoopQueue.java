package queue;

import java.util.Arrays;

/**
 * 循环队列，解决队列每次出队都要移动元素的弊端
 * 采用头尾索引记录队头队尾，减少元素移动
 * 队列满：(tail + 1) % data.length == front
 * 队列空： front == tail
 * 头索引： front = (front + 1) % data.length
 * 尾索引： tail = (tail + 1) % data.length
 *
 * @param <E>
 */
public class LoopQueue<E> implements IQueue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(1 << 4);
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length; //tail可能比front小，采用加一取模的方式计算
        size++;

    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue failed, LoopQueue is empty.");
        E target = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return target;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Dequeue failed, LoopQueue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail; // 队列为空
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("LoopQueue{capacity=");
        sBuilder.append(getCapacity());
        sBuilder.append(", size=");
        sBuilder.append(getSize());
        sBuilder.append(", data=front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sBuilder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sBuilder.append(",");
            }
        }
        sBuilder.append("]tail}");
        return sBuilder.toString();
    }
}
