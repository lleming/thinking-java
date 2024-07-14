package chapter12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
  private int n;

  public Data(int n) {
    this.n = n;
  }

  @Override
  public String toString() {
    return Integer.toString(n);
  }
}

public class Worm implements Serializable {
  private static Random rnd = new Random();
  private Data[] d = {
      new Data(rnd.nextInt(10)),
      new Data(rnd.nextInt(10)),
      new Data(rnd.nextInt(10)),
      new Data(rnd.nextInt(10))
  };

  private Worm next;

  private char c;

  public Worm(int i, char x) {
    System.out.println("Construct Worm: " + i);
    c = x;
    if (--i > 0) {
      next = new Worm(i, (char) (x + 1));
    }
  }

  public Worm() {
    System.out.println("Default constructor");
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Worm w = new Worm(6, 'a');
    System.out.println("w=" + w);
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
    out.writeObject("Storage of object Worm");
    out.writeObject(w);
    out.close();

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
    String s = (String) in.readObject();

    Worm ww = (Worm) in.readObject();
    System.out.println(s + ", w2= " + ww);
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    ObjectOutputStream out2 = new ObjectOutputStream(bout);
    out2.writeObject("Store of object Worm");
    out2.writeObject(w);
    out2.flush();
    ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
    s = (String) in2.readObject();
    Worm www = (Worm) in2.readObject();
    System.out.println(s + ", w3 = " + www);
  }

  @Override
  public String toString() {
    String s = ":" + c + "(";
    for (int i = 0; i < d.length; i++) {
      s += d[i].toString();
    }
    s += ")";
    if (next != null) {
      s += next.toString();
    }
    return s;
  }
}
