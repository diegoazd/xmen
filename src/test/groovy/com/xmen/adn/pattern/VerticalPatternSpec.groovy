package com.xmen.adn.pattern

class VerticalPatternSpec extends  spock.lang.Specification{
    void "should find 4 letters in a row"() {
    setup:
      VerticalPattern verticalPattern = new VerticalPattern()
    when:
       boolean isPattern = verticalPattern.findPatternInARow()
    then:
       isPattern
    }
}
