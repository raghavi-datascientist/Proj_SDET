Feature: Login Feature
This Application include
1)Login to Application and validate User Email
2)Login to Application and Compose an Email
Background:
Given Login application present
@LoginAndValidateEmail
Scenario Outline: Login to application validate User Email
When enter valid username "<username>"
And enter valid password "<password>"
And click on Login validButton
Then I should see email as "<email>"
Then close the driver
Examples:
|username|password|email|
|Raghavi|ragh@1234|raghavi.br@gmail.com|
@LoginAndComposeEmail
Scenario Outline: Login to application validate User Email
When enter valid username "<username>"
And enter valid password "<password>"
And click on Login validButton
Then I should see email as "<email>"
And click on Inbox
And click on Compose Message
And enter value for Send to as "<sendTo>"
And enter Subject as "<subject>"
And enter Message as "<message>"
And click on send button
Then I should see acknowledgement as "<ack>"
Then close the driver
Examples:
|username|password|email		|sendTo		|subject	|message                   			    |ack|
|Raghavi|ragh@1234|raghavi.br@gmail.com|abc1234567	|Hi For Testing	|Hello Admin,\n This is for testing. \nFrom,\n Raghavi|The message has been sent to abc def (abc1234567)|
