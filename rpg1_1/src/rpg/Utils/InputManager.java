package rpg.Utils;

import java.util.Random;
import java.util.Scanner;

public class InputManager {
  private static final Scanner sc = new Scanner(System.in);
  private static Random rd = new Random();
  public static String getValue(String msg) {
    System.out.print(msg);
    return sc.next();
  }//eom

  public static int getValue(String msg, int start, int end) {
    while (true) {
      System.out.print(msg);
      int val = 0;
      try {
        val = sc.nextInt();
        if (val < start || val > end) {
          System.out.printf("[%d~%d] 사이의 값 입력%n", start, end);
          continue;
        }
        return val;
      } catch (Exception e) {
        System.out.println("정수값을 입력해주세요");
        sc.nextLine();
      }
    }//eow
  }//eom
  public static void setDelay(int time){
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  public static int getRdNum(int start, int end){
    return rd.nextInt(end) + start;
  }

}
