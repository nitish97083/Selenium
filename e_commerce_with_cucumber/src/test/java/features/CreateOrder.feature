Feature: Create Sales order

  @CreateSO
  Scenario: successfully login and store token and userId
    Given login payLoad should be with userName and Password
    When click on "Login" with http Post method
    Then "login" in response body is "Login Successfully"

  @AddProduct
  Scenario: create new product and verify successfully added or not

    Given  new Product payload should be ready
    When  click on "AddProduct" with http Post method
    Then "add product" in response body is "Product Added Successfully"

  @CreateSO
  Scenario Outline: Create sales order and verify
    Given sales order payLoad should be ready with country "<country>" and productId "<productId>"
    When click on "CreateOrder" with http Post Method
    Then Response Body message is "Order Placed Successfully"

    Examples:
      | country    | productId                |
      | India      | 6262e990e26b7e1a10e89bfa |
      | Bangladesh | 6262e95ae26b7e1a10e89bf0 |
      | China      | 6262e9d9e26b7e1a10e89c04 |