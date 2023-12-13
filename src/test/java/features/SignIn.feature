Feature: To test the Sign In functionality of Chiltern Oak Furniture Website

Background:
Given I am on the Furniture Website HomePage
When I click on Sign In icon

Scenario: Passed Sign In functionality
And I enter EmailId and Password
Then I click on Sign In button

Scenario: Failed Sign In functionality
And I enter wrong EmailId and Password
Then click on Sign In button
