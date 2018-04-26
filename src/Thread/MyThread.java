package Thread;

/**
 * Created by Weicools on 2018/4/23.
 * <p>
 * desc:
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("run myThread");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread thread = new MyThread();
        thread.start();
    }
}
