package chapter12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
  public static void main(String[] args) throws IOException {
    FileOutputStream f = new FileOutputStream("test.zip");
    CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
    ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(csum));
    zos.setComment("Checking zip archive");

    for (int i = 0; i < args.length; i++) {
      System.out.println("Adding file: " + args[i]);
      BufferedReader in = new BufferedReader(new FileReader(args[i]));
      zos.putNextEntry(new ZipEntry(args[i]));
      int c;
      while ((c = in.read()) != -1) {
        zos.write(c);
      }
      in.close();
    }

    zos.close();
    // now checksum reading is available after closing
    System.out.println("Checksum: " + csum.getChecksum().getValue());
    //extract file from zip archive
    System.out.println("Reading file");
    FileInputStream fi = new FileInputStream("test.zip");
    CheckedInputStream cis = new CheckedInputStream(fi, new Adler32());
    ZipInputStream in2 = new ZipInputStream(cis);
    BufferedInputStream bis = new BufferedInputStream(in2);
    ZipEntry ze;
    while ((ze = in2.getNextEntry()) != null) {
      System.out.println("Reading file: " + ze);
      int x;
      while ((x = bis.read()) != -1) {
        System.out.write(x);
      }
    }

    if(args.length == 1){
      System.out.println("Checksum: " + cis.getChecksum().getValue());
    }

    bis.close();


    // Another way to open and read files in zip format

    ZipFile zf = new ZipFile("test.zip");
    Enumeration e = zf.entries();
    while(e.hasMoreElements()){
      ZipEntry ze2 = (ZipEntry) e.nextElement();
      System.out.println("Compressed file: " + ze2);
    }

    zf.close();

  }
}
