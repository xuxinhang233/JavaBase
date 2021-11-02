import java.util.concurrent.CountDownLatch;

/**
 * @Author: lenovo
 * @Date: 2021/11/2 10:04
 * @Desc: ++ 操作符是否安全
 *        i++和++i的线程安全分为两种情况：
 *          1、如果i是局部变量（在方法里定义的），那么是线程安全的。因为局部变量是线程私有的，别的线程访问不到，其实也可以说没有线程安不安全之说，因为别的线程对他造不成影响。
 *          2、如果i是全局变量，则同一进程的不同线程都可能访问到该变量，因而是线程不安全的，会产生脏读。
 *
 */
public class _16_AddAddIsSafe {
    static int count = 0;
    static CountDownLatch cdl = new CountDownLatch(1000);

    static class CountRunnable implements Runnable {
        private void count() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }

        @Override
        public void run() {
            count();
            cdl.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountRunnable countRunnable = new CountRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(countRunnable).start();
        }
        cdl.await();
        System.out.println(count);          // 1000 个线程，每个执行一次++，但结果大多不为 1000000
    }
}