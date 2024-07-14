package chapter12.exercise;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Exercise15 {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BlipCheck.main(args);
  }

  public static class Blip1 implements Externalizable {

    public Blip1() {
      System.out.println("Constructor Blip1");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      System.out.println("Blip1.readExternal");
    }
  }

  public static class Blip2 implements Externalizable {
    Blip2() {
      System.out.println("Constructor Blip2");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      System.out.println("Blip12.readExternal");
    }
  }
}

class BlipCheck {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    System.out.println("Creating objects");
    chapter12.exercise.Exercise15.Blip1 b1 = new chapter12.exercise.Exercise15.Blip1();
    chapter12.exercise.Exercise15.Blip2 b2 = new chapter12.exercise.Exercise15.Blip2();
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
    System.out.println("Storing object");
    o.writeObject(b1);
    o.writeObject(b2);
    o.close();

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
    System.out.println("Restore object");
    b1 = (chapter12.exercise.Exercise15.Blip1) in.readObject();
    b2 = (chapter12.exercise.Exercise15.Blip2) in.readObject();


  }
}
