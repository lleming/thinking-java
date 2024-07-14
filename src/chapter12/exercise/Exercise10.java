package chapter12.exercise;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberInputStream;

public class Exercise10 {
  public static void main(String[] args) throws IOException {
    IOStreamDemo.main(args);
  }
}

class IOStreamDemo {
  public static void main(String[] args) throws IOException {
    LineNumberInputStream lnis = new LineNumberInputStream(new FileInputStream("src/chapter12/IOStreamDemo.java"));
    // didn't find any way to how this class makes original IOSteamDemo simple
    // this class has not usable logic
  }
}

