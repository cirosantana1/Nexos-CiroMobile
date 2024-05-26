package com.nuevapp.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalculadoraPage {

    public static final Target INPUT_VALORES = Target.the("Input de valores")
            .located(By.xpath("//*[contains(@resource-id, 'id/calc_edt_formula')]"));
    public static final Target BTN_SUMA = Target.the("Boton sumar")
            .located(By.xpath("//*[contains(@resource-id, 'id/calc_keypad_btn_add')]"));
    public static final Target BTN_RESTA = Target.the("Boton resta")
            .located(By.xpath("//*[contains(@resource-id, 'id/calc_keypad_btn_sub')]"));
    public static final Target BTN_MULTIPLICACION = Target.the("Boton multiplicación")
            .located(By.xpath("//*[contains(@resource-id, 'id/calc_keypad_btn_mul')]"));
    public static final Target BTN_IGUAL = Target.the("Boton igual")
            .located(By.xpath("//android.widget.Button[@content-desc='Igual']"));


    public static final Target LOGO_META = Target.the("Logo para desbordar")
            .located(By.xpath("//android.view.View[@text='Más Servicios botón']"));

}
