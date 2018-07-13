import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LockBb implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + " LockB 开始执行");
            while (true) {
                if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + " LockB 锁住 obj2");
                    if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + " LockB 锁住 obj1");
                    } else {
                        System.out.println(new Date().toString() + " LockB 锁 obj2 失败");
                    }
                } else {
                    System.out.println(new Date().toString() + " LockB 锁 obj1 失败");
                }

                UnLockTest.a1.release();
                UnLockTest.a2.release();
                Thread.sleep(10 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
