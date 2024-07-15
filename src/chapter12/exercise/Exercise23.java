package chapter12.exercise;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise23 {

  public static void main(String[] args) throws IOException {
    if (args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }

    FileChannel fc = new RandomAccessFile(args[0], "rw").getChannel();
    MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());
    Charset utf8 = StandardCharsets.UTF_8;
    CharBuffer cbuff = utf8.decode(buffer);
    String regex = ".*" + args[1] + ".*";

    Pattern p = Pattern.compile(regex);
    // moving over lines in the file
    Matcher m = p.matcher(cbuff);
    int counter = 0;
    while (m.find()) {
      System.out.println(counter++ + ": " + m.group() + ": " + m.start());
    }
    fc.close();
  }
}
