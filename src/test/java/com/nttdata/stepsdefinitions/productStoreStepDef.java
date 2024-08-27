package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class productStoreStepDef {

    private WebDriver driver;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
        InventorySteps inventorySteps = new InventorySteps(driver);
        inventorySteps.clickLoginBtn();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeEmail(email);
        loginSteps.typePassword(password);
        screenShot();
        loginSteps.login();

        try {
            Thread.sleep(5000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isErrorLoginMessagePresent = loginSteps.isAlertDangerPresent();
        Assertions.assertFalse(isErrorLoginMessagePresent, "Error en el Login");


    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String expectedCategory, String expectedSubCategory) {
        InventorySteps inventorySteps = new InventorySteps(driver);
        //Validamos el btn de la categoría CLOTHES
        String categoryNameBtn = inventorySteps.getCategoryNameBtn();
        Assertions.assertEquals(expectedCategory.toLowerCase(), categoryNameBtn.toLowerCase());
        inventorySteps.clickCategoryBtn();
        screenShot();

        //Validamos el btn de la subcategoría Men
        ClothesSteps clothesSteps = new ClothesSteps(driver);
        String subCategoryNameBtn = clothesSteps.getSubCategoryNameBtn();
        Assertions.assertEquals(expectedSubCategory, subCategoryNameBtn);
        clothesSteps.clickSubCategoryBtn();
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {

        String cantidadProducto = String.valueOf(cantidad);

        MenSteps menSteps = new MenSteps(driver);
        menSteps.scrollDown();

        screenShot();

        menSteps.clickProductCard();

        ProductSteps productSteps = new ProductSteps(driver);
        screenShot();

        productSteps.scrollDown();
        productSteps.ingresarCantidadProducto(cantidadProducto);
        screenShot();
        productSteps.clickAddCartBtn();

    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {

        ProductSteps productSteps = new ProductSteps(driver);
        String modalMessage = productSteps.getModalSuccessMessage();
        String expectedMessage = "Producto añadido correctamente a su carrito de compra";
        Assertions.assertEquals(expectedMessage, modalMessage);
        screenShot();

    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        ProductSteps productSteps = new ProductSteps(driver);

        // Obtenemos la cantidad de productos del modal
        String modalQtyProduct = productSteps.getModalQtyProduct();
        int qtyProduct = Integer.parseInt(modalQtyProduct);
        System.out.println("Modal - Cantidad de productos: " + qtyProduct);

        // Obtenemos el precio unitario del producto agregado
        String modalPriceProduct = productSteps.getModalPriceProduct();
        modalPriceProduct = modalPriceProduct.replace("S/ ", "").trim();;
        double priceProduct = Double.parseDouble(modalPriceProduct);
        System.out.println("Modal - Precio unitario del producto: " + priceProduct);

        String modalCalculatedPrice = productSteps.getModalCalculatedPrice();
        modalCalculatedPrice = modalCalculatedPrice.replace("S/ ", "").trim();
        double calculatedPrice = Double.parseDouble(modalCalculatedPrice);
        System.out.println("Modal - Precio calculado mostrado en el modal: " + calculatedPrice);

        double expectedCalculatedPrice = qtyProduct * priceProduct;
        System.out.println("Modal - Precio calculado esperado: " + expectedCalculatedPrice);

        Assertions.assertEquals(expectedCalculatedPrice, calculatedPrice, 0.01);
        screenShot();

    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        ProductSteps productSteps = new ProductSteps(driver);
        productSteps.clickFinalizarCompra();
        screenShot();

    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        CarritoSteps carritoSteps = new CarritoSteps(driver);
        String carritoTitlePage = carritoSteps.getCarritoTitlePage();
        String expectedCarritoTitlePage = "CARRITO";
        Assertions.assertEquals(expectedCarritoTitlePage, carritoTitlePage );
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        CarritoSteps carritoSteps = new CarritoSteps(driver);

        // Obtenemos la cantidad de productos de la pagina del carrito
        String carritoQtyProduct = carritoSteps.getCarritoQtyProduct();

        System.out.println("*" + carritoQtyProduct);
        int qtyProductCarrito = Integer.parseInt(carritoQtyProduct);
        System.out.println("Carrito - Cantidad de productos: " + qtyProductCarrito);

        // Obtenemos el precio unitario del producto agregado en la pagina del carrito
        String carritoPriceProduct = carritoSteps.getCarritoPriceProduct();
        System.out.println(carritoPriceProduct);

        carritoPriceProduct = carritoPriceProduct.replace("S/ ", "").trim();
        System.out.println(carritoPriceProduct);

        double priceProductCarrito = Double.parseDouble(carritoPriceProduct);
        System.out.println("Modal - Precio unitario del producto: " + priceProductCarrito);

        //  Obtenemos el precio calculado de la pagina del carrito
        String carritoCalculatedPrice = carritoSteps.getCarritoCalculatedPrice();
        System.out.println(carritoCalculatedPrice);
        carritoCalculatedPrice = carritoCalculatedPrice.replace("S/ ", "").trim();
        System.out.println(carritoCalculatedPrice);
        double calculatedPriceCarrito = Double.parseDouble(carritoCalculatedPrice);
        System.out.println("Modal - Precio calculado mostrado en el modal: " + calculatedPriceCarrito);

        double expectedCarritoCalculatedPrice = qtyProductCarrito * priceProductCarrito;
        System.out.println("Modal - Precio calculado esperado: " + expectedCarritoCalculatedPrice);

        Assertions.assertEquals(expectedCarritoCalculatedPrice, calculatedPriceCarrito, 0.01);
        screenShot();

    }
}
