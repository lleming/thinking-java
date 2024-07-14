package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("""
          Usage:
          java TestReguralExpression charSequence regex
          """);
      System.exit(0);
    }
    for (int i = 0; i < args.length; i++) {
      System.out.println("Regular expression \"" + args[i] + "\"");
      Pattern pattern = Pattern.compile(args[i]);
      Matcher m = pattern.matcher(args[0]);
      while (m.find()) {
        System.out.println("Match \"" + m.group() + "\" in position " + m.start() + "-" + (m.end() - 1));
      }
    }
  }
}
