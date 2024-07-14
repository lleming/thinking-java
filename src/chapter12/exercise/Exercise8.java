package chapter12.exercise;

public class Exercise8 {
  public static void main(String[] args) {
    SortedDirList dl = new SortedDirList("src/chapter12");
    String[] dirs = dl.list();
    for (int i = 0; i < dirs.length; i++) {
      System.out.println(dirs[i]);
    }
  }
}
