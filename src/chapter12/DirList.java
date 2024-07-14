package chapter12;

import common.AlphabetComparator;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
  public static void main(String[] args) {
    File path = new File(".");
    String[] list;
    if (args.length == 0) {
      list = path.list();
    } else {
      list = path.list(new DirFilter(args[0]));
    }

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
    String f = new File(name).getName();
    return pattern.matcher(new File(name).getName()).matches();
  }
}
