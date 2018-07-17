import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) {
        //首先创建一个Book对象
        Book book = new Book();
        //在book对象中封装相应的数据
        book.setId(1);
        book.setName("走在人生边上");
        book.setType("散文");

        // show(Book.class);
        show(book);
    }

    private static void show(Class cl) {
        //获取Class对象中声明的所有属性信息，返回值为Field数组
        //此方法可以获取到所有的属性信息
        Field[] fields = cl.getDeclaredFields();
        //此方法只能获取到Class对象中的公有属性信息
        Field[] fields1 = cl.getFields();
        //遍历数组，取出属性信息
        for (Field ff : fields) {
            System.out.println("属性名称" + ff.getName() + "属性类型" + ff.getType());
        }
        System.out.println("---------------------------------");
        for (Field ff : fields1) {
            System.out.println("属性名称" + ff.getName() + "属性类型" + ff.getType());
        }
    }

    private static void show(Object ob) {
        //首先获取Class对象
        Class cl = ob.getClass();
        //获取属性数组
        Field[] fields = cl.getDeclaredFields();
        for (Field ff : fields) {
            //*非常重要，需要设置当前的私有属性可以被外部访问到
            ff.setAccessible(true);
            try {
                //获取当前实体类对象中的属性名称和对应的属性值
                System.out.println("属性名称==" + ff.getName() + "||" + "属性值==" + ff.get(ob));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
