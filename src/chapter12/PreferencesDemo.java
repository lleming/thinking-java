package chapter12;

import java.util.Arrays;
import java.util.Iterator;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {
  public static void main(String[] args) throws BackingStoreException {
    Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
    prefs.put("Place", "Wonderland");
    prefs.put("Shoe", "Red shoes");
    prefs.putInt("Companion", 4);
    prefs.putBoolean("Is witches there?", true);
    int usageCount = prefs.getInt("Calls number in total", 0);
    usageCount++;
    prefs.putInt("Calls number in total", usageCount);
    Iterator it = Arrays.asList(prefs.keys()).iterator();
    while (it.hasNext()) {
      String key = it.next().toString();
      System.out.println(key + " : " + prefs.get(key, null));
    }
    System.out.println("How many companions Elly has? " + prefs.getInt("Companion", 0));
  }
}
