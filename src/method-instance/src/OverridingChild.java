public class OverridingChild extends OverridingParent {
    public OverridingChild(double a, double b) {
        super(a, b);
    }

    @Override
    public double area(){
        System.out.println("Inside area for OverridingChild");
        return dim1*dim2;
    }
}
