$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\CustomerAccounts.feature");
formatter.feature({
  "name": "Customer Accounts feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@All"
    }
  ]
});
formatter.background({
  "name": "Customer is in the login page",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Customer is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "CustomerAccountStepDef.customer_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login to GMI Bank as customer",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerAccountStepDef.login_to_GMI_Bank_as_customer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click My Operations icon on the top right corner of the page",
  "keyword": "And "
});
formatter.match({
  "location": "CustomerAccountStepDef.click_My_Operations_icon_on_the_top_right_corner_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User should see all account types and balance populated",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@All"
    },
    {
      "name": "@MyAccounts"
    }
  ]
});
formatter.step({
  "name": "Customer clicks My Accounts button",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerAccountStepDef.customer_clicks_My_Accounts_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Customer is in the login page",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Customer is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "CustomerAccountStepDef.customer_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login to GMI Bank as customer",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerAccountStepDef.login_to_GMI_Bank_as_customer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click My Operations icon on the top right corner of the page",
  "keyword": "And "
});
formatter.match({
  "location": "CustomerAccountStepDef.click_My_Operations_icon_on_the_top_right_corner_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User can view transaction",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@All"
    },
    {
      "name": "@TransferMoney"
    }
  ]
});
formatter.step({
  "name": "Customer clicks Transfer Money and view transaction",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerAccountStepDef.customer_clicks_Transfer_Money_and_view_transaction()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});