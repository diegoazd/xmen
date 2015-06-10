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

  void "should reject array"() {
  setup:
    MutantHelper mutantHelper = new MutantHelper()
  when:
    boolean isArrayValid = mutantHelper.validArraySize(null)
  then:
    isArrayValid == false
  }
  
  void "should reject array for empty array null"() {
  setup:
    MutantHelper mutantHelper = new MutantHelper()
  and:
    String[] array = {}
  when:
    boolean isArrayValid = mutantHelper.validArraySize(array)
  then:
    isArrayValid == false
  }
  
  void "should reject array for different sizes"() {
  setup:
    MutantHelper mutantHelper = new MutantHelper()
  and:
    String[] array = {'AB'}
  when:
    boolean isArrayValid = mutantHelper.validArraySize(array)
  then:
    isArrayValid == false
  }
}
