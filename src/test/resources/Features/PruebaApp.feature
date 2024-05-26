@FeatureUno
Feature: Validar funcionalidad de la calculadora

  Background:
    Given El usuario se encuentra en la aplicacion

    Scenario Outline: Realizar una operación matematica con los valores definidos
      When Ingresa los valores a operar "<operacion>" "<valorUno>", "<valorDos>"
      Then El sistema mostrara el resultado de la operación

      #operacion: sumar, restar, multiplicar
      Examples:
      |operacion   |valorUno|valorDos|
      |sumar       |250     |180     |
      |restar      |100     |40      |
      |multiplicar |5       |8       |
