package chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Logon implements Serializable {
  private Date date = new Date();
  private String username;
  private transient String password;

  public Logon(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
    Logon a = new Logon("User", "P@ssw0rd");
    System.out.println("Session a=" + a);
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Logon.out"));
    out.writeObject(a);
    out.close();

    Thread.sleep(1000);
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
    System.out.println("Restore session. Date: " + new Date());
    a = (Logon) in.readObject();
    System.out.println("Session a=" + a);


  }

  @Override
  public String toString() {
    String pwd = (password == null) ? "access denied" : password;
    return """
        session info: username: %s, date: %s, password: %s
        """.formatted(username, date, pwd);
  }
}
