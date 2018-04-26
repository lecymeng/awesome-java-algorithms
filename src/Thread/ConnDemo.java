package Thread;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Weicools on 2018/4/24.
 * <p>
 * desc:
 */
public class ConnDemo {
    public static void main(String[] args) {
        String a = "aabbcyyyyyyyyyyy";
        HashMap<Integer, String> map = new HashMap<>();
        int j = 1;
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i + 1) == a.charAt(i)) {
                j++;
                if (i == a.length() - 2) {
                    map.put(j, String.valueOf(a.charAt(i)));
                }
            } else {
                map.put(j, String.valueOf(a.charAt(i)));
                j = 1;
            }
        }

        int[] key = new int[5];
        for (int i = 0; i < map.entrySet().size(); i++) {
            key[i] = map.entrySet().iterator().next().getKey();
        }

        System.out.println(Arrays.toString(key));
    }
}
