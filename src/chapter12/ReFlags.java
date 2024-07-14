package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReFlags {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("^Java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    Matcher m = p.matcher("""
        regular expression is present in java
        Java has regular expression
        JAVA having, regular expression for good
        ReGuLaR ExPrEsSiOnS pReSeNt In JaVa
        """);
    while(m.find()){
      System.out.println(m.group());
    }
  }
}
