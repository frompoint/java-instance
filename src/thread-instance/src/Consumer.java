public class Consumer extends Thread {
    private CubbyHole cubbyHole;
    private int number;

    public Consumer(CubbyHole cubbyHole, int number) {
        this.cubbyHole = cubbyHole;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for(int i =0;i<10;i++){
            value = cubbyHole.get();
            System.out.println("消费者 #" + this.number+ " got: " + value);
        }
    }
}
