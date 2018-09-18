package codility.practice2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weicools on 2018/4/28.
 * <p>
 * desc:
 */
public class Test {
  public static void main (String[] args) {
    Test test = new Test();
    int[] car = { 2, 8, 4, 3, 2 };
    int[] car2 = { 5 };
    System.out.println(test.solution(car, 7, 11, 3));
    System.out.println(test.solution(car2, 4, 0, 3));
  }

  private static final int IDLE = 0;
  private static final int USING = 1;

  public int solution (int[] A, int X, int Y, int Z) {
    List<Dispenser> disList = new ArrayList<>();
    disList.add(new Dispenser(X));
    disList.add(new Dispenser(Y));
    disList.add(new Dispenser(Z));
    for (int i = 0; i < A.length; i++) {
      Dispenser dispenser = getSatisfiedDispenser(A[i], disList);
      if (dispenser == null) {
        return -1;
      }

      if (dispenser.status == IDLE) {
        dispenser.status = USING;
      }

      dispenser.delay += A[i];
    }

    int maxDelay = 0;
    for (Dispenser aDispenser : disList) {
      if (aDispenser.delay > maxDelay) {
        maxDelay = aDispenser.delay;
      }
    }

    return maxDelay;
  }

  private Dispenser getSatisfiedDispenser (int needSize, List<Dispenser> disList) {
    int minDelay = Integer.MAX_VALUE;
    Dispenser minDelayDispenser = null;
    for (Dispenser aDispenser : disList) {
      if (aDispenser.size >= needSize && aDispenser.status == IDLE) {
        return aDispenser;
      }

      if (aDispenser.size >= needSize && aDispenser.delay < minDelay) {
        minDelayDispenser = aDispenser;
        minDelay = aDispenser.delay;
      }
    }

    if (minDelayDispenser != null) {
      return minDelayDispenser;
    }
    return null;
  }

  static class Dispenser {
    int size;
    int delay;
    int status;

    Dispenser (int size) {
      this.size = size;
      this.delay = 0;
      this.status = IDLE;
    }
  }
}



