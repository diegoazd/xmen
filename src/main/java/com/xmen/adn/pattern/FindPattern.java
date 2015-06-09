package com.xmen.adn.pattern;

public class FindPattern {

    public byte findPattern(char[] row) {
        char initialChar = row[0];
        for(byte i = 1; i < row.length; i++) {
            if(isNotAValidSequence(initialChar, row[i]))
                return i;
        }
        return 3;
    }

    private boolean isNotAValidSequence(char initialChar, char currentChar) {
        return initialChar != currentChar;
    }


}
