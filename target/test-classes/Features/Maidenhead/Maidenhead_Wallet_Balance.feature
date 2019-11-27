Feature: Maidenhead wallet balance 


#MAISMO14
Scenario: Register on Maidenhead and navigate to other publications has the same wallet balance on all the publications
Given I am a user of Axate and I am on the registration page through popbitch FUN "browser"
When I register successfully on Maidenhead with three pound
And I check in wallet balance on Maidenhead
And I navigate to reaction 
And I check in wallet balance on slough
And I navigate to cricketer 
And I check in wallet balance on windsor
Then the wallet balance is same across the publications

#MAISMO15
Scenario: Reading an article on Maidenhead and navigate to other publications has the same wallet balance on all the publications
Given I am a user of Axate and I am on the registration page through popbitch FUN "browser"
When I register successfully on Maidenhead from FUN
And I read an article on Maidenhead
And I check in wallet balance on Maidenhead
And I navigate to reaction 
And I check in wallet balance on slough
And I navigate to cricketer 
And I check in wallet balance on windsor
Then the wallet balance is same across the publications