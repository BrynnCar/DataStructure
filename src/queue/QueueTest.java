package queue;

public class QueueTest {
    public static void main(String[] args) {
        testArrayQueue();
        testLoopQueue();
    }

    public static void testArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }

    public static void testLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 15; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println(loopQueue);
    }
}
