package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        //WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");

        driver.get("https://calendar.google.com/");
        WebElement signIn = driver.findElement(By.xpath("//div[@class='hero-scroll__header__chapter__buttons']"));
        signIn.click();
        Thread.sleep(2000);
        WebElement emailIdField = driver.findElement(By.xpath("//input[@type='email']"));
        emailIdField.sendKeys("yash.external@gmail.com");
        WebElement nextCTA = driver.findElement(By.xpath("//span[text()='Next']"));
        nextCTA.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Abcd@123");
        Thread.sleep(1000);
        WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
        next.click();
        Thread.sleep(3000);

        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        if(URL.contains("calendar")){
            System.out.println("URL contains calendar in it");
        }else{
            System.out.println("URL doesnot calendar LeetCode in it");
        }
        System.out.println("end Test case: testCase01");
    }



    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");

        // driver.get("https://calendar.google.com/");
        // WebElement signIn = driver.findElement(By.xpath("//div[@class='hero-scroll__header__chapter__buttons']"));
        // signIn.click();
        // Thread.sleep(2000);
        // WebElement emailIdField = driver.findElement(By.xpath("//input[@type='email']"));
        // emailIdField.sendKeys("yash.external@gmail.com");
        // WebElement nextCTA = driver.findElement(By.xpath("//span[text()='Next']"));
        // nextCTA.click();
        // Thread.sleep(3000);
        // WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        // password.click();
        // password.sendKeys("Abcd@123");
        // Thread.sleep(1000);
        // WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
        // next.click();
        // Thread.sleep(3000);

        WebElement dayMonthSwitch = driver.findElement(By.xpath("//span[@id='VjyWCf']/parent::div"));
        dayMonthSwitch.click();
        WebElement month = driver.findElement(By.xpath("//span[text()='Month']"));
        month.click();
        Thread.sleep(1000);

        String u = driver.getTitle();
        System.out.println(u);
        if(u.contains("March")){
            System.out.println("Switched to month view");
        }else{
            System.out.println("NOt Switched to month view");
        }

        WebElement checkMonth = driver.findElement(By.xpath("//span[@id='VjyWCf']/parent::div//span[@jsname='V67aGc']"));
        String s = checkMonth.getText();
        if(s.equals("Month")){
            System.out.println("Switched to month view");
        }else{
            System.out.println("NOt Switched to month view");
        }
        if(checkMonth.isDisplayed()){
            System.out.println("Switched to month view");
        }

        WebElement date = driver.findElement(By.xpath("//div[@data-datekey='27765']"));
        date.click();
        Thread.sleep(1000);

        WebElement task = driver.findElement(By.xpath("//div[@class='x5FT4e kkUTBb' and text()='Task']"));
        task.click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.xpath("//input[@aria-label='Add title and time']"));
        title.sendKeys("Crio INTV Task Automation");
        Thread.sleep(1000);

        WebElement description = driver.findElement(By.xpath("//textarea[@aria-label='Add description']"));
        description.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(1000);

        WebElement save = driver.findElement(By.xpath("//span[text()='Save']/parent::button"));
        save.click();

        System.out.println("end Test case: testCase02");
    }

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");

        // driver.get("https://calendar.google.com/");
        // WebElement signIn = driver.findElement(By.xpath("//div[@class='hero-scroll__header__chapter__buttons']"));
        // signIn.click();
        // Thread.sleep(2000);
        // WebElement emailIdField = driver.findElement(By.xpath("//input[@type='email']"));
        // emailIdField.sendKeys("yash.external@gmail.com");
        // WebElement nextCTA = driver.findElement(By.xpath("//span[text()='Next']"));
        // nextCTA.click();
        // Thread.sleep(3000);
        // WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        // password.sendKeys("Abcd@123");
        // Thread.sleep(1000);
        // WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
        // next.click();
        // Thread.sleep(3000);

        WebElement task = driver.findElement(By.xpath("//h2[contains(text(),'March 21')]/parent::div"));
        task.click();
        Thread.sleep(1000);
        WebElement editOption = driver.findElement(By.xpath("//button[@aria-label='Edit task']"));
        editOption.click();

        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        description.clear();
        description.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(1000);

        WebElement save = driver.findElement(By.xpath("//span[text()='Save']/parent::button"));
        save.click();
        Thread.sleep(1000);
        task.click();

        WebElement taskdescription = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
        if(taskdescription.isDisplayed()){
             System.out.println("Task Description Displayed");
         }

        editOption = driver.findElement(By.xpath("//button[@aria-label='Edit task']"));
        editOption.click();
        description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));

        String desc = description.getText();
        String expected = "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application";
        if(desc.equals(expected)){
            System.out.println("Description Updated");
        }else{
            System.out.println("Description not Updated");
        }

        WebElement cross = driver.findElement(By.xpath("(//button[@aria-label='Close'])[2]"));
        cross.click();

        System.out.println("end Test case: testCase03");
        Thread.sleep(3000);
    }


    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");

        // driver.get("https://calendar.google.com/");
        // WebElement signIn = driver.findElement(By.xpath("//div[@class='hero-scroll__header__chapter__buttons']"));
        // signIn.click();
        // Thread.sleep(2000);
        // WebElement emailIdField = driver.findElement(By.xpath("//input[@type='email']"));
        // emailIdField.sendKeys("yash.external@gmail.com");
        // WebElement nextCTA = driver.findElement(By.xpath("//span[text()='Next']"));
        // nextCTA.click();
        // Thread.sleep(3000);
        // WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        // password.sendKeys("Abcd@123");
        // Thread.sleep(1000);
        // WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
        // next.click();
        // Thread.sleep(3000);
        Thread.sleep(2000);
        WebElement task = driver.findElement(By.xpath("//h2[contains(text(),'March 21')]/parent::div"));
        task.click();
        Thread.sleep(1000);

        WebElement title = driver.findElement(By.xpath("//div[@class='Mz3isd']//span[@role='heading']"));
        String str = title.getText();
        if(str.equals("Crio INTV Task Automation")){
            System.out.println("Title matches");
        }else{
            System.out.println("Title doesn't matches");
        }

        WebElement deleteOption = driver.findElement(By.xpath("//button[@aria-label='Delete task']"));
        deleteOption.click();

        WebElement taskDeleteMessage = driver.findElement(By.xpath("//div[text()='Task deleted']"));
        if(taskDeleteMessage.isDisplayed()){
            System.out.println("Task Successfully Deleted");
        }else{
            System.out.println("Task not Deleted");
        }
        if(taskDeleteMessage.getText().equals("Task deleted")){
            System.out.println("Task Delete message matched");
        }else{
            System.out.println("Task Delete message not matched");
        }

        System.out.println("end Test case: testCase04");
    }

}
