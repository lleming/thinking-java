package chapter12;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ReplacingStringTokenizer {
  public static void main(String[] args) {
    String input = "I am still alive!!! And i am so happy";
    StringTokenizer stoke = new StringTokenizer(input);
    while (stoke.hasMoreElements()) {
      System.out.println(stoke.nextToken());
    }
    System.out.println(Arrays.asList(input.split(" ")));
  }
}
