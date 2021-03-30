Feature: gurubank create customer
Scenario: gurubank create customer

Given user is on login page
When user enter username and password
       | userid | password |
       | mngr317253 | ujYsere |
       
And click on login button
Then user is on home page
Then user click on new customer button
And user give valid details and submit
       | customername  | dateofbirth | address | city    | state       | pin    | mobilenumber | email             | password |
       | puranjoy basu | 27021993    | abcd    | kolkata | west bengal | 123456 | 7980878745   | basu123@gmail.com | abcxyz   |
       | aishikee basu | 25112001    | efgh    | kolkata | west bengal | 789123 | 123456789    | basu456@yahoo.com | xyz123   |
       
And logout from the application 
And quit the browser