package chapter12.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise5 {

  public static void main(String[] args) throws IOException {
    if (args.length < 2) {
      System.out.println("""
          Usage: java Exercise2 filename regex
          """);
      System.exit(1);
    }
    String filename = args[0];
    Pattern pattern = Pattern.compile(args[1]);
    File file = new File(filename);
    BufferedReader reader = new BufferedReader(new FileReader(file));

    String s;
    while ((s = reader.readLine()) != null) {
      Matcher m = pattern.matcher(s);
      if (m.find()) {
        System.out.println(s);
      }
    }
  }
}
