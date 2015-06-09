package com.xmen.adn.pattern;

public class VerticalPattern {
    static final byte MAX_SECUENCE_LENGTH = 4;
    public boolean findPatternInARow(char[] row) {
        char currentSecuence = row[0];
        byte secuenceLength = 1;
        for(int i=1; i<row.length;i++) {
            if(currentSecuence == row[i] && MAX_SECUENCE_LENGTH == secuenceLength)
               return true;
            else {
                currentSecuence = row[i];
                secuenceLength = 1;
            }
        }
        return false;
    }

}
