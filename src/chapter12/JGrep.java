package chapter12;

import java.io.IOException;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
  public static void main(String[] args) throws IOException {
    if (args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }
    Pattern p = Pattern.compile(args[1]);
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
