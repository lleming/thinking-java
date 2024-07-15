package chapter12.exercise;

import chapter12.TextFile;
import java.io.IOException;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise22 {
  public static void main(String[] args) throws IOException {
    if (args.length < 2 || args.length > 4) {
      System.out.println("Usage: java JGrep file regex multiline? case-insensitive");
      System.exit(0);
    }
    int multiline = 0;
    int caseInsensitive = 0;
    if (args.length == 4) {
      if (args[2].equals("multiline")) {
        multiline = Pattern.MULTILINE;
      } else if (args[2].equals("case-insensitive")) {
        caseInsensitive = Pattern.CASE_INSENSITIVE;
      }
      if (args[3].equals("multiline")) {
        multiline = Pattern.MULTILINE;
      } else if (args[3].equals("case-insensitive")) {
        caseInsensitive = Pattern.CASE_INSENSITIVE;
      }
    } else if (args.length == 3) {
      if (args[2].equals("multiline")) {
        multiline = Pattern.MULTILINE;
      } else if (args[2].equals("case-insensitive")) {
        caseInsensitive = Pattern.CASE_INSENSITIVE;
      }
    }
    int flag = multiline | caseInsensitive;
    Pattern p = Pattern.compile(args[1], flag);
    // moving over lines in the file
    ListIterator it = new TextFile(args[0]).listIterator();
    while (it.hasNext()) {
      Matcher m = p.matcher((String) it.next());
      while (m.find()) {
        System.out.println(it.nextIndex() + ": " + m.group() + ": " + m.start());
      }
    }
  }
}
