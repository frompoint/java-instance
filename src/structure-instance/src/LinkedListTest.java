import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        lList.addFirst("0");
        System.out.println(lList);
        lList.addLast("6");
        System.out.println(lList);

        System.out.println("链表的第一个元素是：" + lList.getFirst());
        System.out.println("链表的最后一个元素是：" + lList.getLast());

        lList.subList(2, 4).clear();
        System.out.println(lList);

        System.out.println("元素 2 第一次出现的位置：" + lList.indexOf("1"));
        System.out.println("元素 2 最后一次出现的位置："+ lList.lastIndexOf("1"));

        lList.set(2, "M");
        System.out.println(lList);
    }
}
