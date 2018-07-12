/*
 *方法重载(Overloading)：如果有两个方法的方法名相同，但参数不一致，哪么可以说一个方法是另一个方法的重载。
 *方法覆盖（Overriding）：如果在子类中定义一个方法，其名称、返回类型及参数签名正好与父类中某个方法的名称、返回类型及参数签名相匹配，那么可以说，子类的方法覆盖了父类的方法。
 */
public class OverridingParent {
    double dim1;
    double dim2;

    public OverridingParent(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    public double area(){
        System.out.println("Inside area for OverridingParent");
        return dim1*dim2;
    }
}
