import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    protected static void openLoginUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    public static void openURL() {
        driver.get("https://qa.koel.app/");
    }

    protected static void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public static void enterEmail1(String emailInput) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(emailInput);
    }

    protected static void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public static void enterPassword1 (String passwordInput) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(passwordInput);
    }

    public static void clickLoginBtn1 () {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void clickLogInbutton() {
        WebElement LogInButton = driver.findElement(By.cssSelector("button[type='submit']"));
        LogInButton.click();
    }

    public static void displayAvatarIcon1() {
        WebElement avatarImg = driver.findElement(By.cssSelector("img.avatar"));
        avatarImg.isDisplayed();
        
    }

    // Profile Tests Helper Functions
    protected static void displayAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.isDisplayed();
    }

    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchSongInput = driver.findElement(By.cssSelector("input[type='search']"));
        searchSongInput.click();
        searchSongInput.clear();
        searchSongInput.sendKeys(songTitleKeyword);
        Thread.sleep(3000);
    }

    public void clickViewAllSearchBtn() throws InterruptedException {
        WebElement ViewAllSearchButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        ViewAllSearchButton.click();
        Thread.sleep(3000);
    }

    public void clickFirstSongSearchResult() throws InterruptedException {
        WebElement FirstSongSearchResult = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        FirstSongSearchResult.click();
        Thread.sleep(3000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement AddToButton = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
        AddToButton.click();
        Thread.sleep(3000);
    }

    public void selectPlayList() throws InterruptedException {
        WebElement selectedPlaylist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        selectedPlaylist.click();
        Thread.sleep(3000);
    }

    public String getNotificationMessage() {
        WebElement notificationAlert = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationAlert.getText();
    }

    public static void navigatePageBack() throws InterruptedException{
        driver.navigate().back();
        Thread.sleep(3000);
    }

    public static void navigatePageForward() throws InterruptedException{
        driver.navigate().forward();
        Thread.sleep(3000);
    }

}