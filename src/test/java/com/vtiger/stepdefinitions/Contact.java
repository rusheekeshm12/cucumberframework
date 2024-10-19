package com.vtiger.stepdefinitions;

import com.vtiger.pages.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Contact extends PageObjectManager {

    @Given("user should be on contact form")
    public void user_should_be_on_contact_form() {
         getHeaderPage().clickNewContact();
    }
    @When("user enters the all required fields and click on save button")
    public void user_enters_the_all_required_fields_and_click_on_save_button() {
        getContactPage().createNewAccount(dt.get(TCName).get("salutation"),dt.get(TCName).get("lastname"),dt.get(TCName).get("firstname"));
    }
    @Then("contact should be created successfully")
    public void contact_should_be_created_successfully() {

    }
}
