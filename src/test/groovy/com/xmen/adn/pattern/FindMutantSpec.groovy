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

    void "should not find a horizontal pattern"() {
        setup:
        FindMutant findMutant = new FindMutant()
        and:
        char[][] adn = new char[6][6]
        int value = 48
        for(int i = 0; i < adn[0].size(); i++)
          for(int j= 0; j < adn[0].size(); j++) {
            adn[i][j] = (char)value
            value++
          }
        println adn
        when:
        boolean isAValidSequence = findMutant.findMutant(adn)
        then:
        !isAValidSequence
    }

    void "should extract adn for matrix in vertical"() {
    setup:
      FindMutant findMutant = new FindMutant()
    and:
      char[][] adn = new char[6][6]
      adn[0][0] = 'A'
      adn[1][0] = 'T'
      adn[2][0] = 'C'
      adn[3][0] = 'G'
      adn[4][0] = 'G'
      adn[5][0] = 'G'
    when:
      char[] verticalSubArray = findMutant.
              extractVerticalAdnSequence(adn,0,0)
    then:
      verticalSubArray == ['A','T','C','G']
    }
}

