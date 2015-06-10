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

    void "should find an vertical pattern"() {
    setup:
      FindMutant findMutant = new FindMutant()
    and:
      char[][] adn = new char[6][6]
      int value = 48
      for(int i = 0; i < adn[0].size(); i++)
        for(int j= 0; j < adn[0].size(); j++) {
          adn[i][j] = (char)value++
        }
    and:
      adn[0][0] = 'A'
      adn[1][0] = 'A'
      adn[2][0] = 'G'
      adn[3][0] = 'G'
      adn[4][0] = 'G'
      adn[5][0] = 'G'
    and:
      adn[0][1] = 'A'
      adn[1][1] = 'A'
      adn[2][1] = 'G'
      adn[3][1] = 'G'
      adn[4][1] = 'G'
      adn[5][1] = 'G'
    when:
      boolean isAValidSequence = findMutant.findMutant(adn)
    then:
      isAValidSequence
    }
    
    void "should find an horizontal pattern"() {
    setup:
      FindMutant findMutant = new FindMutant()
    and:
      char[][] adn = new char[6][6]
      int value = 48
      for(int i = 0; i < adn[0].size(); i++)
        for(int j= 0; j < adn[0].size(); j++) {
          adn[i][j] = (char)value++
        }
    and:
      adn[0][0] = 'A'
      adn[0][1] = 'A'
      adn[0][2] = 'G'
      adn[0][3] = 'G'
      adn[0][4] = 'G'
      adn[0][5] = 'G'
    and:
      adn[1][0] = 'A'
      adn[1][1] = 'A'
      adn[1][2] = 'G'
      adn[1][3] = 'G'
      adn[1][4] = 'G'
      adn[1][5] = 'G'
    when:
      boolean isAValidSequence = findMutant.findMutant(adn)
    then:
      isAValidSequence
    }

    void "should not find a pattern"() {
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
    
    void "should extract adn for matrix in crosswise"() {
    setup:
      FindMutant findMutant = new FindMutant()
    and:
      char[][] adn = new char[6][6]
      adn[0][0] = 'A'
      adn[1][1] = 'T'
      adn[2][2] = 'C'
      adn[3][3] = 'G'
      adn[4][4] = 'G'
      adn[5][5] = 'G'
    when:
      char[] subArray = findMutant.extractCrosswiseAdnSequence(adn,2,2)
    then:
      subArray == ['C','G', 'G', 'G']
    }
}

