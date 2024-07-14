package chapter12.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise4 {

  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      System.out.println("""
          Usage: java Exercise2 filename
          """);
      System.exit(1);
    }
    String filename = args[0];
    File file = new File(filename);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String s;
    while ((s = reader.readLine()) != null) {
      System.out.println(s.toUpperCase());
    }

  }
}
