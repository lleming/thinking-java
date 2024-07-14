package chapter12;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompress {
  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("""
          Usage: 
          GZIPCompress file
          using method GZIP to compressfile into archive "test.gz
          """);
      System.exit(1);
    }
    BufferedReader in = new BufferedReader(new FileReader(args[0]));
    BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
    System.out.println("Writing file");
    int c;
    while ((c = in.read()) != -1) {
      System.out.println(c);
      out.write(c);
    }
    in.close();
    out.close();
    System.out.println("Reading file");
    BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
    String s;
    while ((s = in2.readLine()) != null) {
      System.out.println(s);
    }
  }
}
