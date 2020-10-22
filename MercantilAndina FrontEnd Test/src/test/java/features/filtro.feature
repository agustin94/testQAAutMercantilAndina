Feature: Realizar cotizacion en la pagina de mercantila andina
    como usuario quiero realizar una cotizacion de hogar llenando un form con mi nombre, email, telefono, vivienda, ubicacion y superficie
    que los elementos contenga “Seguro de hogar - Mercantil andina" en su title
    que el costo mensual sea un valor positivo, mayor a cero y entero
    que se visualice "Chat Online"

  Scenario: Realizar busqueda de articulo aplicando filtros
    Given el usuario se encuentra en la página home de Mercantil Andina
    And Se hace click en 'Personas', 'Seguros' y 'Hogar'
    And Presionamos el boton para ir al formulario de cotizacion
    When Llenamos el formulario
    And Validar que el costo mensual sea un valor positivo
    And Validar que el costo mensual sea mayor a 0
    And Validar que el costo mensual sea un entero
    And Validar que se visualice chat online
    And Se debe verificar 'Seguro de hogar - Mercantil andina' en su title



