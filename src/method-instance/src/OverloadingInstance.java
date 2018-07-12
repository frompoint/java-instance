/*
 * 方法重载(Overloading): 如果有两个方法的方法名相同，但参数不一致，哪么可以说一个方法是另一个方法的重载。
 * 方法名相同
 * 方法的参数类型，参数个不一样
 * 方法的返回类型可以不相同
 * 方法的修饰符可以不相同
 * main 方法也可以被重载
 */
public class OverloadingInstance {
    private int height;

    public OverloadingInstance() {
        System.out.println("无参构造函数");
        height = 1;
    }

    public OverloadingInstance(int h) {
        System.out.println("房子的高度为 " + h + " 米");
        height = h;
    }

    public void info() {
        System.out.println("房子的高度为 " + height + " 米");
    }

    protected void info(String name) {
        System.out.println(name + ": 房子的高度为 " + height + " 米");
    }
}
