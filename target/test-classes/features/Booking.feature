Feature: Event Management System - Booking Form

  Background:
    Given The user is on the Event Management System booking page

#Test case/Scenario woth all valid details using Scenario DataTable
  @BookingForm @NegativeTest
  Scenario: Verify booking form with invalid details
    When The user enters invalid details
    | FirstName | LastName | Phone      | Email  | EventType | EventDate  | EventTime | GuestCount | Catering | Address      | City       | Pincode |
      | John       | 1234    | 9876543210 | john.s@.com   | Others   | abc | 123     | -100        | Veg      | 123 Park Ave | Chennai    | 400001  |
    Then The user clicks the Book Now button
    Then Take Screenshot Scnario 1
    And Close the browser
   
#Test case/Scenario woth all valid details using Scenario Outline
 	@BookingForm @PositiveTest @DataDriven
	  Scenario Outline: Verify booking form with valid details
	    When the user enters the details "<FirstName>", "<LastName>", "<Phone>", "<Email>", "<EventType>", "<EventDate>", "<EventTime>", "<GuestCount>", "<Catering>", "<Address>", "<City>", and "<Pincode>"
	    Then The user clicks the Book Now button
	    Then Take Screenshot Scnario 2
	    And Close the browser

    Examples:
      | FirstName | LastName | Phone      | Email             | EventType | EventDate  | EventTime | GuestCount | Catering | Address      | City       | Pincode |
      | Sam       | Smith    | 9876543210 | sam.s@email.com   | Wedding   | 08/15/2025 | 18:00     | 150        | Veg      | 123 Park Ave | Chennai    | 400001  |
      | Maria     | Jones    | 9123456789 | maria.j@email.com | Birthday  | 09/20/2025 | 19:30     | 50         | Non-Veg  | 456 Lake Rd  | Coimbatore | 411001  |
      
      
#Test case/Scenario woth all valid details using Scenario Outline with Invalid Event Type
      @BookingForm @DataDriven @InvalidEventDate
	  Scenario Outline: Invalid Event Date
	    When the user enters the details "<FirstName>", "<LastName>", "<Phone>", "<Email>", "<EventType>", "<EventDate>", "<EventTime>", "<GuestCount>", "<Catering>", "<Address>", "<City>", and "<Pincode>"
	    Then The user clicks the Book Now button
	    Then Take Screenshot Invalid Scnario
	    And Close the browser

    Examples:
      | FirstName | LastName | Phone      | Email             | EventType | EventDate  | EventTime | GuestCount | Catering | Address      | City       | Pincode |
      | Micheal  | Starc    | 9876543210 | micheal.s@email.com   | Anniversary   | xyz | 18:00     | 150        | Veg      | 123 Mithun | Chennai    | 400087  |
      
      
#Test case/Scenario woth all valid details using Scenario Outline with Invalid Event Time
      @BookingForm @DataDriven @InvalidEventTime
	  Scenario Outline: Invalid Event Time
	    When the user enters the details "<FirstName>", "<LastName>", "<Phone>", "<Email>", "<EventType>", "<EventDate>", "<EventTime>", "<GuestCount>", "<Catering>", "<Address>", "<City>", and "<Pincode>"
	    Then The user clicks the Book Now button
	    Then Take Screenshot Invalid Scnario
	    And Close the browser

    Examples:
      | FirstName | LastName | Phone      | Email             | EventType | EventDate  | EventTime | GuestCount | Catering | Address      | City       | Pincode |
      | Adam  | Mathew    | 9876543210 | adam.m@email.com   | Corporate   | 04/11/2025 | xyz     | 150        | Non-Veg      | Sec 7 Hungry | Coimbatore    | 400071  |
      