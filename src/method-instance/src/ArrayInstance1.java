/*
 * 打印数组元素
 */
public class ArrayInstance1 {
    public static void printArray(Object[] inputArray) {
        for (Object element : inputArray) {
            System.out.printf("%s ", element);
            System.out.println();
        }
    }
}