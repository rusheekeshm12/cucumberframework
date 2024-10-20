package com.vtiger.stepdefinitions;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.PageObjectManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Basedefinition  {


    public static Map<String,Map<String,String>> dt;
    public static WebDriver driver;
    public static Properties prop;


    public static String TCName;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;




    public void initiation() throws IOException, FilloException {
        createExtentReport();
        readproperties();
        readExceldata(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx","Sheet1");
    }

    public void launchApp() {

        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("Env"));
        if (prop.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if (prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else
        {
            driver = new EdgeDriver();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void readproperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        prop.load(fis);
    }

    public void createExtentReport()
    {
       // Report_12102024111623.html
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }

    public void readExceldata(String workbook, String sheet) throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(workbook);
        String strQuery="Select * from "+sheet;
        Recordset recordset=connection.executeQuery(strQuery);
        List<String> lst = recordset.getFieldNames();
        int colmcount = lst.size();
         dt = new HashMap<>();

        while(recordset.next()){
            Map<String,String> rowdata = new HashMap<>();
           // System.out.println(recordset.getField("Details"));
            for(int i=1;i<colmcount;i++)
            {
                String colmName = lst.get(i);
                String colmdata = recordset.getField(colmName);
                rowdata.put(colmName,colmdata);
            }

            dt.put(recordset.getField("TCName"),rowdata);


        }

        System.out.println(dt);
        recordset.close();
        connection.close();
    }
}
