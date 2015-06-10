package com.xmen.adn.pattern;

public class MutantHelper {
  public char[][] transformInAdnSequence(String[] sequence) {
    int size = sequence.length;
    char[][] adn = new char[size][size];
    for(int i=0; i < sequence.length; i++)
      for(int j=0; j < sequence.length; j++)
        adn[i][j] = sequence[i].charAt(j);
    return adn;
  }
}
