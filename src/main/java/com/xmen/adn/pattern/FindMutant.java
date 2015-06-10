package com.xmen.adn.pattern;

public class FindMutant {
    public final static byte NUMBER_OF_SEQUENCES = 2;
    public final static byte PATTERN_LENGTH = 3;
    FindPattern findPattern = new FindPattern();


    public boolean findMutant(char adn[][]) {
      int arraySize = adn[0].length;
      byte sequenceNumbers = 0;
      for(int i=0; i < arraySize; i++)
        for(int j=0; j < arraySize; j++) {
        if(isBetweenEdges(j,arraySize)) 
          sequenceNumbers = findHorizontalPatterAndAddSequence(
              adn, j, i, sequenceNumbers);

        if(isBetweenEdges(i,arraySize))
          sequenceNumbers = findVerticalPatterAndAddSequence(adn, 
              j, i, sequenceNumbers);
        
        if(isBetweenEdges(i,arraySize) && isBetweenEdges(j, arraySize))
          sequenceNumbers = findCrosswisePatternAndAddSequence(adn, 
              j, i, sequenceNumbers);

        if(sequenceNumbers >= NUMBER_OF_SEQUENCES)
          return true;
       }
      return false;
    }
    
    private byte addSequenceIfFindPattern(char[] subAdnSequence, 
        byte sequenceNumbers) {
      byte position = findPattern.findPattern(subAdnSequence);
      if(position == PATTERN_LENGTH)
        sequenceNumbers++;

      return sequenceNumbers;
    }

    private boolean isBetweenEdges(int currentPosition, int arraySize) {
        return currentPosition + 3 < arraySize;
    }
    
    private byte findHorizontalPatterAndAddSequence(char[][] adn, 
        int column, int row, byte sequenceNumbers) {
      char[] subAdnSequence = extractHorizontalAdnSequence(adn, column, row);
      sequenceNumbers = addSequenceIfFindPattern(subAdnSequence, 
          sequenceNumbers);

      return sequenceNumbers;
    }
    
    private byte findVerticalPatterAndAddSequence(char[][] adn, 
        int column, int row, byte sequenceNumbers) {
      char[] subAdnSequence = extractVerticalAdnSequence(adn, row, column);
      sequenceNumbers = addSequenceIfFindPattern(subAdnSequence, 
          sequenceNumbers);

      return sequenceNumbers;
    }

    private byte findCrosswisePatternAndAddSequence(char[][] adn,
        int column, int row, byte sequenceNumbers) {
      char[] subAdnSequence = extractCrosswiseAdnSequence(adn, row, column);
      sequenceNumbers = addSequenceIfFindPattern(subAdnSequence, 
          sequenceNumbers);

      return sequenceNumbers;
    }

    public char[] extractHorizontalAdnSequence(char[][] adn, int position, int row) {
      char[] adnSequence = new char[4];
      byte subArrayPosition = 0;
      for(int i = position; i < position + 4; i++) {
          adnSequence[subArrayPosition++] = adn[row][i];
      }

      return adnSequence;
    }

    public char[] extractVerticalAdnSequence(char[][] adn, int position, int column) {
      char[] adnSequence = new char[4];
      byte subArrayPosition = 0;
      for(int i = position; i < position + 4; i++)
          adnSequence[subArrayPosition++] = adn[i][column];

      return adnSequence;
    }
    
    public char[] extractCrosswiseAdnSequence(char[][] adn, int row, int column) {
      char[] adnSequence = new char[4];
      byte subArrayPosition = 0;
      for(int i = row; i < row + 4; i++) {
        adnSequence[subArrayPosition] = adn[row+subArrayPosition][column+subArrayPosition];
        subArrayPosition++;
      }  

      return adnSequence;
    }
}
