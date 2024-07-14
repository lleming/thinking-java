package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
  public static void main(String[] args) {
    String[] input = new String[] {
        "Java version 1.4 has regular expressions",
        "Regular expressions already in Java",
        "Java cut of ambiguousness"
    };
    Pattern p1 = Pattern.compile("gu\\w*");
    Pattern p2 = Pattern.compile("Java.*");
    for (int i = 0; i < input.length; i++) {
      System.out.println("input: " + i + ": " + input[i]);
      Matcher m1 = p1.matcher(input[i]);
      Matcher m2 = p2.matcher(input[i]);
      while (m1.find()) {
        System.out.println("m1.find()  '" + m1.group() + "' start = " + m1.start() + " end = " + m1.end());
      }
      while (m2.find()) {
        System.out.println("m2.find()  '" + m2.group() + "' start = " + m2.start() + " end = " + m2.end());
      }
      if (m1.lookingAt()) {
        System.out.println("m1.lookingAt() start = " + m1.start() + " end = " + m1.end());
      }
      if (m2.lookingAt()) {
        System.out.println("m2.lookingAt() start = " + m2.start() + " end = " + m2.end());
      }

      if (m1.matches()) {
        System.out.println("m1.matches()  start = " + m1.start() + " end = " + m1.end());
      }

      if (m2.matches()) {
        System.out.println("m2.matches()  start = " + m2.start() + " end = " + m2.end());
      }
    }
  }
}
