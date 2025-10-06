Feature: Retrieve products
  Verify that the glue between feature and steps works.

  Scenario: Retrieve an existing product by title
    Given the product "Eggs" exists
    When I look for the product "Eggs"
    Then I receive information about the product "Eggs"