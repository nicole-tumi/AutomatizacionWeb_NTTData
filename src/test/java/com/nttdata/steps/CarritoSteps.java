package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.ClothesPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.WebDriver;

public class CarritoSteps {


    private WebDriver driver;

    public CarritoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el titulo de la página Carrito
     */
    public String getCarritoTitlePage(){

        String carritoTitlePage = this.driver.findElement(CarritoPage.getTitlePage).getText();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carritoTitlePage;
    }

    /**
     * Obtener el precio del producto de la pagina carrito
     */
    public String getCarritoPriceProduct(){
        String carritoPriceProduct = this.driver.findElement(CarritoPage.carritoPriceProduct).getText();
        //System.out.println("Carrito - precio del producto:" + carritoPriceProduct);
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carritoPriceProduct;
    }

    /**
     * Obtener la cantidad de unidades del producto de la pagina carrito
     */
    public String getCarritoQtyProduct(){
        String carritoQtyProduct = this.driver.findElement(CarritoPage.carritoQtyProduct).getAttribute("value");
        System.out.println("Carrito - cantidad de producto:" + carritoQtyProduct);
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carritoQtyProduct;
    }

    /**
     * Obtener el precio total calculado de la pagina de carrito
     */
    public String getCarritoCalculatedPrice(){
        String carritoCalculatedPrice = driver.findElement(CarritoPage.carritoCalculatedPrice).getText();
        //System.out.println("Carrito - precio calculado:" + carritoCalculatedPrice);
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carritoCalculatedPrice;
    }


}
