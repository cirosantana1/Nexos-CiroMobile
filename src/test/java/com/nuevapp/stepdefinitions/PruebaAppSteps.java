package com.nuevapp.stepdefinitions;

import com.nuevapp.questions.ValidaResultadoQuestions;
import com.nuevapp.task.AbrirAppTask;
import com.nuevapp.task.OperacionesTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PruebaAppSteps {

    @Given("El usuario se encuentra en la aplicacion")
    public void elUsuarioSeEncuentraEnLaAplicacion() {
        theActorCalled("Ciro").wasAbleTo(AbrirAppTask.openApp());
    }

    @When("Ingresa los valores a operar {string} {string}, {string}")
    public void ingresaLosValoresAOperar(String operacion, String valorUno, String valorDos) {
        theActorInTheSpotlight().attemptsTo(OperacionesTask.operacionesTask(operacion,valorUno, valorDos));
        Serenity.takeScreenshot();
    }

    @Then("El sistema mostrara el resultado de la operación")
    public void elSistemaMostraraElResultadoDeLaOperacion() {
        ValidaResultadoQuestions.validaResultadoQuestions().answeredBy(theActorInTheSpotlight());
        Serenity.takeScreenshot();
    }
}
