$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\homePage.feature");
formatter.feature({
  "name": "Go to Home Page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@HomePage"
    }
  ]
});
formatter.scenario({
  "name": "User go to Gmibank Home Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@HomePage"
    }
  ]
});
formatter.step({
  "name": "user go to \"https://www.gmibank.com/\"",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});