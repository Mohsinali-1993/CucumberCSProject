Feature: Login

@Sanity 
Scenario: Successful Login with valid Credentials
   Given User Launch Chrome browser
   When  User Opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters Email as "admin@yourstore.com" and Password as "admin"
   And Click on Login
   Then Page title should be "Dashboard / nopCommerce administration"
   When User click on Log out Link
   Then Page title should be "Your store. Login"
   And Close Browser
   
@Regression
Scenario Outline: Successful Login with valid Credentials Data Driven Testing
   Given User Launch Chrome browser
   When  User Opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters Email as "<email>" and Password as "<password>"
   And Click on Login
   Then Page title should be "Dashboard / nopCommerce administration"
   When User click on Log out Link
   And Close Browser
   
   Examples:
|        email            |password|
|admin@yourstore.com      |admin|
