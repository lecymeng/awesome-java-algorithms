package swordoffer.树;

/**
 * Created by Weicools on 2018/4/23.
 * <p>
 * desc:
 */
public interface ITest {
    default void testImpl() {
        System.out.println("interface default impl");
    }

    void print();
}
