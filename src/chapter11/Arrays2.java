package chapter11;

public class Arrays2 {

  public static String toString(boolean[] a) {
    StringBuffer sb = new StringBuffer("[");
    for (int i = 0; i < a.length; i++) {
      sb.append(a[i]);
      if (i < a.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public static String toString(byte[] a) {
    StringBuffer sb = new StringBuffer("[");
    for (int i = 0; i < a.length; i++) {
      sb.append(a[i]);
      if (i < a.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
