package com.vtiger.stepdefinitions;

import com.vtiger.pages.PageObjectManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Leads extends PageObjectManager {



    @Given("user should be on lead creation form")
    public void user_should_be_on_lead_creation_form() {

        //driver.findElement(By.linkText("New Lead")).click();
        getLeadPage().clickNewLead();

    }
    @When("user enters the all mandatories fields and click on save button")
    public void user_enters_the_all_mandatories_fields_and_click_on_save_button() {
        System.out.println(TCName);
        System.out.println(dt);
        System.out.println(dt.get(TCName).get("lastname"));
        System.out.println(dt.get(TCName).get("company"));
        System.out.println(dt);
        getLeadPage().createLeadwithMandaotyFields(dt.get(TCName).get("lastname"),dt.get(TCName).get("company"));

    }
    @Then("lead should be created successfully")
    public void lead_should_be_created_successfully() {
         driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("Modi");
        driver.findElement(By.xpath("//td[text()='Company:']/following::td[1]")).getText().equals("BJP");
    }

}
