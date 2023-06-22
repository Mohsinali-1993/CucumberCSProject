Feature: Customers

  Background: Steps common for all scenarios
    Given User Launch Chrome browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And  User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
@regression
  Scenario: Add new customer
    
    When User clicks on customer menu
    And  Click on customer menu item
    And  Click on add new button
    Then User can view Add new customer page
    When User enters customer info
    And  click on save button
    Then user can view confirmation message "The new customer has been added successfully"
    And Close Browser
  
  @Regression  
 Scenario: search customer by email
   
    When User clicks on customer menu
    And  Click on customer menu item
    And Enter customer Email
    When click on search button
    Then User should found Email in the search table
    And Close Browser
    
  @Sanity 
Scenario: search customer by Name
    
    When User clicks on customer menu
    And  Click on customer menu item
    And enter customer Firstname
    And enter customer Lastname
    When click on search button
    Then User should find name in search table
    And Close Browser
     
    
    
    