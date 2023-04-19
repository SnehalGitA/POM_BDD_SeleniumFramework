@All
Feature: Login Page

Scenario: Login Page Title

Given User is on Login Page
When User get the title of the page
Then Page title should be "OrangeHRM"

Scenario: Login with Credentials

Given User is on Login Page
When User enters username "Admin"
And User enters password "admin123"
And User Click Login Button
Then user should be logged in successfully