package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el correo del usuario
     * @param correo del usuario
     */
    public void typeEmail(String correo){
        WebElement userInputElement = driver.findElement(LoginPage.emailInput);
        userInputElement.sendKeys(correo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.submitButton));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passwordInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPage.submitButton).click();
    }

    public boolean isAlertDangerPresent(){
        try{
            WebElement errorLoginMessage = this.driver.findElement(LoginPage.loginAlertDanger);
            return errorLoginMessage.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }

}
