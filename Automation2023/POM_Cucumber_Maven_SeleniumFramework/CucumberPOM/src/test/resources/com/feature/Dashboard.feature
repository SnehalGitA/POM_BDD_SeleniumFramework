Feature: Login to Orange site and validate Dashboard page

Background:
Given User has already logged in to application
|UserName|Password|
|Admin   |admin123|


Scenario: Dashboard Page
When User is on Dashboard page
Then Title should be "Dashboard"


