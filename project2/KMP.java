package project2;

import java.util.ArrayList;
import java.util.List;

public class KMP {

  List<Integer> failureFunction(String pattern) {
    List<Integer> failure = new ArrayList<>(pattern.length());

    failure.add(0);
    int textIndex = 1;
    int patternIndex = 0;
    while (textIndex < pattern.length()) {
      if (pattern.charAt(textIndex) == pattern.charAt(patternIndex)) {
        failure.add(patternIndex + 1);
        textIndex++;
        patternIndex++;
      } else if (patternIndex > 0) {
        patternIndex = failure.get(patternIndex - 1);
      } else {
        failure.add(0);
        textIndex++;
      }
    }

    return failure;
  }

  public int match(String text, String pattern) {
    List<Integer> failure = failureFunction(pattern);
    int textIndex = 0, patternIndex = 0;
    while (textIndex < text.length()) {
      if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
        if (patternIndex == pattern.length() - 1) {
          return textIndex - pattern.length() + 1;
        }
        textIndex++;
        patternIndex++;
      } else if (patternIndex > 0) {
        patternIndex = failure.get(patternIndex - 1);
      } else {
        textIndex++;
      }
    }
    return -1;
  }
}