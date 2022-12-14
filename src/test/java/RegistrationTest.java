import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositiveTest(){

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Ted"+i;
        String lastName = "Smith"+i;
        String email = i+"test@mail.com";
        String password = i+"Zxcvb@";

        User data = new User().withName(name).withLastName(lastName).withEmail(email).withPassword(password);
        app.getNewUser().openRegistrationForm();
        app.getNewUser().fillRegistrationForm(data);
        app.getNewUser().submitRegistration();

        app.getNewUser().pause(5);
//        Assert.assertTrue(app.getUser().isLogged());
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void registrationExistUserTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Ted"+i;
        String lastName = "Smith"+i;
        User data = new User().withName(name).withLastName(lastName).withEmail("612test@mail.com").withPassword("1425Asd@");

        app.getNewUser().openRegistrationForm();
        app.getNewUser().fillRegistrationForm(data);
        app.getNewUser().submitRegistration();

        app.getNewUser().pause(5);
        Assert.assertTrue(app.getNewUser().isExpectedMessage(By.cssSelector(".dialog-container"), "User already exists"));

    }

    @Test
    public void registrationWrongEmailWithoutStrudelTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Ted"+i;
        String lastName = "Smith"+i;
        String email = i+"testmail.com";
        String password = i+"Zxcvb@";

        User data = new User().withName(name).withLastName(lastName).withEmail(email).withPassword(password);
        app.getNewUser().openRegistrationForm();
        app.getNewUser().fillRegistrationForm(data);
        app.getNewUser().submitRegistration();

        app.getNewUser().pause(5);
//        Assert.assertTrue(app.getNewUser().isExpectedMessage(By.xpath("//div[@class='error']"),"Wrong email format"));
//        Assert.assertTrue(app.getNewUser().isExpectedMessage(By.xpath("//div[@class='error ng-star-inserted']"),"Wrong email format"));
        Assert.assertTrue(app.getNewUser().isElementPresent(By.xpath("//div[text()='Wrong email format']")));
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[text()='Ok']")));
    }

    @AfterMethod
    public void postCondition(){
        app.getUser().pause(3);
        if(app.getUser().isElementPresent(By.xpath("//button[text()='Ok']"))) {
            app.getUser().clockOkButton();
        }
    }
}
