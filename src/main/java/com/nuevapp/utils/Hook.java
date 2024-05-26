package com.nuevapp.utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Hook {

    private static Logger logger = LoggerFactory.getLogger(Hook.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void metodoAfter(){
        try {
            AppiumDriver<?> appiumDriver = getProxiedDriver();
                appiumDriver.closeApp();
                logger.info("Se completo correctamente la desconexión del driver");
        } catch (Exception e) {
            logger.info("No se completo correctamente la desconexión del driver debido a: "+e.getMessage());
        }
    }


}
