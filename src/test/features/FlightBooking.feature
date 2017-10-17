Feature: Booka a Flight from the Ryanair web page

  Scenario: Book a flight with a non valid creadit card
    Given flights from 'MAD' on 13/11/2017 to 'STN' on 12/12/2017
    And 2 adults as passengers
    And proceed with the search of flights
    And  flights are selected
    And proceed with checkout
    And proceed with login
    And filling passenger details
    When I pay for booking with card details '5555 5555 5555 5557', '10/2018' and '265'
    Then a declined message is displayed