Feature:Oranization module

## User can login vtiger and create a org

Scenario: Create a oragnaization field in mandatory

Given launch the browser
And Enter  the URL
And In login page enter username and password and click on login button
 and click on indusrty and click on save button
Then Verify organization created and industry

Scenario Outline:

Given launch the browser
And Enter  the URL 
And In login page enter username and password and click on login button
When Click on org link
And CLick on org image
And Enter OrganizationName "<orgName>" and "<emailid>" select the industry and click on save button
Then Verify the organization  "<orgName>" is created and industry
And verify eamil "<emailid>"

Examples:
|orgName | emailid                   |
|TestYantra|testyantra113@gmail.com|
|Qspider  |qspider113@gmail.com|
|jspider  |jspider113@gmail.com  |

Scenario Outline:User create org with excel reader


Given launch the browser
And Enter  the URL
And In login page enter username and password and click on login button
When Click on org link
And CLick on org image
And Enter the OrganizationName orgName and email and click on the save button


|orgName  |email            |
|Ajio     |ajio123@gmail.com|
|Myntra   |myntra123@gmail.com|

Then verify orgName is created or not
|orgName|
|Ajio   |
|myntra |







