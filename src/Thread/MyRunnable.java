package Thread;

/**
 * Created by Weicools on 2018/4/23.
 * <p>
 * desc:
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("run myRunnable");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
