Feature: Event Management System - Contact Us Form
    
#Test Case/ Scenario will pass with valid inputs.   
  @ContactUs @PositiveTesting @DataDriven
  Scenario: Verify successful submission of the Contact Us form using data from Excel with valid inputs
  Given the user is on the Event Management System homepage
    When the user navigates to the Contact Us form
    And fills and submits the form for each row of data from the "ContactUsData" sheet
    Then a success message should be displayed after each submission
    
#This Scenario/test case will fail as I have implemented invalid name and email in the inputs and the logic to fail the test case if any invalid input is given.
   @ContactUs @AllNgativeTesting @DataDriven
   Scenario: Verify successful submission of the Contact Us form using data from Excel with invalid inputs
   Given the user is on the Event Management System homepage
    When the user navigates to the Contact Us form
    And fills and submits the form for each row of data from the "InvalidInputs" sheet
    Then a success message should be displayed after each submission
    
#This Scenario/test case will fail as I have implemented invalid name in the input and the logic to fail the test case if any invalid input is given.
    @ContactUs @NgativeTesting @DataDriven @InvalidName
   Scenario: Invalid Name
   Given the user is on the Event Management System homepage
    When the user navigates to the Contact Us form
    And fills and submits the form for each row of data from the "InvalidName" sheet
    Then a success message should be displayed after each submission
    
#This Scenario/test case will fail as I have implemented invalid email in the input and the logic to fail the test case if any invalid input is given.
    @ContactUs @NgativeTesting @DataDriven @InvalidEmail
   Scenario: Invalid Email
   Given the user is on the Event Management System homepage
    When the user navigates to the Contact Us form
    And fills and submits the form for each row of data from the "InvalidEmail" sheet
    Then a success message should be displayed after each submission