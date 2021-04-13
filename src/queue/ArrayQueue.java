package queue;

import array.Array;
import com.sun.org.apache.xml.internal.serializer.ToSAXHandler;

/**
 * 队列：先进先出（FIFO）
 *
 * @param <E>
 */
public class ArrayQueue<E> implements IQueue<E> {
    private Array<E> queue;

    public ArrayQueue(int capacity) {
        queue = new Array<>(capacity);
    }

    public ArrayQueue() {
        queue = new Array<>();
    }

    public int getCapacity() {
        return queue.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        queue.add(e);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    @Override
    public E getFront() {
        return queue.getFirst();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Queue{capacity=");
        sBuilder.append(queue.getCapacity());
        sBuilder.append(", size=");
        sBuilder.append(queue.getSize());
        sBuilder.append(", data=front[");
        for (int i = 0; i < queue.getSize(); i++) {
            sBuilder.append(queue.get(i));
            if (i != queue.getSize() - 1) {
                sBuilder.append(",");
            }
        }
        sBuilder.append("]tail}");
        return sBuilder.toString();
    }
}
