package chapter12.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Exercise1 {
  public static void main(String[] args) throws IOException {
    File file = new File("src/chapter12/exercise/Exercise1.java");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    LinkedList list = new LinkedList();
    String s;
    while ((s = reader.readLine()) != null) {
      list.add(s);
    }
    while (!list.isEmpty()) {
      System.out.println(list.pollLast());
    }
  }
}
