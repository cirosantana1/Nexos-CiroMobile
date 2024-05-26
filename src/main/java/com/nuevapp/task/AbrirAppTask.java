package com.nuevapp.task;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class AbrirAppTask implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        AppiumDriver<?> appiumDriver = getProxiedDriver();
        appiumDriver.launchApp();
    }

    public static AbrirAppTask openApp() {
        return Tasks.instrumented(AbrirAppTask.class);
    }

}
