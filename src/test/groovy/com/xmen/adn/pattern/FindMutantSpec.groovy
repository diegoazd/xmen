package com.xmen.adn.pattern

class FindMutantSpec extends spock.lang.Specification{
    void "should extract subarray in vertical"() {
    setup:
      FindMutant findMutant = new FindMutant()
    and:
      char[][] adn = new char[4][4]
      adn[0][0] = 'A'
      adn[0][1] = 'T'
      adn[0][2] = 'C'
      adn[0][3] = 'G'
    when:
      char[] verticalSubArray = findMutant.
              extractHorizontalAdnSequence(adn,0,0)
    then:
      verticalSubArray == ['A','T','C','G']
    }

    void "should find an horizontal pattern"() {
    setup:
      FindMutant findMutant = new FindMutant()
     and:
      char[][] adn = new char[6][6]
      adn[0][0] = 'A'
      adn[0][1] = 'T'
      adn[0][2] = 'G'
      adn[0][3] = 'G'
      adn[0][4] = 'G'
      adn[0][5] = 'G'
    when:
      boolean isAValidSequence = findMutant.findMutant(adn)
    then:
      isAValidSequence
    }

    void "should not find an horizontal pattern"() {
        setup:
        FindMutant findMutant = new FindMutant()
        and:
        char[][] adn = new char[6][6]
        adn[0][0] = 'A'
        adn[0][1] = 'T'
        adn[0][2] = 'G'
        adn[0][3] = 'C'
        adn[0][4] = 'G'
        adn[0][5] = 'G'
        adn[1][0] = 'A'
        adn[1][1] = 'T'
        adn[1][2] = 'G'
        adn[1][3] = 'C'
        adn[1][4] = 'G'
        adn[1][5] = 'G'
        adn[2][0] = 'A'
        adn[2][1] = 'T'
        adn[2][2] = 'G'
        adn[2][3] = 'C'
        adn[2][4] = 'G'
        adn[2][5] = 'G'
        adn[3][0] = 'A'
        adn[3][1] = 'T'
        adn[3][2] = 'G'
        adn[3][3] = 'C'
        adn[3][4] = 'G'
        adn[3][5] = 'G'
        adn[4][0] = 'A'
        adn[4][1] = 'T'
        adn[4][2] = 'G'
        adn[4][3] = 'C'
        adn[4][4] = 'G'
        adn[4][5] = 'G'
        adn[5][0] = 'A'
        adn[5][1] = 'T'
        adn[5][2] = 'G'
        adn[5][3] = 'C'
        adn[5][4] = 'G'
        adn[5][5] = 'G'
        when:
        boolean isAValidSequence = findMutant.findMutant(adn)
        then:
        !isAValidSequence
    }
}

