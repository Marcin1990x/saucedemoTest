
# saucedemo.com Selenium tests

My simple project to practice Selenium library using Java.

Java version 19, Maven version 4.0.0

Project was written using Page Object pattern.

What is included:
- simple website tests with assertions;
- possibility to choose browser using config.properties file;
- dataProvider to simplify code;
- method to use for waiting for element which need this instead
of implicit wait for all elements;
- Extent report for one of tests with screenshot maker;

Tests: 
- buying test: whole process of buying one product;
- login tests with different scenarios;
- logout test;
- remove from shopping cart test;
- product sort tests: all available scenarios;

Added assertions and report for buying test are not detailed to catch and show all possible defects.
This was created only for practise, not to cover all what would be needed in real project.
