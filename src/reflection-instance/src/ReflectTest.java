import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Throwable {
        Car car1 = initByDefaultConst();
        Car car2 = initByParamConst();
        car1.introduce();
        car2.introduce();

    }

    private static Car initByParamConst() throws Throwable {
        //1.通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("Car");

        //2.获取类的带有参数的构造器对象
        Constructor cons = clazz.getDeclaredConstructor(new Class[]{String.class, String.class, int.class});

        //3.使参数的构造器对象实例化Car
        Car car = (Car) cons.newInstance(new Object[]{"宝马", "红色", 180});
        return car;
    }

    private static Car initByDefaultConst() throws Throwable {
        //1.通过类装载器获取Car类对象
        //使用当前线程获取类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //通过使用全限定类名来装载Car类对应的反射实例
        Class clazz = loader.loadClass("Car");

        //2.获取类的默认构造器对象并实例化Car
        //通过Car的反射类对象来获取Car的构造函数对象.
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        //通过构造函数对象的newInstance方法来实例化Car对象，其效果等同与new Car()
        Car car = (Car) cons.newInstance();

        //3.通过反射方法设置属性
        //通过Car的反射类对象的getMethod方法来获取相应的set方法对象.
        //第一个参数是目标class的方法，第二个参数是方法注册的对象类型
        Method setBrand = clazz.getMethod("setBrand", String.class);
        //通过invoke方法来调用目标类的方法
        //该方法的第一个参数是操作的目标类示例，第二个参数则是目标方法的主参
        setBrand.invoke(car, "奔驰");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }
}
