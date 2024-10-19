package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.Utilities.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageActions {



    public LoginPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//input[@name='user_name']")
    WebElement tb_username;

    @FindBy(xpath="//input[@name='user_password']")
    WebElement tb_password;

    @FindBy(xpath="//input[@name='Login']")
    WebElement btn_login;

    @FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement error_msg;


    //String tb_username = "//input[@name='user_name']";

    //By tb_username = By.xpath("//input[@name='user_name']");

    public void ValidateErrorMsg()
    {
        ElementExist(error_msg,"Error message validated successfully");
    }


    public void login(String userid, String pwd)
    {
        setUserId(userid);
        setPassword(pwd);
        clickLogin();
    }

    public void login(String userid, String pwd, String Theme)
    {
        setUserId(userid);
        setPassword(pwd);
        clickLogin();
    }

    public void setUserId(String userid)
    {
       SetInput(tb_username,userid,userid+" has been entered into username field");
    }

    public void ValidateUserId()
    {
        ElementExist(tb_username,"Element Userid exist on login page");
    }

    public void setPassword(String pwd)
    {
        SetInput(tb_password,pwd,pwd+" has been entered into password field");
    }

    public void clickLogin()
    {
        //btn_login.click();
        clickElement(btn_login,"Login button clicked");
    }




}
