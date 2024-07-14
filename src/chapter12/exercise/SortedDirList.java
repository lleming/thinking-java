package chapter12.exercise;

import common.AlphabetComparator;
import java.io.File;
import java.util.Arrays;

public class SortedDirList {
  private String path;

  public SortedDirList(String path) {
    this.path = path;
  }

  public String[] list() {
    String[] dirs = new File(path).list();
    Arrays.sort(dirs, new AlphabetComparator());
    return dirs;
  }

  public String[] list(String regex) {
    String[] dirs = new File(path).list(new DirFilter(regex));
    Arrays.sort(dirs, new AlphabetComparator());
    return dirs;
  }

  public long size(String filename) {
    File f = new File(path + "/" + new File(filename).getName());
    if (f.isDirectory()) {
      return -1;
    }
    return f.length();
  }
}
