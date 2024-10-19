package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.Utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends PageActions {


    public HeaderPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText="Logout")
    WebElement lnk_logout;

    @FindBy(linkText="New Lead")
    WebElement lnk_NewLead;

    @FindBy(linkText="Leads")
    WebElement lnk_Leads;

    @FindBy(linkText="New Contact")
    WebElement lnk_NewContact;


    public void clickLogout()
    {
        clickElement(lnk_logout,"link logout clicked");
    }
    public void clickNewLead()
    {
        clickElement(lnk_NewLead,"link new lead clicked");
    }

    public void clickNewContact()
    {
        clickElement(lnk_NewContact,"link new contact clicked");
    }

    public void clickLeads()
    {
        clickElement(lnk_Leads, "link leads clicked");
    }

    public void ValidateLogout()
    {
        ElementExist(lnk_logout,"Logout exist on Home Page");
    }
}
