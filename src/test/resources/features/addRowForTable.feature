@tables
Feature: add row for table

  @table_01
  Scenario: add data for Web table
    Given I open "https://demoqa.com"
    And I add data for web table
      | firstName  | Ngo                      |
      | lastName   | Yen                      |
      | email      | minhyen1311414@gmail.com |
      | age        | 25                       |
      | salary     | 9000000                  |
      | department | xbox                     |
    And row is display
      | firstName  | Ngo                      |
      | lastName   | Yen                      |
      | email      | minhyen1311414@gmail.com |
      | age        | 25                       |
      | salary     | 9000000                  |
      | department | xbox                     |
    And close page

