import java.util.Collections;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        // 0x00. Java 实例 - 获取向量元素的索引值
        Vector v = new Vector();
        v.add("X");
        v.add("M");
        v.add("D");
        v.add("A");
        v.add("O");

        Collections.sort(v);
        System.out.println(v);
        int index = Collections.binarySearch(v, "D");
        System.out.println("元素索引值为：" + index);

        v = new Vector();
        v.add(new Double("3.4324"));
        v.add(new Double("3.3532"));
        v.add(new Double("3.342"));
        v.add(new Double("3.349"));
        v.add(new Double("2.3"));
        Object obj = Collections.max(v);
        System.out.println("最大元素是："+obj);

        System.out.println(v);
        Collections.swap(v, 0, 4);
        System.out.println("旋转后");
        System.out.println(v);
    }
}
