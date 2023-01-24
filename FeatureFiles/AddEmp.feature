Feature:
As admin user Validate Emp Creation
@AddEmp
Scenario Outline:
Validate Add Emp with multiple data
Given User naviget url "http://orangehrm.qedgetech.com/" in a browser
When user enter username "Admin" and Enter password "Qedge123!@#"
When  user click Login button
When user click pim and add button
When user enter fname"<FirstName>" and mname "<MiddleName>" and lname"<LastName>"
When user captures Employee id before saving
When user click save button
When user capture employee id after save
Then user validate employee id
Then user close browser
Examples:
|FirstName|MiddleName|LastName|
|Akhilesh23|Selenium1|testing53|
|Akhilesh58|Selenium2|testing57|
|Akhilesh79|Selenium3|testing59|
|Akhilesh45|Selenium4|testing50|
|Akhilesh10|Selenium6|testing53|
|Akhilesh23098|Selenium9|testing53|