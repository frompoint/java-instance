public class MyThread extends Thread {
    boolean waitting = false;
    boolean ready = false;

    public void  setWaitting(boolean waitting){
        this.waitting = waitting;
    }

    MyThread() {
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        while (waitting)
            System.out.println("waiting...");
        startWait();

        try {
            Thread.sleep(1000);
        }
        catch(Exception exc) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " terminating.");
    }

    synchronized void startWait() {
        try {
            while (!ready) wait();
        } catch (InterruptedException exc) {
            System.out.println("wait() interrupted");
        }
    }

    synchronized void notice(){
        ready = true;
        notify();
    }
}
