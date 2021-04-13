package array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> integerArray = new Array<>();
        for (int i = 0; i < 15; i++) {
            integerArray.add(i);
        }
        System.out.println(integerArray);
        integerArray.add(15);
        System.out.println(integerArray);
        integerArray.add(16);
        System.out.println(integerArray);
        integerArray.remove(16);
        System.out.println(integerArray);
        integerArray.removeFirst();
        System.out.println(integerArray);
        integerArray.removeLast();
        System.out.println(integerArray);
        integerArray.removeElement(10);
        System.out.println(integerArray);
    }
}
