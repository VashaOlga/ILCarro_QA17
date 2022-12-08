package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;
    HelperRegistration newUser;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        user = new HelperUser(wd);
        newUser = new HelperRegistration(wd);


    }
//    612test@mail.com
//    1425Asd@

    public HelperUser getUser() {
        return user;
    }

    public HelperRegistration getNewUser() {
        return newUser;
    }

    public void stop() {
//        wd.quit();
    }
}
