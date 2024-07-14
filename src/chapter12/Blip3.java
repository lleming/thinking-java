package chapter12;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Blip3 implements Externalizable {
  private int i;
  private String s;

  public Blip3() {
    System.out.println("Constructor Blip3");
  }

  public Blip3(String x, int a) {
    System.out.println("Blip3(String x, int a)");
    s = x;
    i = a;
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    System.out.println("Create object");
    Blip3 b3 = new Blip3("Line", 12);
    System.out.println(b3);
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
    System.out.println("Storing object");

    out.writeObject(b3);
    out.close();

    // reading object back
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
    System.out.println("Restore object");
    b3 = (Blip3) in.readObject();
    System.out.println(b3);
  }

  @Override
  public String toString() {
    return s + " " + i;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    System.out.println("Blip3.writeExternal");
    out.writeObject(s);
    out.writeInt(i);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    System.out.println("Blip3.readExternal");
    s = (String) in.readObject();
    i = (int) in.readInt();
  }
}
