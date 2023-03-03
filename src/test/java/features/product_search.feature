Feature:Home Page features

  Background:
    Given user launches golden_scent
    Then user should be able to see golden_scent home page

  @smoke
  Scenario Outline: golden scent product search
    When user searches for product <product_name>
#    And  selects a product from the result
#    Then user should be able to see product page
Examples:
      |product_name|
      |Gucci Guilty Absolute Pour Homme|



