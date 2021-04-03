Feature: tagcucumberdemo

@SmokeTest @End2End @FunctionalTest
Scenario: login to gmail
Given when user is on gmail login page
Then user provide valid gmail user id "shraeyak1993@gmail.com" and password "lovemysister"
And user click on gmail login button
Then when user is on gmail home page he logout
And quit the gmail browser

@SmokeTest @RegressionTest
Scenario: login to yahoo mail
Given when user is on yahoo login page
Then user provide valid yahoo user id "shraeyak1992@yahoo.com" and password "lovemyself"
And user click on yahoo login button
Then when user is on yahoo home page he logout
And quit the yahoo browser

@SmokeTest @End2End
Scenario: login to amazon 
Given when user is on amazon login page
Then user provide valid amazon user id "shraeyak1993@gmail.com" and password "passwordamazon"
And user click on yahoo amazon button
Then when user is on amazon home page he logout
And quit the amazon browser

@SmokeTest @RegressionTest
Scenario: login to flipkart
Given when user is on flipkart login page
Then user provide valid flipkart user id "shraeyak1992@yahoo.com" and password "passwordflipkart"
Then when user is on flipkart home page he logout
And quit the flipkart browser

@SmokeTest @End2End
Scenario: login to gurubank
Given when user is on gurubanklogin page
Then user provide valid gurubank user id "mngr317253" and password "ujYsere"
And user click on gurubank login button
Then when user is on gurubank home page he logout
And quit the gurubank browser

@SmokeTest @RegressionTest @FunctionalTest
Scenario: login to actitime website
Given when user is on actitime login page
Then user provide valid actitime user id "admin" and password "manager"
And user click on actitime login button
Then when user is on actitime home page he logout
And quit the actitime browser