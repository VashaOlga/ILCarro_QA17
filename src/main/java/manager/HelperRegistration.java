package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperRegistration extends HelperBase{

    public HelperRegistration(WebDriver wd) {
        super(wd);
    }

    public void openRegistrationForm(){
        click(By.xpath("//*[@href='/registration?url=%2Fsearch']"));
    }

    public void fillRegistrationForm(User data){
        type(By.xpath("//input[@id='name']"), data.getName());
        type(By.xpath("//input[@id='lastName']"), data.getLastName());
        type(By.xpath("//input[@id='email']"), data.getEmail());
        type(By.xpath("//input[@id='password']"), data.getPassword());
//        click(By.xpath("//div[@class='checkbox-container']"));
//        click(By.xpath("//input[@class='ng-dirty ng-touched ng-valid']"));

        if(!isElementPresent(By.xpath("//input[@class='ng-dirty ng-touched ng-valid']"))){
            click(By.xpath("//div[@class='checkbox-container']"));
        }

    }

    public void submitRegistration() {
        click(By.xpath("//button[@type='submit']"));
    }


}
