package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 自定义动态泛型数组
 *
 * @param <E>
 */
public class Array<E> {
    //默认容量
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    private E[] data;
    private int size;

    /**
     * 构造方法
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法（默认容量16）
     */
    public Array() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * 获取数组中已经存储的元素个数
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return data.length
     */
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定index索引位置添加元素e
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index invalid.");
        }
        //当size == data.length时，说明数组已经满了，进行扩容为原来的两倍
        if (size == data.length) {
            resize(data.length * 2);
        }
        //向index位置添加元素，需要将[index, size）位置的元素全部向后移动一个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组中添加元素e
     *
     * @param e
     */
    public void add(E e) {
        add(size, e);
    }

    /**
     * 向数组的第零个位置添加元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return E
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is invalid.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, index is invalid.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        for (int i = size; i > 0; i--) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中是否含有元素e, 并返回第一个索引
     *
     * @param e
     * @return index
     */
    public int find(E e) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中index索引位置的元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, index is invalid.");
        }
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("remove failed, Array is empty.");
        }
        //删除时，需要将[index+1, size）位置的元素向前移动一位
        E target = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size] = null;
        size--;
        //删除到一定程度时需要缩容，减少内存控件浪费
        //当容量==1/4容量时，将容量缩减为原来的一般
        //1/4时进行缩容，是为了减少当元素在1/2容量上下浮动时的频繁扩容缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return target;
    }

    /**
     * 删除数组中的第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中的最后一个位置的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 扩容函数
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array{size=");
        stringBuilder.append(size);
        stringBuilder.append("; data=[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
