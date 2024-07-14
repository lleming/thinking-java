package chapter12;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*!Text, which is used for regular
expression. !*/
public class TheReplacement {
  public static void main(String[] args) throws IOException {
    String s = TextFile.read("src/chapter12/TheReplacement.java");
    // looking in special way comment block of text
    Matcher matcher = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
    if(matcher.find()){
      s = matcher.group(1); //found by bracket
      // replace 2 ro more spaces with single
      s.replace(" {2.}", " ");
      // delete spaces at the beginning of each line
      // need to enable MULTILINE mode
      s = s.replace("(?m)^ +", "");
      System.out.println(s);
      s = s.replaceFirst("[oueai]", "(Vowel)");
      StringBuffer sb = new StringBuffer();
      Pattern p = Pattern.compile("[oueai]");
      Matcher m= p.matcher(s);
      // handle found information
      // while replacing
      while (m.find()){
        m.appendReplacement(sb, m.group().toUpperCase());
      }
      // add the rest
      m.appendTail(sb);
      System.out.println(sb);
    }

  }
}
