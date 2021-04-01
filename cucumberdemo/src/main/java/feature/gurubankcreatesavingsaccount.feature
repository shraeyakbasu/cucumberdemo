Feature: create savings account
Scenario: create savings account

Given when user is on gurubank login page
Then user enters valid username "mngr317253" and password "ujYsere"
And he clicks on gurubank login button
Then when user is on gurubank homepage
Then he clicks on new account link
And he enters all valid details 
And clicks on submit button
Then logout from the application and quit the browser