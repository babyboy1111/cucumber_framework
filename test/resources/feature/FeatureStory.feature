Feature: FeatureStory.feature

  Scenario: Verified full name is displayed corectly after clicking on the Submit button
    Given The web land on Test Automation Practice page
    When I click on 'ELEMENTS'
    And I am enter my full name 'Ghuyn'
    And I click on 'SUBMIT_BUTTON'
    Then I should see 'Abc' is displayed

  Scenario: Verified The 'You have selected :desktop notes commands' text is displayed corectly after selecting 'Desktop' check box
    Given The web land on Test Automation Practice page
    When I click on 'ELEMENTS'
    And I click on 'CHECK_BOX'
    And I click on 'HOME_DROPDOWN'
    And I click on 'DESKTOP_DROPDOWN'
    Then  I should see the 'You have selected :desktop notes commands' text is displayed

  Scenario: Verified The 'You have done a double click' text will be displayed after clicking 2 twice on 'Double Click Me' button
    Given The web land on Test Automation Practice page
    When I click on 'ELEMENTS'
    And I click on 'BUTTONS'
    And I click twices on Double Click Me button
    Then I should see The 'You have done a double click' text will be displayed

  Scenario: Verified The home page is displayed after clicking Home link
    Given The web land on Test Automation Practice page
    When I click on 'ELEMENTS'
    And I click on 'LINKS'
    And I click on 'HOME_LINK'
    Then I should see the home page is displayed

  Scenario: Verified User can click on  'OK' button of confirm box successfully
    Given The web land on Test Automation Practice page
    When I click on 'ALERTS'
    And I click on Click Me button to open confirm box
    And I click on OK button
    Then I should see 'You selected Ok' message