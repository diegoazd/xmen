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
      println(verticalSubArray)
    then:
      verticalSubArray == ['A','T','C','G']
    }
}

