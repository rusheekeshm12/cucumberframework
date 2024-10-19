package com.vtiger.Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {

    public WebDriver driver;
    public WebDriverWait wait;
    public ExtentTest logger;

    public PageActions(WebDriver driver, ExtentTest logger)
    {
        this.driver = driver;
        this.logger = logger;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void SetInput(WebElement elm,String value,String msg)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            logger.pass(msg);
        }
        catch(Exception  e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter data due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }

    public void SelectDropdownText(WebElement elm,String txt,String msg)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(elm));
            Select sel = new Select(elm);
            sel.selectByVisibleText(txt);
            logger.pass(msg);
        }
        catch(Exception  e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to select text from dropdown due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }



    public void clickElement(WebElement elm, String msg)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            logger.pass(msg);
        }
        catch(Exception  e)
        {
            System.out.println(e.getMessage());
            logger.fail("unable to click on element due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }


    public void ElementExist(WebElement elm, String msg)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            logger.pass(msg);
        }
        catch(Exception  e)
        {
            System.out.println(e.getMessage());
            logger.fail("Element does not exist due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }

    public void SwitchWindow(String win, String msg)
    {
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> set = driver.getWindowHandles();
            Iterator<String> iter = set.iterator();
            String fwin = iter.next();
            String swin = iter.next();
            if (win.equals("second")) {
                driver.switchTo().window(swin);
            } else if (win.equals("first")) {
                driver.switchTo().window(fwin);
            }

            logger.pass(msg);
        }
        catch(Exception  e)
        {
            System.out.println(e.getMessage());
            logger.fail("unable to switch the window due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }


    public  String getscreenshot()
    {
        DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
        Date d = new Date();
        String str = f.format(d);
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;

    }
}
