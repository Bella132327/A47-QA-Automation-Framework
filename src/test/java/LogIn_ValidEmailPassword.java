import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn_ValidEmailPassword extends BaseTest {
    @Test
    public void LogIn_ValidEmailPassword() throws InterruptedException {

//        openLoginUrl();
        openURL();

        enterEmail1("aimee.woodside@testpro.io");

        enterPassword1("te$t$tudent13");

//        clickLogInbutton();
        clickLoginBtn1();

        navigatePageBack();
        navigatePageForward();

        displayAvatarIcon();
    }
}
