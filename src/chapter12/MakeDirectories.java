package chapter12;

import java.io.File;

public class MakeDirectories {
  private final static String usage = """
      Usage: MakeDirectories path1....
      It creates all paths
      Usage: MakeDirectories -d path1....
      It deletes all paths
      Usage: MakeDirectories -r path1 path2....
      It renames path1 to path2
      """;

  private static void usage() {
    System.err.println(usage);
    System.exit(1);
  }

  private static void fileData(File f) {
    System.out.println("""
        Full name: %s
        Is read granted: %b
        Is write granted: %b
        Is execute granted: %b
        File name: %s,
        Parent path: %s,
        Path: %s, 
        Size: %d, 
        Last modified data: %s
        """.formatted(
        f.getAbsolutePath(),
        f.canRead(),
        f.canWrite(),
        f.canExecute(),
        f.getName(),
        f.getParent(),
        f.getPath(),
        f.length(),
        f.lastModified()
    ));
    if (f.isFile()) {
      System.out.println("This is file");
    } else if (f.isDirectory()) {
      System.out.println("This is directory");
    }
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      usage();
    }
    if (args[0].equals("-r")) {
      if (args.length != 3) {
        usage();
      }
      File old = new File(args[1]);
      File rname = new File(args[2]);
      old.renameTo(rname);
      fileData(old);
      fileData(rname);
      return;
    }
    int count = 0;
    boolean del = false;
    if (args[0].equals("-d")) {
      count++;
      del = true;
    }
    while (++count < args.length) {
      File f = new File(args[count]);
      if (f.exists()) {
        System.out.println(f + " exists");
        if (del) {
          System.out.println("Deleting... " + f);
          f.delete();
        }
      } else {
        if (!del) {
          f.mkdirs();
          System.out.println("Created " + f);
        }
      }
      fileData(f);
    }
  }
}
