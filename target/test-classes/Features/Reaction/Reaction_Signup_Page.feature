Feature: Register to Axate



#****
#POPSMO01 
Scenario: Successful signup from reaction FUN  
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And top up with a valid card in steptwo with three pounds and click on continue
Then I get a funded axate wallet with three pounds in it
And navigated to the same article
And finish notice appears

#****
#POPSMO02 
Scenario: Successful signup from reaction Wallet staging
Given I am a user of Axate and I am on the registration page through reaction Wallet homepages "browser"
When I enter all the required details on step one and click on continue
And top up with a valid card in steptwo with three pounds and click on continue
Then I get a funded axate wallet with three pound in it
And navigated to reaction.com

#****
#POPSMO03
Scenario: Successful registration through login page reaction
Given I am a user of Axate and I am on the login page through reaction FUN "browser"
When I click on register here on the login page
And I enter all the required details on step one and click on continue
And top up with a valid card in steptwo with three pounds and click on continue
Then I get a funded axate wallet with three pounds in it
And navigated to the same article
And finish notice appears


#****
#POPSMO04
Scenario: Payment system loads on selecting three pounds on regpage two 
Given I am a user of Axate and I am on the registration page through reaction Wallet homepages "browser"
When I enter all the required details on step one and click on continue
And I click on three pounds on regpage two
Then payment system displays card option
And payment system displays paypal option

#****
#POPSMO05
Scenario: Payment system loads on selecting five pounds on regpage two
Given I am a user of Axate and I am on the registration page through reaction Wallet homepages "browser"
When I enter all the required details on step one and click on continue
And I click on five pounds on regpage two
Then payment system displays card option
And payment system displays paypal option

#****
#POPSMO06
Scenario: Payment system loads on selecting eight pounds on regpage two
Given I am a user of Axate and I am on the registration page through reaction Wallet homepages "browser"
When I enter all the required details on step one and click on continue
And I click on eight pounds on regpage two
Then payment system displays card option
And payment system displays paypal option

#POPSMO07- already included in test case POPSMO01
Scenario: Successful signup from reaction FUN with three poundss "browser"
Given I am a user of Axate and I am on the registration page through reaction FUN
When I enter all the required details on step one and click on continue
And I click on three pounds on regpage two
And enter valid card details and click on continue
Then I get a funded axate wallet with three pounds in it
And navigated to the same article
And finish notice appears


#POPSMO08
Scenario: Successful signup from reaction FUN with five pounds
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And I click on five pounds on regpage two
And enter valid card details and click on continue
Then I get a funded axate wallet with three pounds in it
And navigated to the same article
And finish notice appears


#POPSMO09
Scenario: Successful signup from reaction FUN with eight pounds
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And I click on eight pounds on regpage two
And enter valid card details and click on continue
Then I get a funded axate wallet with five pounds in it
And navigated to the same article
And finish notice appears

#POPSMO10
Scenario: Sucessful user registration with an empty wallet on skipping payment  
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And I skip the payment and navigating to a premium article on reaction
Then I get an unfunded axate wallet with zero pounds in it
And an ADD funds notice is displayed

#POPSMO11
Scenario: Axate lets user select their country
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And I click on three pounds on regpage two
And enter valid card details
And I select country as spain from the drop down on reg page two
Then Country in the personal information page in the account page is spain 



#POPSMO12
Scenario: Seleting US as country required the state and zip code from the user
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And I click on three pounds on regpage two
And enter valid card details
And I select country as United states from the drop down on reg page two
Then state is displayed
And postcode is displayed



# POPSMO8
Scenario: User registers by selecting USA as their country 
Given I am a user of Axate and I am on the registration page through reaction FUN "browser"
When I enter all the required details on step one and click on continue
And I click on three pounds on regpage two
And enter valid card details
And I select country as United states from the drop down on reg page two
And I enter state as Alaska
And I enter Zipcode 
Then Country in the personal information page in the account page is united states 

