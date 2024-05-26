package com.nuevapp.questions;

import com.nuevapp.models.ValoresDTO;
import com.nuevapp.task.OperacionesTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.nuevapp.ui.CalculadoraPage.*;

public class ValidaResultadoQuestions implements Question<Boolean> {

    private static Logger logger = LoggerFactory.getLogger(OperacionesTask.class);

    @Override
    public Boolean answeredBy(Actor actor) {

        int valor1 = Integer.parseInt(ValoresDTO.getValorUno());
        int valor2 = Integer.parseInt(ValoresDTO.getValorDos());
        int resultado = Integer.parseInt(ValoresDTO.getValorResultado());

        boolean validator = false;
        String operacion = ValoresDTO.getOperacion();

        switch (operacion) {
            case "sumar":
                if(valor1 + valor2 == resultado){
                    logger.info("Suma exitosa");
                    validator = true;
                }else {
                    logger.info("xxxx Error en la suma xxxx");
                    validator = false;
                }
                break;
            case "restar":
                if(valor1 - valor2 == resultado){
                    logger.info("Resta exitosa");
                    validator = true;
                }else {
                    logger.info("xxxx Error en la resta xxxx");
                    validator = false;
                }
                break;
            case "multiplicar":
                if(valor1 * valor2 == resultado){
                    logger.info("Multiplicación exitosa");
                    validator = true;
                }else {
                    logger.info("xxxx Error en la multiplicación xxxx");
                    validator = false;
                }
                break;
            default:
                logger.info("No se específico ninguna opción valida");
                break;
        }

        if (!validator) {
            throw new AssertionError("La validación de la operación fallo");
        }

        return INPUT_VALORES.resolveFor(actor).isPresent();
    }

    public static ValidaResultadoQuestions validaResultadoQuestions() {
        return new ValidaResultadoQuestions();
    }

}
