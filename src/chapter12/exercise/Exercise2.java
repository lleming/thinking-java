package chapter12.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Exercise2 {

  public static void main(String[] args) throws IOException {
    if(args.length < 1){
      System.out.println("""
          Usage: java Exercise2 filename
          """);
      System.exit(1);
    }
    String filename = args[0];
    File file = new File(filename);
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
