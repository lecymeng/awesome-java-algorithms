package SwordOffer.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Weicools on 2018/4/23.
 * <p>
 * desc:
 */
public class TestDefault implements ITest {
    @Override
    public void print() {
        System.out.println("interface impl");
    }

    public static void main(String[] args) {
        TestDefault testDefault = new TestDefault();
        testDefault.print();
        testDefault.testImpl();

        // `System.exit(0);`是终止Java虚拟机JVM的，连JVM都停止了，所有都结束了，当然finally语句也不会被执行到
        try {
            System.out.println("92");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("123");
        }

        List list = Collections.synchronizedList(new ArrayList<>());
    }
}
