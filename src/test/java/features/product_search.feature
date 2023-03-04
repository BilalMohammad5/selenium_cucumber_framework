Feature: Product features

  @smoke @add_to_cart
  Scenario Outline: Golden scent product search
    Given User logs into golden_scent application using <email> and <password>
    When  User searches for a product  <product_name>
    And   User adds product to cart
    Then  user should see iteam added to cart message <message>
    Examples:
      |email|password|product_name|message|
      |bilalroshan5@gmail.com|Bilal@2595|Gucci Guilty Absolute Pour Homme|Product Added to cart|

     @smoke @rating
  Scenario Outline: Verify product rating
    Given User launches the product <product_name>
    When  User verifies Product rating
    Then  User should be able see that rating is more than <rating> stars
    Examples:
      |product_name|rating|
      |Gucci Guilty Absolute Pour Homme|4|


