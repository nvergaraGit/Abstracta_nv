@loginmercado
Feature: Feature_registroMercado

  Scenario: Ejercicio busqueda mercadolibre
    Given Listar autos y links
    When  Ingreso a Mercadolibre
    Then  Home se abre correctamente
    When  Se ingresa palabra de busqueda
    Then  entrega resultado en pantalla y archivo de texto


