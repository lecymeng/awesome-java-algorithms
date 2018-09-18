package codility;

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
    int[] car1 = { 2, 8, 4, 3, 2 };
    int[] car2 = { 6 };
    System.out.println(test.solution(car1, 7, 11, 3));
    System.out.println(test.solution(car2, 4, 0, 3));
  }

  private Dispenser dispenserX, dispenserY, dispenserZ;

  public int solution (int[] A, int X, int Y, int Z) {
    dispenserX = new Dispenser(X);
    dispenserY = new Dispenser(Y);
    dispenserZ = new Dispenser(Z);
    for (int i = 0; i < A.length; i++) {
      Dispenser dispenser = getSatisfiedDispenser(A[i]);
      if (dispenser == null) {
        return -1;
      }

      dispenser.delay += A[i];
    }

    int maxDelay = 0;
    if (dispenserX.delay > maxDelay) {
      maxDelay = dispenserX.delay;
    }
    if (dispenserY.delay > maxDelay) {
      maxDelay = dispenserY.delay;
    }
    if (dispenserZ.delay > maxDelay) {
      maxDelay = dispenserZ.delay;
    }

    return maxDelay;
  }

  private Dispenser getSatisfiedDispenser (int size) {
    List<Dispenser> list = new ArrayList<>();
    if (dispenserX.size >= size) list.add(dispenserX);
    if (dispenserY.size >= size) list.add(dispenserY);
    if (dispenserZ.size >= size) list.add(dispenserZ);
    Dispenser dispenser = null;
    for (Dispenser a : list) {
      if (dispenser == null || a.delay < dispenser.delay) {
        dispenser = a;
      }
    }

    return dispenser;
  }

  class Dispenser {
    int size;
    int delay;

    Dispenser (int size) {
      this.size = size;
      this.delay = 0;
    }
  }
}
