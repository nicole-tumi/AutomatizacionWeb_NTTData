package com.nttdata.steps;

import com.nttdata.page.ClothesPage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.MenPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;

public class MenSteps {
    private WebDriver driver;

    public MenSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Seleccionar subcategoria Men
     */
    public void clickProductCard(){
        this.driver.findElement(MenPage.productCard).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
