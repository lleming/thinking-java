package chapter12;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

public class AvailableCharsets {
  public static void main(String[] args) {
    Map charSets = Charset.availableCharsets();
    Iterator it = charSets.keySet().iterator();
    while (it.hasNext()) {
      String csName = (String) it.next();
      System.out.println(csName);
      Iterator aliases = ((Charset) charSets.get(csName)).aliases().iterator();
      if (aliases.hasNext()) {
        System.out.print(": ");
      }
      while (aliases.hasNext()) {
        System.out.print(aliases.next());
        if (aliases.hasNext()) {
          System.out.print(", ");
        }
      }
    }
    System.out.println();
  }
}
