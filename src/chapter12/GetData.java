package chapter12;

import java.nio.ByteBuffer;

public class GetData {
  private static final int BSIZE = 1024;

  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.allocate(BSIZE);
    // when buffer allocated it is filled with zero
    int i = 0;
    while (i++ < bb.limit()) {
      if (bb.get() != 0) {
        System.out.println("Not zero");
      }
    }
    System.out.println("i = " + i);
    bb.rewind();
    // read as char
    bb.asCharBuffer().put("Hello");
    char c;
    while ((c = bb.getChar()) != 0) {
      System.out.println(c + " ");
    }
    bb.rewind();
    // read as short
    bb.asShortBuffer().put((short) 471142);
    System.out.println(bb.getShort());
    bb.rewind();
    // read as int
    bb.asIntBuffer().put(99471142);
    System.out.println(bb.getInt());
    bb.rewind();
    // read as long
    bb.asLongBuffer().put(876345L);
    System.out.println(bb.getLong());
    bb.rewind();
    // read as float
    bb.asFloatBuffer().put(12.576f);
    System.out.println(bb.getFloat());
    bb.rewind();
    // read as double
    bb.asDoubleBuffer().put(98263423896.00000000000345D);
    System.out.println(bb.getDouble());
    bb.rewind();
  }
}
