Feature: Tutorial Ninja Login Application

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "infosys@gmail.com" and password as "Infosys@123" into the fields
And User clicks on Login button
Then Verify user is able to successfully login