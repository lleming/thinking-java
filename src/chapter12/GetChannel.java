package chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
  public static void main(String[] args) throws IOException {
    // Write to file
    FileChannel fc = new FileOutputStream("fc-data.txt").getChannel();
    fc.write(ByteBuffer.wrap("Some of the text".getBytes()));
    fc.close();

    // Append to file
    fc = new RandomAccessFile("fc-data.txt", "rw").getChannel();
    fc.position(fc.size());
    fc.write(ByteBuffer.wrap("Some of more or less additional text".getBytes()));
    fc.close();
    // Read file

    fc = new FileInputStream("fc-data.txt").getChannel();
    ByteBuffer buff = ByteBuffer.allocate(1024);
    fc.read(buff);
    buff.flip();
    while (buff.hasRemaining()) {
      System.out.print((char) buff.get());
    }
  }
}
