package com.xmen.adn.pattern;

public class FindMutant {

    FindPattern findPattern = new FindPattern();

    public boolean findMutant(char adn[][]) {
       int arraySize = adn[0].length;
       for(int i=0; i < arraySize; i++)
           for(int j=0; j < arraySize; j++) {
               if(isBetweenEdges(j,arraySize)) {
                   char [] subAdnSequence = extractHorizontalAdnSequence(adn, j, i);
                   byte position = findPattern.findPattern(subAdnSequence);
                   if(position == 3)
                       return true;
               }
           }
        return false;
    }

    private boolean isBetweenEdges(int currentPosition, int arraySize) {
        return currentPosition + 3 < arraySize;
    }

    public char[] extractHorizontalAdnSequence(char[][] adn, int position, int row) {
        char[] adnSequence = new char[4];
        byte subArrayPosition = 0;
        for(int i = position; i < 4; i++) {
            adnSequence[subArrayPosition++] = adn[row][i];
        }

        return adnSequence;
    }
}
