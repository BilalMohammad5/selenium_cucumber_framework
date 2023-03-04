Feature: Product features

 // Background:

  Scenario Outline: golden scent product search
    Given user logs into golden_scent application using <email> and <password>
    When  user searches for a product  <product_name>
    And   user selects a product
    Then  user should navigate to product page
    Examples:
      |email|password|product_name|
      |bilalroshan5@gmail.com|Bilal@2595|Gucci Guilty Absolute Pour Homme|



