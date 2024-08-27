package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    // URL: https://qalab.bensg.com/store/pe/
    // Aqui obtengo los elementos de la página
    public static By loginBtn = By.cssSelector("a[title='Acceda a su cuenta de cliente']");

    public static By getCategory = By.xpath("//*[@id=\"category-3\"]/a");


}
