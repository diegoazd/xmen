package com.xmen.adn.pattern

class FindPatternSpec extends  spock.lang.Specification{
    void "should find 4 letters in a row"() {
        setup:
        char[] adnSecuence = new char[4]
        adnSecuence[0] = 'T' as char
        adnSecuence[1] = 'T' as char
        adnSecuence[2] = 'T' as char
        adnSecuence[3] = 'T' as char
       and:
        FindPattern verticalPattern = new FindPattern()
        when:
        byte finalPosition = verticalPattern.findPattern(adnSecuence)
        then:
        finalPosition == 3
    }

    void "should not find a pattern"() {
        setup:
        char[] adnSecuence = new char[4]
        adnSecuence[0] = 'T' as char
        adnSecuence[1] = 'A' as char
        adnSecuence[2] = 'T' as char
        adnSecuence[3] = 'T' as char
        and:
        FindPattern verticalPattern = new FindPattern()
        when:
        byte finalPosition = verticalPattern.findPattern(adnSecuence)
        then:
        finalPosition == 1
    }
}
