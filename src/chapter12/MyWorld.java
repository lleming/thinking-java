package chapter12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable {
}

class Animal implements Serializable {
  private String name;
  private House preferredHouse;

  Animal(String name, House house) {
    this.name = name;
    this.preferredHouse = house;
  }

  @Override
  public String toString() {
    return this.name + "[" + super.toString() + "]. " + this.preferredHouse + "\n";
  }
}

public class MyWorld {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    House house = new House();
    List animals = new ArrayList();
    animals.add(new Animal("Dog Bosko", house));
    animals.add(new Animal("Hamster Ralf", house));
    animals.add(new Animal("Cat Fronk", house));
    System.out.println("Animals list: " + animals);

    ByteArrayOutputStream buf1= new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(buf1);
    out.writeObject(animals);
    out.writeObject(animals);
    //write into different stream
    ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
    ObjectOutputStream out2 = new ObjectOutputStream(buf2);
    out2.writeObject(animals);
    //now read them back
    ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
    ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));

    List animals1 = (List) in1.readObject();
    List animals2 = (List) in1.readObject();
    List animals3 = (List) in2.readObject();

    System.out.println("Animals list: " + animals1);
    System.out.println("Animals list: " + animals2);
    System.out.println("Animals list: " + animals3);
  }
}
