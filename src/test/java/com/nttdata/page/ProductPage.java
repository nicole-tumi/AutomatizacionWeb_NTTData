package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {

    public static By quantityInput = By.id("quantity_wanted");

    public static By addCartBtn = By.cssSelector("button.btn.btn-primary.add-to-cart");

    public static By modalTitle = By.cssSelector("h4.modal-title.h6.text-sm-center");

    public static By modalPriceProduct = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");

    public static By modalQtyProduct = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");

    public static By modalCalculatedPrice = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");

    public static By modalFinishPurchase = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
}