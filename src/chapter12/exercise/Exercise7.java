package chapter12.exercise;

import common.AlphabetComparator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Exercise7 {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("""
          Usage: java Exercise catalog regex
          """);
      System.exit(1);
    }
    String filename = args[0];
    String regex = args[1];
    File path = new File(filename).getAbsoluteFile();
    List files = findFiles(path, regex);
    files.sort(new AlphabetComparator());

    for (int i = 0; i < files.size(); i++) {
      System.out.println(files.get(i));
    }
  }

  private static List findFiles(File path, String regex) {
    List items = new ArrayList();
    String[] paths = path.list(new RecursiveDirFilter(regex));
    for (int i = 0; i < paths.length; i++) {
      String file = paths[i];
      File f = new File(path + "/" + file);
      if (f.isDirectory()) {
        items.addAll(findFiles(f, regex));
      } else {
        items.add(file);
      }
    }
    return items;
  }
}


class RecursiveDirFilter implements FilenameFilter {
  private Pattern pattern;

  RecursiveDirFilter(String regex) {
    this.pattern = Pattern.compile(regex);
  }

  @Override
  public boolean accept(File dir, String name) {
    try {
      String path = dir.getAbsolutePath() + "/" + name;
      if (new File(path).isDirectory()) {
        return true;
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
