package project2;

public class Brute {

  public int match(String text, String pattern) {
    // check if text contains pattern using brute-force pattern matching
    // return the index of the first character of the first match
    // return -1 if no match is found

    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      int j = 0;
      while (j < pattern.length() && text.charAt(i + j) == pattern.charAt(j)) {
        j++;
      }
      if (j == pattern.length()) {
        return i;
      }
    }
    return -1;
  }

}
