package com.vtiger.stepdefinitions;

import com.codoid.products.exception.FilloException;
import com.vtiger.pages.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class Login extends PageObjectManager {


    @Before
    public void getScenarioName(Scenario scene) throws FilloException, IOException {
        if(extent==null)
        {
            initiation();
        }
        TCName = scene.getName();
        logger = extent.createTest(TCName);
    }
    @After
    public void savereport()
    {
        extent.flush();
    }

    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws IOException, FilloException {

        launchApp();

    }
    @When("user enter valid credentials and click on login button")
    public void user_enter_valid_credentials_and_click_on_login_button() {
        getLoginPage().login(dt.get(TCName).get("userid"),dt.get(TCName).get("password"));
    }
    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() {
        getLeadPage().ValidateLogout();
    }

    @When("user enter invalid credentials and click on login button")
    public void user_enter_invalid_credentials_and_click_on_login_button() {
        getLoginPage().login("admin12","admin123");
    }
    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {
        getLoginPage().ValidateUserId();
    }
    @Then("user can see the error message")
    public void user_can_see_the_error_message() {
        getLoginPage().ValidateErrorMsg();
    }

    @And("close browser")
    public void close_browser() {
        driver.quit();
    }

    @When("user enter userid as {string} and password as {string} and click on login button")
    public void user_enter_userid_as_and_password_as_and_click_on_login_button(String uid, String pwd) {
        getLoginPage().login(uid,pwd);
    }

}
