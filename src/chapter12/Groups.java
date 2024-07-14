package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
  static public final String poem = """
      Twas brillig, and the slithy toves
      Did gyre and gimble in the wabe
      All mimsy were the borogoves.
      And the mome raths outgrabe.
      
      Beware the Jabberwock, my son
      The jaws that bite, the claws that catch. 
      Beware the Jubjub bird, and shun
      The frumious Bandersnatch.""";

  public static void main(String[] args) {
    Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(poem);
    while (m.find()) {
      for (int i = 0; i <= m.groupCount(); i++) {
        System.out.print("[" + m.group(i) + "]");
      }
      System.out.println();
    }
  }
}
