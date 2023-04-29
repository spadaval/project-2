package project2;

import java.util.HashMap;
import java.util.Map;

public class BMH {

  Map<Character, Integer> lastOccurenceFunction(String pattern) {
    Map<Character, Integer> lastOccurence = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      lastOccurence.put(pattern.charAt(i), i);
    }
    return lastOccurence;
  }

  public int match(String text, String pattern) {
    Map<Character, Integer> lastOccurence = lastOccurenceFunction(pattern);
    int m = pattern.length();
    int n = text.length();
    int i = m - 1;
    int j = m - 1;
    while (i < n) {
      if (text.charAt(i) == pattern.charAt(j)) {
        if (j == 0) {
          return i;
        } else {
          i--;
          j--;
        }
      } else {
        int l = lastOccurence.get(text.charAt(i));
        i = i + m - Math.min(j, 1 + l);
        j = m - 1;
      }
    }
    return -1;
  }
}
