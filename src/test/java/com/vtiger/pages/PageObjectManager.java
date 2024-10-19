package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.stepdefinitions.Basedefinition;
import org.openqa.selenium.WebDriver;

public class PageObjectManager extends Basedefinition {


    public LoginPage lp;
    public HomePage hp;
    public LeadPage ldp;
    public HeaderPage hdp;
    public ContactPage cp;


  /*  public PageObjectManager(WebDriver driver, ExtentTest logger)
    {
        this.driver = driver;
        this.logger = logger;
    }*/

    public LoginPage getLoginPage()
    {
       return lp = (lp == null) ? new LoginPage(driver,logger) : lp;
    }
    public LeadPage getLeadPage()
    {
        return ldp = (ldp == null) ? new LeadPage(driver,logger) : ldp;
    }
    public HeaderPage getHeaderPage()
    {
        return hdp = (hdp == null) ? new HeaderPage(driver,logger) : hdp;
    }
    public ContactPage getContactPage()
    {
        return cp = (hdp == null) ? new ContactPage(driver,logger) : cp;
    }
}
