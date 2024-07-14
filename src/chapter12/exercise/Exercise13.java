package chapter12.exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise13 {
  public static void main(String[] args) throws IOException {
    // 5. Save and restore data
    try {
      DataOutputStream out2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise13-Data.txt")));
      out2.writeDouble(3.14159);
      out2.writeUTF("That was a PI number");
      out2.writeDouble(1.41413);
      out2.writeUTF("That was square of 2");
      out2.close();
      DataInputStream in5 = new DataInputStream(new BufferedInputStream(new FileInputStream("Exercise13-Data.txt")));
      System.out.println(in5.readDouble());
      System.out.println(in5.readUTF().trim());
      System.out.println(in5.readDouble());
      System.out.print(in5.readUTF().trim());
    } catch (EOFException e) {
      throw new RuntimeException(e);
    }
  }
}
