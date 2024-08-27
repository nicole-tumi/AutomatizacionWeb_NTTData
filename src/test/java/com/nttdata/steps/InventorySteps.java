package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;

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
