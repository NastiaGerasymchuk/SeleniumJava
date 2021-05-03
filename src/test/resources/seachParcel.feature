Feature: Search parcel
Scenario: not existed parcel.
Given User
When I input not existed number of parcel
And Click search button
Then I see information "Nothing found..."