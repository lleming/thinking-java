package chapter12;

import common.AlphabetComparator;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {
  public static void main(String[] args) {
    File path = new File(".");
    String[] list;
    if (args.length == 0) {
      list = path.list();
    } else {
      list = path.list(new FilenameFilter() {
        private Pattern pattern = Pattern.compile(args[0]);

        @Override
        public boolean accept(File dir, String name) {
          return pattern.matcher(new File(name).getName()).matches();
        }
      });
    }
    Arrays.sort(list, new AlphabetComparator());
    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i]);
    }
  }
}
