package com.xmen.adn.pattern

class VerticalPatternSpec extends  spock.lang.Specification{
    void "should find 4 letters in a row"() {
        setup:
        char[] adnSecuence = new char[6]
        adnSecuence[0] = 'A' as char
        adnSecuence[1] = 'T' as char
        adnSecuence[2] = 'T' as char
        adnSecuence[3] = 'T' as char
        adnSecuence[4] = 'T' as char
        adnSecuence[5] = 'A' as char
       and:
        VerticalPattern verticalPattern = new VerticalPattern()
        when:
        boolean isPattern = verticalPattern.findPatternInARow(adnSecuence)
        then:
        isPattern
    }

    void "should not find a pattern"() {
        setup:
        char[] adnSecuence = new char[6]
        adnSecuence[0] = 'A' as char
        adnSecuence[1] = 'T' as char
        adnSecuence[2] = 'T' as char
        adnSecuence[3] = 'T' as char
        adnSecuence[4] = 'C' as char
        adnSecuence[5] = 'A' as char
        and:
        VerticalPattern verticalPattern = new VerticalPattern()
        when:
        boolean isNotAPattern = verticalPattern.findPatternInARow(adnSecuence)
        then:
        !isNotAPattern
    }
}
