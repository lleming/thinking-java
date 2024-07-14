package chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Parameters: FileSource FileTarget");
      System.exit(1);
    }
    FileChannel in = new FileInputStream(args[0]).getChannel();
    FileChannel out = new FileOutputStream(args[1]).getChannel();
    ByteBuffer buffer = ByteBuffer.allocate(16);
    while (in.read(buffer) != -1) {
      buffer.flip();
      out.write(buffer);
      buffer.clear();
    }
  }
}
