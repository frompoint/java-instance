import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        String str = "Hello World";
        String anotherString = "hello world";
        Object objStr = str;

        /*
        0x00. Java 实例 – 字符串比较
        compareTo() 方法的实现思路：两个字符数组依次从头开始比较，
        如果对象位置出现字符不同则返回两个字符的编码之差，后面的字符不再比较；
        如果两个字符数组的长度不一样，并且较短的数组和较长数组所有对应位置的字符都相同，则返回两个数组的长度之差。
        */
        System.out.println(str.compareTo(anotherString));
        System.out.println(str.compareToIgnoreCase(anotherString));
        System.out.println(str.compareTo(objStr.toString()));

        /*
        0x01. 查找字符串最后一次出现的位置
        */
        String strOrig = "Hello world, Hello SnailDev";
        int lastIndex = strOrig.lastIndexOf("SnailDev");
        if (lastIndex == -1) {
            System.out.println("没有找到字符串 SnailDev");
        } else {
            System.out.println("SnailDev 字符串最后出现的位置：" + lastIndex);
        }

        /*
        0x02. Java 实例 - 删除字符串中的一个字符
        */
        str = "this is Java";
        System.out.println(removeCharAt(str, 3));

        /*
        0x03. Java 实例 - 字符串替换
        */
        str = "Hello World";
        System.out.println(str.replace('H', 'W'));
        System.out.println(str.replaceFirst("He", "Wa"));
        System.out.println(str.replaceAll("He", "Ha"));

        /*
        0x04. Java 实例 - 字符串反转
        */
        str = "SnailDev";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println("字符串反转前：" + str);
        System.out.println("字符串反转后：" + reverse);

        /*
        0x05. Java 实例 - 字符串搜索
        */
        strOrig = "Google SnailDev TaoBao";
        int index = strOrig.indexOf("SnailDev");
        if (index == -1) {
            System.out.println("没有找到字符串SnailDev");
        } else {
            System.out.println("SnailDev 字符串的位置是：" + index);
        }

        /*
        0x06. Java 实例 - 字符串分割 Split/StringTokenizer
        */
        str = "www-snaildev-com";
        String[] temp = str.split("-");
        // 普通for循环
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

        str = "www.snaildev.com";
        temp = str.split("\\.");
        // 增强型for循环
        for (String item : temp) {
            System.out.println(item);
        }

        StringTokenizer st = new StringTokenizer(str, ".");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(str, ".");
        while (st1.hasMoreElements()) {
            System.out.println(st1.nextElement());
        }

        /*
        0x07. Java 实例 - 字符串大小写转换
        */
        System.out.println("原始字符串为：" + str);
        System.out.println("转化为大写为：" + str.toUpperCase());
        System.out.println("转化为小写为：" + str.toUpperCase().toLowerCase());

        /*
        0x08. Java 实例 - 测试两个字符串区域是否相等
        */
        String first_str = "Welcome to Microsoft.";
        String second_str = "I work with microsoft.";
        boolean match1 = first_str.regionMatches(11, second_str, 12, 9);
        boolean match2 = first_str.regionMatches(true, 11, second_str, 12, 9);
        System.out.println("区分大小写返回值：" + match1);
        System.out.println("不区分大小写返回值：" + match2);

        /*
        0x09. Java 实例 - 字符串性能比较测试
        */
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s1 = "hello";
            String s2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("通过 String 关键词创建字符串：%d 毫秒", endTime - startTime));

        long startTime1 = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            String s3 = new String("hello");
            String s4 = new String("hello");
        }
        long endTime1 = System.nanoTime();
        System.out.println(String.format("通过 String 对象创建字符串：%d 纳秒", endTime1 - startTime1));

        /*
        0x0a. Java 实例 - 字符串优化 String.intern()
        */
        String[] varArr = new String[500000];
        for (int i = 0; i < varArr.length; i++) {
            varArr[i] = "s" + i;
        }

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < varArr.length; i++) {
            varArr[i] = "hello";
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("直接使用字符串：" + (endTime2 - startTime2) + " ms");

        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < varArr.length; i++) {
            varArr[i] = new String("hello");
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("使用 new 关键字：" + (endTime3 - startTime3) + " ms");

        long startTime4 = System.currentTimeMillis();
        for (int i = 0; i < varArr.length; i++) {
            varArr[i] = new String("hello");
            varArr[i] = varArr[i].intern();
        }
        long endTime4 = System.currentTimeMillis();
        System.out.println("使用字符串对象的 intern() 方法：" + (endTime4 - startTime4) + " ms");

        /*
        0x0b. Java 实例 - 字符串格式化
        */
        double e = Math.E;
        System.out.format("%f%n", e);
        System.out.format(Locale.CHINA, "%-10.4f%n%n", e);

        /*
        0x0c. Java 实例 - 连接字符串
        认知：+"为每个字符串变量赋值，公用一个内值，占用一份内存空间；"StringBuffer"每次新建一个新对象，内存分配新的空间，新分配5000份内存空间；
        */
        long startTime5 = System.currentTimeMillis();
        String resStr = "";
        for (int i = 0; i < 5000; i++) {
            resStr += "This is"
                    + "testing the"
                    + "difference" + "between"
                    + "String" + "and" + "StringBuffer";
        }
        long endTime5 = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 + 操作符 : "
                + (endTime5 - startTime5) + " ms");
        long startTime6 = System.currentTimeMillis();
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            resBuilder.append("This is");
            resBuilder.append("testing the");
            resBuilder.append("difference");
            resBuilder.append("between");
            resBuilder.append("String");
            resBuilder.append("and");
            resBuilder.append("StringBuffer");
        }
        long endTime6 = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 StringBuffer : "
                + (endTime6 - startTime6) + " ms");
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
