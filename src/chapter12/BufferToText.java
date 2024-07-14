package chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
  private static final int BSIZE = 1024;

  public static void main(String[] args) throws IOException {
    FileChannel fc = new FileOutputStream("data3.txt").getChannel();
    fc.write(ByteBuffer.wrap("Some of the text".getBytes()));
    fc.close();
    fc = new FileInputStream("data3.txt").getChannel();
    ByteBuffer buff = ByteBuffer.allocate(BSIZE);
    fc.read(buff);
    buff.flip();
    System.out.println(buff.asCharBuffer());
    buff.rewind();
    String encoding = System.getProperty("file.encoding");
    System.out.println("Encoded as " + encoding + ": " + Charset.forName(encoding).decode(buff));
    fc = new FileOutputStream("data3.txt").getChannel();
    fc.write(ByteBuffer.wrap("Furios text".getBytes("UTF-16BE")));
    fc.close();
    fc = new FileInputStream("data3.txt").getChannel();
    buff.clear();
    fc.read(buff);
    buff.flip();
    System.out.println(buff.asCharBuffer());
    // char buffer for writing
    fc = new FileOutputStream("data3.txt").getChannel();
    buff = ByteBuffer.allocate(28);
    buff.asCharBuffer().put("Wither methods");
    fc.write(buff);
    fc.close();
    // read and print
    fc = new FileInputStream("data3.txt").getChannel();
    buff.clear();
    fc.read(buff);
    buff.flip();
    System.out.println(buff.asCharBuffer());

  }
}
