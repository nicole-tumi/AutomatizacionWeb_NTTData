package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.nttdata.core.DriverManager.getDriver;

// Aqui se interactua con la interfaz tanto para enviar datos como para obtener

public class InventorySteps {

    private WebDriver driver;

    //constructor
    public InventorySteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Seleccionar el btn Iniciar sesion
     */
    public void clickLoginBtn(){
        this.driver.findElement(InventoryPage.loginBtn).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Seleccionar categoria Clothes
     */
    public void clickCategoryBtn(){
        this.driver.findElement(InventoryPage.getCategory).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCategoryNameBtn(){
        return this.driver.findElement(InventoryPage.getCategory).getText();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
