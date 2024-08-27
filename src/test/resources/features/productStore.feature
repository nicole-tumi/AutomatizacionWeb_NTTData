#language: es
@testfeature
Característica: Product - Store

  @test
  Escenario: Validacion del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "nicoletumi2110@gmail.com" y clave "QA123*456"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

  @test
  Escenario: Validacion del precio de un producto con usuario y claves invalidos
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "123@gmail.com" y clave "QA0001"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

  @test
  Escenario: Validacion del precio de un producto con una categoria inexistente
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "nicoletumi2110@gmail.com" y clave "QA123*456"
    Cuando navego a la categoria "Autos" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito
