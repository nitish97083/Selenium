Feature: Application Login

  Scenario:Home Page Default Login
    Given User in login page
    When User enter Username and password
    Then Home Page should be displayed

    #checking with correct credential
  Scenario:Home Page Default Login
    Given User in login page
    When User enter "nitish" and "NKV123"
    Then Home Page should be displayed "true"


        #checking with wrong credential
  Scenario:Home Page Default Login
    Given User in login page
    When User enter "nitish" and "NKV14"
    Then Home Page should be displayed "false"