Feature: guru bank current account
Scenario: guru bank current account

Given when user is on gurubank login page to create current account
Then he enters username and password
       |   userid     | password |
       | mngr317253   | ujYsere  |
      
And he clicks on login button
When user is on gurubank home page 
Then user clicks on new account link
When user is on gurubank add new account page
Then he enters valid details and click on submit
       | customerid | initialdeposit |
       | 49403      |  5000    |
       | 49403      |  4000    |
       | 49403      |  8000   |

And logout and quit the browser