@Login
Feature: Login

  @Signup_01
  Scenario: Signup
    Given I open "https://demo.globedr.com/signin"
    And On web,Signup with user name and password and name
      | phone      | password | name     |
      | 0988886666 | 123456   | Ngân Hà  |
      | 0988887777 | 123456   | Khả Ngân |
    And I close page