Feature: Search parcel

  Scenario Outline: not existed parcel.
    Given User
    * input filed is enabled
    * search button is disabled
    When I input <not existed number>
    * search button is enabled
    * Click search button
    Then I see information <nothing info>
    Examples:
      | nothing info          |not existed number|
      | "Nothing found"       |"205988000651468115"|
      | "Nothing found"       | "948"             |


