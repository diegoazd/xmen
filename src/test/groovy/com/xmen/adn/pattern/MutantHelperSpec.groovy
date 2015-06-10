package com.xmen.adn.pattern

class MutantHelperSpec extends spock.lang.Specification {
  void "should transform in an 2 dimension array"() {
  setup:
    MutantHelper mutantHelper = new MutantHelper()
  and:
    String[] sequence = ["AAAA","BBBB","CCCC","DDDD"]
  when:
    char[][] adn = mutantHelper.transformInAdnSequence(sequence)
  then:
    adn.size() == 4
    adn[0].size() == 4
  }
}
