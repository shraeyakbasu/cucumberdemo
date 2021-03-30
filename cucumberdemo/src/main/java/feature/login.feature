Feature: actitime login feature
Scenario: actitime login scenario

Given user is already on login page
When title of the page is actiTIME -  Login 
Then enter username "admin" and password "manager"
And click on the login button
When title of the page is actiTIME -  Enter Time-Track
Then click on logout link
And quit the browser
