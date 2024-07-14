package chapter12;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {
  public static void main(String[] args) {
    String input = "This is!!Not usual usage of!!symbols!!in sentence.";
    System.out.println(Arrays.asList(Pattern.compile("!!").split(input)));
    // only first three
    System.out.println(Arrays.asList(Pattern.compile("!!").split(input, 3)));
    System.out.println(Arrays.asList("There is!Builtin splitter!in string class!is present".split("!")));
  }
}
