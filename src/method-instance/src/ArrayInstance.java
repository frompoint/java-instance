/*
 * 打印数组元素
 */
public class ArrayInstance<T> {
    public void printArray(T[] inputArray) {
        for (T element : inputArray) {
            System.out.printf("%s ", element);
            System.out.println();
        }
    }
}
