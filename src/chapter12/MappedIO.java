package chapter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
  private static int numOfInts = 4_000_000;
  private static int numOfUnuffInts = 200_000;
  private static Tester[] tests = {
      new Tester("Write to stream") {
        @Override
        public void test() throws IOException {
          DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp.dos")));
          for (int i = 0; i < numOfInts; i++) {
            dos.writeInt(i);
          }
          dos.close();
        }
      },
      new Tester("Mapped write") {
        @Override
        public void test() throws IOException {
          FileChannel fc = new RandomAccessFile("temp.dos", "rw").getChannel();
          IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
          for (int i = 0; i < numOfInts; i++) {
            ib.put(i);
          }
          fc.close();
        }
      },
      new Tester("Read from stream") {
        @Override
        public void test() throws IOException {
          DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.dos")));
          int counter = 0;
          for (int i = 0; i < numOfInts; i++) {
            dis.readInt();
            counter++;
          }
          dis.close();
          System.out.println("Totatl ints:" + counter);
        }
      },
      new Tester("Read with mapped file") {
        @Override
        public void test() throws IOException {
          FileChannel fc = new FileInputStream("temp.dos").getChannel();
          IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
          int counter = 0;
          while (ib.hasRemaining()) {
            ib.get();
            counter++;
          }
          fc.close();
          System.out.println("Total count " + counter);
        }
      },
      new Tester("Stream read/write") {
        @Override
        public void test() throws IOException {
          RandomAccessFile raf = new RandomAccessFile(new File("temp.dos"), "rw");
          raf.writeInt(1);
          for (int i = 0; i < numOfUnuffInts; i++) {
            raf.seek(raf.length() - 4);
            ;
            raf.writeInt(raf.readInt());
          }
          raf.close();
        }
      },
      new Tester("Mapped read/write") {
        @Override
        public void test() throws IOException {
          FileChannel fc = new RandomAccessFile(new File("temp.dos"), "rw").getChannel();
          IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
          ib.put(0);
          for (int i = 0; i < numOfUnuffInts; i++) {
            ib.put(ib.get(i - 1));
          }
          fc.close();
        }
      }
  };

  public static void main(String[] args) {
    for (int i = 0; i < tests.length; i++) {
      System.out.println(tests[i].runTest());
    }
  }

  private abstract static class Tester {
    private String name;

    public Tester(String name) {
      this.name = name;
    }

    public long runTest() {
      System.out.print(name + ": ");
      try {
        long startTime = System.currentTimeMillis();
        test();
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

    }

    public abstract void test() throws IOException;
  }
}
