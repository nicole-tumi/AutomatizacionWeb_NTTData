package com.nttdata.steps;

import com.nttdata.page.ProductPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;

public class ProductSteps {
    private WebDriver driver;

    public ProductSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Indicar cantidad de items de un producto
     */
    public void ingresarCantidadProducto(String cantidadProducto){
        this.driver.findElement(ProductPage.quantityInput).sendKeys(Keys.CONTROL + "a");
        this.driver.findElement(ProductPage.quantityInput).sendKeys(Keys.DELETE);
        this.driver.findElement(ProductPage.quantityInput).sendKeys(cantidadProducto);
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Seleccionar el btn Añadir al carrito
     */
    public void clickAddCartBtn(){
        this.driver.findElement(ProductPage.addCartBtn).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtener el mensaje de confirmacion al agregar el producto al carrito
     */
    public String getModalSuccessMessage(){
        String modalMessage = this.driver.findElement(ProductPage.modalTitle).getText();
        modalMessage = modalMessage.replace("", "").trim();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return modalMessage;
    }

    /**
     * Obtener el precio del producto en el modal de confirmación
     */
    public String getModalPriceProduct(){
        String modalPriceProduct = this.driver.findElement(ProductPage.modalPriceProduct).getText();
        System.out.println(modalPriceProduct);
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return modalPriceProduct;
    }

    /**
     * Obtener la cantidad de unidades del producto en el modal de confirmación
     */
    public String getModalQtyProduct(){
        String modalQtyProduct = this.driver.findElement(ProductPage.modalQtyProduct).getText();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return modalQtyProduct;
    }

    /**
     * Obtener el precio total calculado el modal de confirmación
     */
    public String getModalCalculatedPrice(){
        String modalCalculatedPrice = driver.findElement(ProductPage.modalCalculatedPrice).getText();
        System.out.println(modalCalculatedPrice);
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return modalCalculatedPrice;
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

    /**
     * Seleccionar el btn Finalizar compra
     */
    public void clickFinalizarCompra(){
        this.driver.findElement(ProductPage.modalFinishPurchase).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
