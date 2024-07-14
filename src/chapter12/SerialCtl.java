package chapter12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCtl implements Serializable {

  private String a;
  private transient String b;

  public SerialCtl(String aa, String bb) {
    this.a = "No declared as transient: " + aa;
    this.b = "Declared transient: " + bb;
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SerialCtl sc = new SerialCtl("Test1", "Test2");
    System.out.println("Before writing: \n" + sc);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    ObjectOutputStream o = new ObjectOutputStream(buf);
    o.writeObject(sc);
    // now read it back
    ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
    SerialCtl sc2 = (SerialCtl) in.readObject();
    System.out.println("After recovery: \n" + sc2);
  }

  @Override
  public String toString() {
    return a + "\n" + b;
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    System.out.println("SerialCtl.[private]writeObject");
    out.defaultWriteObject();
    out.writeObject(b);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    System.out.println("SerialCtl.[private]readObject");
    in.defaultReadObject();
    b = (String) in.readObject();
  }
}
