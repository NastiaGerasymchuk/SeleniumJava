Feature: Home Page
  Background:
    Given User
  Scenario Outline: not existed parcel.
    * input filed is enabled
    * search button is disabled
    When I input <not existed number>
    * search button is enabled
    * Click search button
    Then I see information <nothing info>
    Examples:
      | nothing info          |not existed number|
      | "Nothing found..."       |"205988000651468115"|
      | "Nothing found..."       | "948"             |
  Scenario Outline: existed parcel
    * input filed is enabled
    * search button is disabled
  When I input parcel's <number>
    * search button is enabled
    * Click search button
  Then I see info about the parcel by inputted <number>
  Examples:
    |number            |
    |"2059000651468115"|
    |"204948"          |

    Scenario Outline: not correct number
      * input filed is enabled
      * search button is disabled
      When I input <number>
      * search button is enabled
      * Click search button
   Then I see information <incorrect info>
      Examples:
        | number   |incorrect info|
        |   ""     |"You inputted not correct number of parcel"|
        | "llkjg"  |"You inputted not correct number of parcel"|
        | "kkvggg" |"You inputted not correct number of parcel"|


  Scenario Outline: Change language
When I Click language button
And Select one of the language from <suggested>
Then All site's interface is translated on <header>,<track_number>,<fast_tracking>,<intuitive_interface>,<archive_parcels>,<our_partners>
  Examples:
  |suggested|header|track_number|fast_tracking|intuitive_interface|archive_parcels|our_partners|
  |1        |"Find your parcel just in one moment"|"Track number"|"Fast tracking"|"Intuitive Interface"|"Archive Parcels"|"Our Partners"|
  |2        |"Знайдіть вашу посилку в один клік"  |"Трек номер"|"Швидкий пошук"  |"Простий інтерфейс"  |"Архів посилок"  |"Наші партнери"|

  Scenario: Know about all partners
  Then I see information about all partners of tracks
    |nova-poshta |
    |justin      |
    |   dhl      |
