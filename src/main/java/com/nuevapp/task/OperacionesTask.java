package com.nuevapp.task;


import com.nuevapp.models.ValoresDTO;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.Performable;
import java.util.concurrent.TimeUnit;

import static com.nuevapp.ui.CalculadoraPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OperacionesTask implements Task {

    private static Logger logger = LoggerFactory.getLogger(OperacionesTask.class);

    private final String valor1;
    private final String valor2;
    private final String operacion;

    public OperacionesTask(String operacion, String valor1, String valor2) {
        this.operacion = operacion;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        char[] arrayUno = valor1.toCharArray();
        char[] arrayDos = valor2.toCharArray();

        for (char a1 : arrayUno) {
            actor.attemptsTo(Click.on(By.xpath("//android.widget.Button[@content-desc='" + a1 + "']")));
        }

        Serenity.takeScreenshot();

        switch (operacion) {
            case "sumar":
                actor.attemptsTo(
                        Click.on(BTN_SUMA));
                break;
            case "restar":
                actor.attemptsTo(
                        Click.on(BTN_RESTA));
                break;
            case "multiplicar":
                actor.attemptsTo(
                        Click.on(BTN_MULTIPLICACION));
                break;
            default:
                logger.info("No se específico ninguna opción valida");
                break;
        }

        Serenity.takeScreenshot();

            for (char a2 : arrayDos) {
                actor.attemptsTo(Click.on(By.xpath("//android.widget.Button[@content-desc='" + a2 + "']")));
            }

        Serenity.takeScreenshot();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("Interrupted! " + e);
                Thread.currentThread().interrupt();
            }

            actor.attemptsTo(Click.on(BTN_IGUAL));

        Serenity.takeScreenshot();

            ValoresDTO.setValorUno(valor1);
            ValoresDTO.setValorDos(valor2);
            ValoresDTO.setOperacion(operacion);


            String resultadoOP = INPUT_VALORES.resolveFor(actor).getText();

            StringBuilder numberStr = new StringBuilder();
            for (char c : resultadoOP.toCharArray()) {
            if (Character.isDigit(c)) {
                numberStr.append(c);}
            }

            ValoresDTO.setValorResultado(numberStr.toString());

        }

    public static Performable operacionesTask(String operacion, String valor1, String valor2){
        return instrumented(OperacionesTask.class,operacion,valor1, valor2);
    }
}
