Feature: create new product into the product list


  Scenario: successfully login and store token and userId
    Given login payLoad should be with userName and Password
    When click on "Login" with http Post method
    Then "login" in response body is "Login Successfully"

  Scenario: create new product and verify successfully added or not

    Given  new Product payload should be ready
    When  click on "AddProduct" with http Post method
    Then "add product" in response body is "Product Added Successfully"



