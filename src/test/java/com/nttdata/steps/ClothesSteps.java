package com.nttdata.steps;

import com.nttdata.page.ClothesPage;
import com.nttdata.page.InventoryPage;
import org.openqa.selenium.WebDriver;

public class ClothesSteps {

    private WebDriver driver;

    public ClothesSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Seleccionar subcategoria Men
     */
    public void clickSubCategoryBtn(){
        this.driver.findElement(ClothesPage.getSubCategory).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtener el nombre del boton de la subcategoria
     */
    public String getSubCategoryNameBtn(){
        return this.driver.findElement(ClothesPage.getSubCategory).getText();
    }
}
