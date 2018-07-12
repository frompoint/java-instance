public class Main {
    enum Car {
        lamborghini, tata, audi, fiat, honda
    }

    enum CarNew {
        lamborghini(900), tata(2), audi(50), fiat(15), honda(12);
        private int price;

        CarNew(int p) {
            price = p;
        }

        int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        /*
        0x00. 方法重载(Overloading)
        */
        OverloadingInstance instance = new OverloadingInstance(4);
        instance.info();
        instance.info("重载方法");
        new OverloadingInstance(); //重载构造函数

        /*
        0x01. 打印数组元素
        */
        Integer[] integerArray = {1, 2, 3, 4, 5, 6};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
        System.out.println("输出整型数组:");
        //new ArrayInstance().printArray(integerArray);
        ArrayInstance1.printArray(integerArray);
        System.out.println("\n输出双精度型数组:");
        //new ArrayInstance().printArray(doubleArray);
        ArrayInstance1.printArray(doubleArray);
        System.out.println("\n输出字符型数组:");
        //new ArrayInstance().printArray(characterArray);
        ArrayInstance1.printArray(characterArray);

        /*
        0x02. 汉诺塔算法
        */
        int nDisks = 2;
        doTowers(nDisks, 'A', 'B', 'C');

        /*
        0x03. 斐波那契数列
        */
        for (int i = 0; i < 11; i++) {
            System.out.printf("Fibonacci of %d is: %d\n",
                    i, fibonacci(i));
        }

         /*
        0x03. 阶乘
        */
        for (int i = 0; i < 11; i++) {
            System.out.printf("%d! =  %d\n",
                    i, factorial(i));
        }

        /*
        0x04. 方法重写
        */
        OverridingParent parent = new OverridingParent(10, 10);
        OverridingChild child = new OverridingChild(9, 5);
        System.out.println("Area is :" + parent.area());
        System.out.println("Area is :" + child.area());

        /*
        0x05. instanceOf
         */
        System.out.println("对象是 OverridingParent 类的实例？：" + (child instanceof OverridingParent));
        System.out.println("对象是 OverridingChild 类的实例？：" + (child instanceof OverridingChild));

        /*
        0x06. Enum（枚举）构造函数及方法的使用
        */
        System.out.println("所有汽车的价格：");
        for (CarNew c : CarNew.values())
            System.out.println(c + " 需要 "
                    + c.getPrice() + " 千美元。");

        /*
        0x07. 可变参数
        */
        int sum = 0;
        sum = sumvarargs(new int[]{10, 12, 33});
        System.out.println("数字相加之和为: " + sum);
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk " + topN + "  from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

    public static long fibonacci(long number) {
        if (number < 2) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static long factorial(long number) {
        if (number < 2) {
            return number;
        }
        return number * factorial(number - 1);
    }

    public static int sumvarargs(int... intArrays) {
        int sum, i;
        sum = 0;
        for (i = 0; i < intArrays.length; i++) {
            sum += intArrays[i];
        }
        return (sum);
    }
}
