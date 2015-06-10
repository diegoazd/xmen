package com.xmen.adn.pattern;

public class MutantHelper {
  public char[][] transformInAdnSequence(String[] sequence) throws RuntimeException {
    int size = sequence.length;
    char[][] adn = new char[size][size];
    for(int i=0; i < sequence.length; i++)
      for(int j=0; j < sequence.length; j++) {
        adn[i][j] = Character.toUpperCase(sequence[i].charAt(j));
        if(adn[i][j] != 'A' && adn[i][j] != 'T' && adn[i][j] != 'C' && adn[i][j] != 'G')
          throw new RuntimeException();
      }

    return adn;
  }

  public boolean validArraySize(String[] array) {
    if(array == null || array.length == 0)
      return false;

    if(array.length != array[0].length())
      return false;

    return true;
  }
}
