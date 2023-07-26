Feature: Login

  Scenario Outline: Verify the Login Section
        Given Driver and system setup called
        And Navigate to Login page Url "http://www.demo.guru99.com/V4/"
        When  Enter the <userName> and <password>
        Then click on Login button
        And  User should login successfully and driver close
    Examples:
      | userName | password |
      | "mngr442118" | "EpApeqy" |
#      | "mngr442118" | "EpApey" |
#      | "mngr44211" | "EpApeqy" |
#      | "mngr44218" | "EpApeq" |