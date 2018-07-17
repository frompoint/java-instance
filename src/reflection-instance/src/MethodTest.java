import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    public static void main(String[] args) {
        //首先新建一个Book对象
        Book book = new Book();
        book.setId(2);
        book.setName("活着");
        book.setType("小说");

        // show(book);
        showUse(book);
    }

    private static void show(Object ob) {
        //首先获取Class对象
        Class cl = ob.getClass();
        //获取所有方法
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("方法名称==" + m.getName());
            System.out.println("方法返回值类型==" + m.getReturnType());
            System.out.println("方法修饰符标号==" + m.getModifiers());
            System.out.println("方法修饰符==" + Modifier.toString(m.getModifiers()));
            System.out.println("方法的注解信息为");
            Annotation[] annotations = m.getDeclaredAnnotations();
            for (Annotation a : annotations) {
                System.out.print(a.toString());
            }
            System.out.println("方法的参数列表为");
            Class[] cl1 = m.getParameterTypes();
            for (Class cll : cl1) {
                System.out.print(" " + cll.getName());
            }
        }
    }

    private static void showUse(Object object) {
        //获取Class对象
        Class cl = object.getClass();
        try {
            //获取对应方法，传入方法名和方法参数,方法参数为Class数组
            Method m1 = cl.getMethod("setName", String.class);
            //执行该方法,第一个参数为执行该对象的对象，
            // 第二个参数为方法的参数,方法参数为Object数组
            m1.invoke(object, "悲惨的世界");

            Method m2 = cl.getMethod("getName", null);
            m2.invoke(object, new Object[0]);

            Method m3 = cl.getMethod("test", new Class[]{String.class, int.class});
            m3.invoke(object, new Object[]{"哈哈哈", 8});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
