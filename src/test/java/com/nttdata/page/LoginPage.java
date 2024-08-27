package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    // URL: https://qalab.bensg.com/store/pe/
    //Localizadores de elementos
    public static By emailInput = By.id("field-email");
    public static By passwordInput = By.id("field-password");
    public static By submitButton = By.id("submit-login");
    public static By loginAlertDanger = By.xpath("//*[@id=\"content\"]/section/div/ul/li");

}
