import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest() {

        User data = new User().withEmail("612test@mail.com").withPassword("1425Asd@");
        app.getUser().openLoginForm();
//    String email = "612test@mail.com";
//    String password = "1425Asd@";
//    app.getUser().fillLoginForm(email, password);
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();

        app.getUser().pause(5);
//        Assert.assertTrue(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginWrongEmailTest() {

        User data = new User().withEmail("612test.mail.com").withPassword("1425Asd@");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();


        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[text()='Ok']")));
    }

    @Test
    public void loginWrongPasswordTest() {

        User data = new User().withEmail("612test@mail.com").withPassword("1425Asd");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();

        app.getUser().pause(3);
        app.getUser().clockOkButton();

        Assert.assertFalse(app.getUser().isLogged());
    }

    @AfterMethod
    public void postCondition() {
//        app.getUser().pause(3);
//        if (app.getUser().isElementPresent(By.xpath("//button[text()='Ok']"))) {
//            app.getUser().clockOkButton();
//        }
    }
}
