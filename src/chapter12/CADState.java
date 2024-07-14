package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable {
  public static final int RED = 1, BLUE = 2, GREEN = 3; //colors
  private static Random rnd = new Random();
  private static int counter = 0;
  private int xPos, yPos, dimension;

  public Shape(int xVal, int yVal, int dim) {
    xPos = xVal;
    yPos = yVal;
    dimension = dim;
  }

  public static Shape randomFactory() {
    int xVal = rnd.nextInt(100);
    int yVal = rnd.nextInt(100);
    int dim = rnd.nextInt(100);
    switch (counter++ % 3) {
      default:
      case 0:
        return new Circle(xVal, yVal, dim);
      case 1:
        return new Square(xVal, yVal, dim);
      case 3:
        return new Line(xVal, yVal, dim);
    }
  }

  abstract public int getColor();

  abstract public void setColor(int newColor);

  @Override
  public String toString() {
    return getClass() + " color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
  }
}

class Circle extends Shape {
  private static int color = RED;

  public Circle(int xVal, int yVal, int dim) {
    super(xVal, yVal, dim);
  }

  @Override
  public int getColor() {
    return color;
  }

  @Override
  public void setColor(int newColor) {
    color = newColor;
  }
}

class Square extends Shape {
  private static int color;

  public Square(int xVal, int yVal, int dim) {
    super(xVal, yVal, dim);
    color = RED;
  }

  @Override
  public int getColor() {
    return color;
  }

  @Override
  public void setColor(int newColor) {
    color = newColor;
  }
}

class Line extends Shape {
  private static int color = RED;

  public Line(int xVal, int yVal, int dim) {
    super(xVal, yVal, dim);
  }

  public static void serializeStaticState(ObjectOutputStream os) throws IOException {
    os.writeInt(color);
  }

  public static void deserializeStaticState(ObjectInputStream in) throws IOException {
    color = in.readInt();
  }

  @Override
  public int getColor() {
    return color;
  }

  @Override
  public void setColor(int newColor) {
    color = newColor;
  }
}

public class CADState {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List shapeTypes, shapes;
    if (args.length == 0) {
      shapeTypes = new ArrayList();
      shapes = new ArrayList();
      shapeTypes.add(Circle.class);
      shapeTypes.add(Square.class);
      shapeTypes.add(Line.class);
      for (int i = 0; i < 10; i++) {
        shapes.add(Shape.randomFactory());
      }

      for (int i = 0; i < 10; i++) {
        ((Shape) shapes.get(i)).setColor(Shape.GREEN);
      }

      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
      out.writeObject(shapeTypes);
      Line.serializeStaticState(out);
      out.writeObject(shapes);
    }else{
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
      shapeTypes = (List) in.readObject();
      Line.deserializeStaticState(in);
      shapes = (List) in.readObject();
    }
    System.out.println(shapes);
  }
}
