@olx
Feature: OLX account edit

  @editProfile
  Scenario: A user can edit a name, localization and phone number
    Given User is on the main page
    When User logs in using email: "rabarbeata.gibberish@pacz.to" and password: "GreenBlueOrange123"
    When User goes to the profile information edit page
    Then User sees the name set to "egg"
    And User sees the location set to "Sosnowiec"
    And User sees the phone number set to "555 666 222"
    Then User enters the new name: "nothingness"
    And User enters the new location: "Bytom"
    And User enters the new phone number: "666 222 666"
    Then User accepts the changes
    And User verifies the added changes name: "nothingness", location: "Bytom", phone number: "666 222 666"
    And User closes the browser



