public class TwoThreadAlive extends Thread {

    public static void main(String[] args) {
        // 0x00. Java 实例 - 查看线程是否存活
        TwoThreadAlive  tt = new TwoThreadAlive();
        tt.setName("Main Thread");
        System.out.println("before start(), tt.isAlive()=" + tt.isAlive());
        tt.start();
        System.out.println("just after start(),tt.isAlive()=" + tt.isAlive());
        for (int i = 0; i < 10; i++) {
            tt.printMsg();
        }
        System.out.println("The end of main(), tt.isAlive()=" + tt.isAlive());
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        // 0x01. Java 实例 – 获取当前线程名称
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name=" + name);
    }
}
