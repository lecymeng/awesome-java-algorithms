package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Weicools on 2018/4/23.
 * <p>
 * desc:
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 233;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        try {
            MyCallable mc = new MyCallable();
            FutureTask<Integer> task = new FutureTask<>(mc);
            Thread thread = new Thread(task);
            thread.start();
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
