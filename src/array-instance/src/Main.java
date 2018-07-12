import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
        0x00. Java 实例 - 数组排序及元素查找
        Arrays.binarySearch方法使用前，需要对数组排序，才能定位值插入位置，因为binarySearch采用二分搜索法
        */
        int[] array = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        Arrays.sort(array);
        printArray("数组排序的结果为：", array);
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2 在第 " + index + " 个位置。");

        /*
        0x01. Java 实例 - 数组添加元素
        */
        array = insertElement(array, 1, index);
        printArray("数组添加元素 1", array);

        /*
        0x02. Java 实例 - 获取数组长度
        */
        String[][] data = new String[2][5];
        System.out.println("第一维数组长度: " + data.length);
        System.out.println("第二维数组长度: " + data[0].length);

        /*
        0x03. Java 实例 - 数组反转
        */
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        System.out.println("反转前排序：" + arrayList);
        Collections.reverse(arrayList);
        System.out.println("反转后排序：" + arrayList);

        /*
        0x04. Java 实例 - 数组输出
        */
        String[] runoobs = new String[3];
        runoobs[0] = "菜鸟教程";
        runoobs[1] = "菜鸟工具";
        runoobs[2] = "菜鸟笔记";
        for (int i = 0; i < runoobs.length; i++) {
            System.out.println(runoobs[i]);
        }

        /*
        0x05. Java 实例 - 数组获取最大和最小值
        Collections.min(）参数要求含有迭代器方法的集合
        */
        Integer[] numbers = {8, 2, 7, 1, 4, 9, 5};
        int min = Collections.min(Arrays.asList(numbers));
        int max = Collections.max(Arrays.asList(numbers));
        System.out.println("最小值: " + min);
        System.out.println("最大值: " + max);

        /*
        0x06. Java 实例 - 数组合并
        */
        String[] a = {"A", "B", "C"};
        String[] b = {"D", "E"};
        ArrayList list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        System.out.println(Arrays.toString(list.toArray()));

        /*
        0x07. Java 实例 - 数组填充
        */
        int[] array007 = new int[6];
        Arrays.fill(array007, 100);
        for (int i = 0, n = array007.length; i < n; i++) {
            System.out.println(array007[i]);
        }
        System.out.println();
        Arrays.fill(array007, 3, 6, 50);
        for (int i = 0, n = array007.length; i < n; i++) {
            System.out.println(array007[i]);
        }

        /*
        0x08. Java 实例 - 数组扩容
        */
        String[] names = {"A", "B", "C"};
        String[] extended = new String[5];
        extended[3] = "D";
        extended[4] = "E";
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String name : extended) {
            System.out.println(name);
        }

        /*
        0x09. Java 实例 - 查找数组中的重复元素
        */
        int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2};
        for (int i = 0; i < my_array.length; i++) {
            for (int j = i + 1; j < my_array.length; j++) {
                if (my_array[i] == my_array[j]) {
                    System.out.println("重复元素：" + my_array[i]);
                }
            }
        }

        /*
        0x0a. Java 实例 - 删除数组元素
        */
        ArrayList<String> objArray = new ArrayList<String>();
        objArray.clear();
        objArray.add(0, "第 0 个元素");
        objArray.add(1, "第 1 个元素");
        objArray.add(2, "第 1 个元素");
        System.out.println("数组删除元素前：" + objArray);
        objArray.remove(1);
        objArray.remove("第 0 个元素");
        System.out.println("数组删除元素后：" + objArray);

        /*
        0x0b. Java 实例 - 数组差集、交集、并集
        */
        ArrayList objArrayb = new ArrayList();
        ArrayList objArrayb2 = new ArrayList();
        objArrayb2.add(0, "common1");
        objArrayb2.add(1, "common2");
        objArrayb2.add(2, "notcommon");
        objArrayb2.add(3, "notcommon1");
        objArrayb.add(0, "common1");
        objArrayb.add(1, "common2");
        objArrayb.add(2, "notcommon2");
        System.out.println("array1 的元素" + objArrayb);
        System.out.println("array2 的元素" + objArrayb2);
//        objArrayb.removeAll(objArrayb2);
//        System.out.println("array1 与 array2 数组差集为：" + objArrayb);
//        objArrayb.retainAll(objArrayb2);
//        System.out.println("array2 & array1 数组交集为：" + objArrayb);
//        objArrayb.removeAll(objArrayb2);
//        objArrayb.addAll(objArrayb2);
//        System.out.println("array2 & array1 数组并集为：" + objArrayb);

        System.out.println("array2 & array1 数组并集为：" + Arrays.asList(union(objArrayb.toArray(), objArrayb2.toArray())));

        /*
        0x0c. Java 实例 - 查找数组中指定元素及判断数组是否相等
        */
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        ArrayList listc = new ArrayList(arr.length);
        for (int item : arr) {
            listc.add(item);
        }
        System.out.println("数组中是否存在元素3? ：" + listc.contains(3));
        System.out.println("数组 arr 是否与数组 arr1相等? ：" + Arrays.equals(arr, arr1));
        System.out.println("数组 arr1 是否与数组 arr2相等? ：" + Arrays.equals(arr1, arr2));
    }

    // 求两个字符串数组的并集，利用set的元素唯一性
    public static Object[] union(Object[] arr1, Object[] arr2) {
        Set<Object> set = new HashSet<Object>();

        for (Object str : arr1) {
            set.add(str);
        }

        for (Object str : arr2) {
            set.add(str);
        }

        String[] result = {};

        return set.toArray(result);
    }

    public static void printArray(String message, int[] array) {
        System.out.println(message + "：[length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static int[] insertElement(int[] original, int element, int index) {
        int length = original.length;
        int[] destionation = new int[length + 1];
        System.arraycopy(original, 0, destionation, 0, index);
        destionation[index] = element;
        System.arraycopy(original, index, destionation, index + 1, length - index);

        return destionation;
    }
}
