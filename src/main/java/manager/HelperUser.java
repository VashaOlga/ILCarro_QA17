package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openLoginForm(){
        click(By.xpath("//*[@href='/login?url=%2Fsearch']"));
    }

//    public void fillLoginForm(String email, String password){
//        type(By.xpath("//input[@id='email']"),email);
//        type(By.xpath("//input[@id='password']"),password);
//    }
    public void fillLoginForm(User data){
        type(By.xpath("//input[@id='email']"), data.getEmail());
        type(By.xpath("//input[@id='password']"), data.getPassword());
    }

    public void clockOkButton(){
        click(By.xpath("//button[text()='Ok']"));
    }

}
