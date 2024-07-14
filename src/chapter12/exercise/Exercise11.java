package chapter12.exercise;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise11 {

  private static final String line = "this is world of nothi9ng";
  private static Tester[] testers = new Tester[] {
      new Tester("None buffered") {
        @Override
        void runTest() throws IOException {
          byte[] buff = line.getBytes();
          FileOutputStream fos = new FileOutputStream("Exercise11-nonebuff.out");
          for (int i = 0; i < 1000_000; i++) {
            fos.write(buff);
          }
          fos.close();
        }
      },
      new Tester("Buffered") {
        @Override
        void runTest() throws IOException {
          byte[] buff = line.getBytes();
          BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("Exercise11-buff.out"));
          for (int i = 0; i < 1000_000; i++) {
            fos.write(buff);
          }
          fos.close();
        }
      }
  };

  public static void main(String[] args) throws IOException {
    for (int i = 0; i < testers.length; i++) {
      Tester tester = testers[i];
      tester.measure();
    }
  }

  abstract static class Tester {
    private final String name;

    Tester(String name) {
      this.name = name;
    }

    public void measure() throws IOException {
      long start = System.currentTimeMillis();
      runTest();
      long end = System.currentTimeMillis();
      System.out.println("total time spent: " + (end - start));
    }

    abstract void runTest() throws IOException;
  }
}


