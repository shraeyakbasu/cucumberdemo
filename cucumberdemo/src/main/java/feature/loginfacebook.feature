Feature: facebook login logout
Scenario Outline: facebook login logout

Given user is on facebook login page
Then user enters username "<username>" and password "<password>"
Then click on facebook login button
When user is on facebook home page 
Then click upon facebook logout link
And close the facebook browser

Examples: 
           | username | password |
          | abc@gmail.com | abcdxyz |
          | xyz@yahoo.com | abc123 |
          | shraeyak1993@gmail.com | rivukhelaghar |