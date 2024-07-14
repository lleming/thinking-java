package chapter12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class FileLocking {
  public static void main(String[] args) throws IOException, InterruptedException {
    FileOutputStream fos = new FileOutputStream("file.txt");
    FileLock fl = fos.getChannel().tryLock();
    if (fl != null) {
      System.out.println("File file.txt is locked");
      Thread.sleep(10000);
      fl.release();
      System.out.println("File file.txt is released");
    }
    fos.close();
    ;
  }
}
