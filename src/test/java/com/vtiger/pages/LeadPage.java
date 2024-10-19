package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.Utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends HeaderPage {
    public LeadPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='lastname']")
    WebElement tb_lastname;

    @FindBy(xpath="//input[@name='company']")
    WebElement tb_company;

    @FindBy(xpath="//input[@name='button123']")
    WebElement btn_save;


    public void createLeadwithMandaotyFields(String lname,String comp)
    {
        setLastName(lname);
        setCompany(comp);
        clickSave();
    }

    public void setLastName(String lname)
    {
        SetInput(tb_lastname,lname,lname+" has been entered into lastname field");
    }

    public void setCompany(String comp)
    {
        SetInput(tb_company,comp,comp+" has been entered into company field");
    }

    public void clickSave()
    {
        clickElement(btn_save,"Save button clicked");
    }




}
