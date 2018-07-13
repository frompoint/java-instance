public class Main {

    public static void main(String[] args) {
        // 0x00. Java 实例 - 异常处理方法
        try {
            // throw new Exception("My Exception.");
        } catch (Exception e) {
            System.err.println("Caught Exception");
            System.err.println("getMessage():" + e.getMessage());
            System.err.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.err.println("toString():" + e);
            System.err.println("printStackTrace():");
            e.printStackTrace();
        }

        // 0x01. Java 实例 - 多线程异常处理 (wait learn thread)
        try {
            MyThread t = new MyThread();
            t.start();

            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Caught it" + e);
        }

        // 0x02. Java 实例 - 链试异常
        int n = 20, result = 0;
        try {
            result = n / 0;
            System.out.println("结果为" + result);
        } catch (ArithmeticException ex) {
            System.out.println("发算术异常: " + ex);
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException ex1) {
                System.out.println("手动抛出链试异常 : " + ex1);
            }
        }

        // 0x03. Java 实例 - 自定义异常
        try {
            throw new CustomException("抛出自定义异常");
        } catch (CustomException cex) {
            System.out.println(cex.getMessage());
        }

        System.out.println("Exsiting Main");
    }
}
