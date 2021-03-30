Feature: actitime create customer feature
Scenario: actitime create customer scenario

Given  as user is on login page
When title of page is actiTIME -  Login 
Then user enters valid username and password
And user clicks on login button
When title of page is actiTIME -  Enter Time-Track
Then click on tasks link
When title of page is actiTIME -  Task List
Then click on add new button and click on new customer link
Then enter valid customer name and description 
And click on create customer button
And logout from application 
