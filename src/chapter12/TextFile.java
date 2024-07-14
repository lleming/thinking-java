package chapter12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList {
  public TextFile(String filename) throws IOException {
    super(Arrays.asList(read(filename).split("\n")));
  }

  public static String read(String filename) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader in = new BufferedReader(new FileReader(filename));
    String s;
    while ((s = in.readLine()) != null) {
      sb.append(s).append('\n');
    }
    in.close();
    return sb.toString();
  }

  public static void write(String filename, String text) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(filename));
    out.print(text);
    out.close();
  }

  public static void main(String[] args) throws IOException {
    String file = read("src/chapter12/TextFile.java");
    write("test.txt", file);
    TextFile tf = new TextFile("test.txt");
    tf.write("test2.txt");
  }

  public void write(String filename) throws IOException {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
    for (int i = 0; i < size(); i++) {
      out.println(get(i));
    }
    out.close();
  }
}
