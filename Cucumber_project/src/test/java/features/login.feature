Feature:Login module

Background:
Given Launch the browser
And Enter the URL

Scenario:User can login to application using Valid credentials

When Login page is displayed enter username and password
When  Click on login button
Then Verify Homepage is displayed or not


Scenario:User can login to application using Valid credentials

When Login page is displayed enter username "admin123" and password "admin123"
When  Click on login button
Then Verify error message is displayed or not
