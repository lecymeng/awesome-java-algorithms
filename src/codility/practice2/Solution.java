package codility.practice2;

/**
 * Created by Weicools on 2018/4/28.
 * <p>
 * desc:
 */
public class Solution {
  public int solution (int[] A, int X, int Y, int Z) {
    int currentCar = 0;
    int waitTime[] = new int[A.length];
    int XTime = 0, YTime = 0, ZTime = 0;
    boolean carFueled = false;
    while (currentCar < A.length) {
      if (XTime == 0) {
        if (X >= A[currentCar]) {
          XTime = A[currentCar];
          X -= A[currentCar];
          currentCar++;
          carFueled = true;
        }
      }
      if (currentCar == A.length) {
        break;
      }

      if (YTime == 0) {
        carFueled = false;
        if (Y >= A[currentCar]) {
          YTime = A[currentCar];
          Y -= A[currentCar];
          currentCar++;
          carFueled = true;
        }
      }
      if (currentCar == A.length) {
        break;
      }

      if (ZTime == 0) {
        carFueled = false;
        if (Z >= A[currentCar]) {
          ZTime = A[currentCar];
          Z -= A[currentCar];
          currentCar++;
          carFueled = true;
        }
      }
      if (currentCar == A.length) {
        break;
      }

      if (!carFueled && X < A[currentCar] && Y < A[currentCar] && Z < A[currentCar]) {
        return -1;
      }
      if (!carFueled) {
        for (int i = currentCar; i < waitTime.length; i++) {
          waitTime[i]++;
          System.out.print(waitTime[i] + ",");
        }
        System.out.println("");
      }
      XTime = Math.max(0, XTime - 1);
      YTime = Math.max(0, YTime - 1);
      ZTime = Math.max(0, ZTime - 1);
      carFueled = false;
    }
    int maxWaitTime = -1;
    //for (int i = 0; i < waitTime.length; i++) {
    for (int aWaitTime : waitTime) {
      maxWaitTime = Math.max(maxWaitTime, aWaitTime);
    }
    return maxWaitTime + 1;
  }

  public static void main (String[] args) {
    Solution solution = new Solution();
    int[] array = { 2, 8, 4, 3, 2 };
    System.out.println(solution.solution(array, 7, 11, 3));
  }
}
