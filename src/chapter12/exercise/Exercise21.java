package chapter12.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise21 {
  public static void main(String[] args) {
    String input = "Arline ate eight apples and one orange while Anita hadn't any";
    Pattern pattern = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
    Matcher m = pattern.matcher(input);
    while (m.find()) {
      System.out.println(m.group());
    }
  }
}
