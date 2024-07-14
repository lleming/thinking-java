package chapter12.exercise;

import common.AlphabetComparator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Exercise6 {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("""
          Usage: java Exercise6 catalog regex
          """);
      System.exit(1);
    }
    String filename = args[0];
    String regex = args[1];
    File path = new File(filename);
    String[] list = path.list(new DirFilter(regex));

    Arrays.sort(list, new AlphabetComparator());

    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i]);
    }
  }
}


class DirFilter implements FilenameFilter {
  private Pattern pattern;

  DirFilter(String regex) {
    this.pattern = Pattern.compile(regex);
  }

  @Override
  public boolean accept(File dir, String name) {
    try {
      String path = dir.getAbsolutePath() + "/" + name;
      if(new File(path).isDirectory()){
        return false;
      }
      BufferedReader reader = new BufferedReader(new FileReader(path));
      String s;
      while ((s = reader.readLine()) != null) {
        if (pattern.matcher(s).find()) {
          return true;
        }
      }
      return false;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
