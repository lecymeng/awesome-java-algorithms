package Thread;

/**
 * Created by Weicools on 2018/4/24.
 * <p>
 * desc:
 */
public class TestNum {
    public static void main(String[] args) {
        int i, j, sum;
        System.out.println("1000之内的所有完数:");
        for (i = 6; i < 1000; i++) {
            sum = 0;
            for (j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum = sum + j;
                }
            }

            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
