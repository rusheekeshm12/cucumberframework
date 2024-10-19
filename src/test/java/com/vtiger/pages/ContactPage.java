package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.Utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends PageActions {
    public ContactPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//select[@name='salutationtype']")
    WebElement dp_salutationtype;

    @FindBy(xpath="//input[@name='firstname']")
    WebElement tb_firstname;

    @FindBy(xpath="//input[@name='lastname']")
    WebElement tb_lastname;

    @FindBy(xpath="//input[@name='button']")
    WebElement btn_save;

    @FindBy(xpath="//input[@name='btn1']")
    WebElement btn_change;

    @FindBy(linkText="vtiger")
    WebElement lnk_vtiger;


    public void createNewAccount(String txt,String lname,String fname)
    {
        selectSalutaion(txt);
        setLastName(lname);
        setFirstName(fname);
        selectAccountName();
        clickSave();

    }

    public void selectSalutaion(String txt)
    {
        SelectDropdownText(dp_salutationtype,txt,txt+" has been selected from Salutation dropdown");
    }

    public void setLastName(String lname)
    {
        SetInput(tb_lastname,lname,lname+" has been entered into lastname field");
    }

    public void setFirstName(String fname)
    {
        SetInput(tb_firstname,fname,fname+" has been entered into FirstName field");
    }

    public void clickSave()
    {
        clickElement(btn_save,"Save button clicked");
    }

    public void clickChange()
    {
        clickElement(btn_change,"Change button clicked");
    }

    public void selectAccountName()
    {
        clickChange();
        SwitchWindow("second","switched to second window");
        clickElement(lnk_vtiger,"clicked on vtiger link on pop window");
        SwitchWindow("first","switched to first window");
    }

}
