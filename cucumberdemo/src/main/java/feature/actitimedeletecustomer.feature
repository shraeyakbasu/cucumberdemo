Feature: actitime delete customer
Scenario: actitime delete customer

Given when user is on login page
Then user enter username "admin" and password "manager"
Then user click on login button
Then user click on task link
And click on addnew button and click on new customer link
Then give customer name "qspiders" and description "educational institute"
And click on createcustomer button
Then click on quicktoview settings link
And then click on action button
And select delete link
Then click on delete permanently button
And logout from site

