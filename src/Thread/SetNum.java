package Thread;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Weicools on 2018/4/24.
 * <p>
 * desc:
 */
public class SetNum {
    public void setNum(int[] source,int[] array){
        Random rd = new Random();
        int range = array.length;
        for(int i = 0; i <array.length; i++){
            //随机产生一个位置
            int pos = rd.nextInt(range);
            //获取该位置的值
            array[i] = source[pos];
            //改良：将最后一个数赋给被删除的索引所对应的值
            source[pos] = source[range-1];
            //缩小随机数产生的范围
            range--;
        }
    }

    public static void main(String[] args) {
        SetNum s = new SetNum();
        int[] result = new int[100];
        int[] source = new int[100];
        for (int i = 1; i <= source.length; i++) {
            source[i-1] = i;
        }

        s.setNum(source, result);

        System.out.println(Arrays.toString(result));
    }
}
