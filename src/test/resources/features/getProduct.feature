Feature: Retrieve products
  Verify that the glue between feature and steps works.

  Scenario: Retrieve an existing product by title
    Given the product "Apple" exists
    When I look for the product "Apple"
    Then I receive information about the product "Apple"