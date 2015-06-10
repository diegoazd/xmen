package com.xmen.adn.pattern;

public class FindMutant {
    public char[] extractHorizontalAdnSequence(char[][] adn, int position, int row) {
        char[] adnSequence = new char[4];
        for(int i = position; i < 4; i++)
            adnSequence[i - position] = adn[row][i];

        return adnSequence;
    }
}
