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
    assert n >= m;

    int i = m - 1;
    int j = m - 1;
    while (i < n) {
      if (text.charAt(i) == pattern.charAt(j)) {
        if (j == 0) {
          // we've found a match!
          //System.out.println(text.substring(i, i + pattern.length()));
          return i;
        } else {
          i--;
          j--;
        }
      } else {
        int l = lastOccurence.getOrDefault(text.charAt(i), -1);
        // if the character isn't in lastOccurence, then it isn't in the pattern.
        // We move i by 'm - (-1 + 1) = m' places (i.e we skip over all the matching
        // pattern characters).
        // If it is, we'll skip over a smaller portion of the template.
        i += m - Math.min(j, 1 + l);
        j = m - 1;
      }
    }
    return -1;
  }
}
