package chapter12.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Exercise3 {
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
    ArrayList list = new ArrayList();
    String s;
    int counter = 1;
    while ((s = reader.readLine()) != null) {
      list.add(counter++ + ": " + s);
    }
    BufferedWriter writer = new BufferedWriter(new FileWriter("Exercise2.out"));
    Iterator it = list.iterator();
    while (it.hasNext()) {
      writer.write((String) it.next());
      writer.write('\n');
    }
    writer.close();
  }
}
