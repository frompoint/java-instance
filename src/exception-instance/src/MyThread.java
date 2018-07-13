public class MyThread extends Thread {
    public void run() {
        System.out.println("Throwing in " + "My Thread");
        throw new RuntimeException();
    }
}
