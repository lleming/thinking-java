package chapter12;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class ViewBuffers {
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(new byte[] {0, 0, 0, 0, 0, 0, 0, 'a'});
    bb.rewind();
    System.out.println("Byte buffer");
    while (bb.hasRemaining()) {
      System.out.println(bb.position() + "->" + bb.get());
    }

    CharBuffer cb = (bb.rewind()).asCharBuffer();
    System.out.println("Char buffer");
    while (cb.hasRemaining()) {
      System.out.println(bb.position() + "->" + cb.get());
    }

    FloatBuffer fb = (bb.rewind()).asFloatBuffer();
    System.out.println("Float buffer");
    while (fb.hasRemaining()) {
      System.out.println(fb.position() + "-> " + fb.get());
    }

    IntBuffer ib = bb.rewind().asIntBuffer();
    System.out.println("Integer buffer");
    while (ib.hasRemaining()) {
      System.out.println(ib.position() + "->" + ib.get());
    }

    LongBuffer lb = bb.rewind().asLongBuffer();
    System.out.println("Long buffer");
    while (lb.hasRemaining()) {
      System.out.println(lb.position() + "->" + lb.get());
    }

    ShortBuffer sb = bb.rewind().asShortBuffer();
    System.out.println("Short buffer");
    while (sb.hasRemaining()) {
      System.out.println(sb.position() + "->" + sb.get());
    }

    DoubleBuffer db = bb.rewind().asDoubleBuffer();
    System.out.println("Double buffer");
    while (db.hasRemaining()) {
      System.out.println(db.position() + "->" + db.get());
    }
  }
}
