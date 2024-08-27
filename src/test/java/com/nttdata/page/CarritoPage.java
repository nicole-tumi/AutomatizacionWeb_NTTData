package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {

    public static By getTitlePage = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");

    public static By carritoPriceProduct = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");

    public static By carritoQtyProduct = By.cssSelector(".js-cart-line-product-quantity");

    public static By carritoCalculatedPrice = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");

}
